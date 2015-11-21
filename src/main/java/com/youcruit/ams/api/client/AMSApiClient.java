package com.youcruit.ams.api.client;

import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.net.URISyntaxException;

import org.apache.commons.io.IOUtils;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.conn.ClientConnectionManager;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.conn.tsccm.ThreadSafeClientConnManager;
import org.apache.http.params.HttpParams;
import org.apache.http.protocol.BasicHttpContext;
import org.apache.http.protocol.HttpContext;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.DeserializationConfig.Feature;

import com.youcruit.ams.api.client.serialization.AMSSerializationModule;

public class AMSApiClient {


    private String amsBaseApiUrl;
    private String from;
    private ObjectMapper xm;

    public AMSApiClient(final String amsBaseApiUrl, final String fromEmail){
	this.amsBaseApiUrl = amsBaseApiUrl;
	this.from = fromEmail;
	xm = new ObjectMapper();
	xm.configure(Feature.UNWRAP_ROOT_VALUE, true);
	xm.registerModule(new AMSSerializationModule());
    }

    private InputStream internalExecuteQuery(final AMSQuery query) throws IOException, URISyntaxException{
	DefaultHttpClient client = getClientInstance();
	HttpContext localContext = new BasicHttpContext();
	URI amsQueryUrl = new URI(amsBaseApiUrl + query.toString());
	HttpGet getData = new HttpGet(amsQueryUrl);
	getData.addHeader("Accept", "application/json");
	getData.addHeader("Accept-Language", "en-US,en;q=0.8,da;q=0.6,nb;q=0.4,sv;q=0.2");
	getData.addHeader("Accept-Encoding","gzip,deflate,sdch");
	getData.addHeader("User-Agent", "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_9_4) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/37.0.2062.94 Safari/537.36");
	getData.addHeader("From", from);
	HttpResponse response = client.execute(getData, localContext);
	HttpEntity responseEntity = response.getEntity();
	if(response.getStatusLine().getStatusCode() == HttpStatus.SC_OK){
	    return responseEntity.getContent();
	}else {
	    String content;
	    try {
		content = IOUtils.toString(response.getEntity().getContent());
	    } catch (IOException e) {
		content = "Caught IOException, while trying to read content: " + e.getMessage();
	    }
	    throw new AMSApiClientException(response, query, amsBaseApiUrl, content);
	}
    }

    private DefaultHttpClient getClientInstance() {
	DefaultHttpClient client = new DefaultHttpClient();
	ClientConnectionManager mgr = client.getConnectionManager();

	HttpParams params = client.getParams();
	client = new DefaultHttpClient(new ThreadSafeClientConnManager(mgr.getSchemeRegistry()), params);
	return client;
    }

    public <T> T executeQuery(final AMSQuery query, Class<T> clazz) throws IOException, URISyntaxException {
	try (InputStream is = internalExecuteQuery(query)) {
	    return xm.readValue(is, clazz);
	}
    }
}
