package com.youcruit.ams.api.client;

import com.fasterxml.jackson.dataformat.xml.JacksonXmlModule;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.youcruit.ams.api.client.deserializers.MatchListDeserializer;
import com.youcruit.ams.api.client.object.MatchDataList;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.conn.ClientConnectionManager;
import org.apache.http.entity.mime.FormBodyPart;
import org.apache.http.entity.mime.HttpMultipartMode;
import org.apache.http.entity.mime.MultipartEntity;
import org.apache.http.entity.mime.content.ContentBody;
import org.apache.http.entity.mime.content.StringBody;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.conn.tsccm.ThreadSafeClientConnManager;
import org.apache.http.params.HttpParams;
import org.apache.http.protocol.BasicHttpContext;
import org.apache.http.protocol.HttpContext;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.net.URISyntaxException;

public class AMSApiClient {


    private String amsBaseApiUrl;
    private XmlMapper xm;

    public AMSApiClient(final String amsBaseApiUrl){
	this.amsBaseApiUrl = amsBaseApiUrl;
	xm = new XmlMapper();
	JacksonXmlModule module = new JacksonXmlModule();
	module.addDeserializer(MatchDataList.class, new MatchListDeserializer());
	xm.registerModule(module);
    }

    private InputStream executeQuery(final AMSQuery query) throws IOException, URISyntaxException{
	DefaultHttpClient client = getClientInstance();
	HttpContext localContext = new BasicHttpContext();
	URI amsQueryUrl = new URI(amsBaseApiUrl + query.toString());
	HttpGet getData = new HttpGet(amsQueryUrl);
	getData.addHeader("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,*/*;q=0.8");
	getData.addHeader("Accept-Language", "en-US,en;q=0.8,da;q=0.6,nb;q=0.4,sv;q=0.2");
	getData.addHeader("Accept-Encoding","gzip,deflate,sdch");
	getData.addHeader("User-Agent", "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_9_4) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/37.0.2062.94 Safari/537.36");
	HttpResponse response = client.execute(getData, localContext);
	HttpEntity responseEntity = response.getEntity();
	return responseEntity.getContent();
    }

    private DefaultHttpClient getClientInstance() {
	DefaultHttpClient client = new DefaultHttpClient();
	ClientConnectionManager mgr = client.getConnectionManager();

	HttpParams params = client.getParams();
	client = new DefaultHttpClient(new ThreadSafeClientConnManager(mgr.getSchemeRegistry()), params);
	return client;
    }

    public <T> T executeQuery(final AMSQuery query, Class<T> clazz) throws IOException, URISyntaxException {
	InputStream is = executeQuery(query);
	T value = xm.readValue(is, clazz);
	return value;
    }
}
