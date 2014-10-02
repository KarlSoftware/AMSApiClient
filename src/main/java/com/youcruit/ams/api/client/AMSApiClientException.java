package com.youcruit.ams.api.client;

import java.io.IOException;

import org.apache.http.HttpResponse;

public class AMSApiClientException extends IOException {
    private static final long serialVersionUID = 209583503848459181L;
    private int responseCode;
    public AMSApiClientException(final HttpResponse response, final AMSQuery query, String url, String content) {
	super("Server " + url + " responded with statuscode: " + response.getStatusLine().getStatusCode() + " for query: " + query.toString() + " \n " + content);
	setResponseCode(response.getStatusLine().getStatusCode());
    }
    public int getResponseCode() {
	return responseCode;
    }
    public void setResponseCode(int responseCode) {
	this.responseCode = responseCode;
    }
}
