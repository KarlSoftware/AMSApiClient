package com.youcruit.ams.api.client;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
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

import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.net.URISyntaxException;

public class AMSApiClient {


    private final String amsBaseApiUrl;

    public AMSApiClient(final String amsBaseApiUrl){
	this.amsBaseApiUrl = amsBaseApiUrl;
    }

    private InputStream executeQuery(ContentBody content) throws ClientProtocolException, IOException, URISyntaxException{
	DefaultHttpClient client = getClientInstance();
	HttpContext localContext = new BasicHttpContext();
	URI upload_url = new URI(amsBaseApiUrl);
	HttpPost upload = new HttpPost(upload_url);

	MultipartEntity entity = new MultipartEntity(HttpMultipartMode.BROWSER_COMPATIBLE);
	entity.addPart(FORM_PART_NAME_FILE, content);
	entity.addPart(new FormBodyPart(FORM_PART_NAME_USERNAME, new StringBody(username)));
	entity.addPart(new FormBodyPart(FORM_PART_NAME_ACCOUNT, new StringBody(account)));
	entity.addPart(new FormBodyPart(FORM_PART_NAME_PASSWORD, new StringBody(password)));
	upload.setEntity(entity);
	HttpResponse response = client.execute(upload, localContext);

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
}
