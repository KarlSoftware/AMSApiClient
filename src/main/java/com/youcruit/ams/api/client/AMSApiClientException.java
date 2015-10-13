package com.youcruit.ams.api.client;

import java.io.IOException;

public class AMSApiClientException extends IOException {
    private static final long serialVersionUID = 209583503848459181L;
    private int responseCode;
    public AMSApiClientException(final int statusCode, final AMSQuery query, String url, String content) {
	super("Server " + url + " responded with statuscode: " + statusCode + " for query: " + query.toString() + " \n " + content);
	setResponseCode(statusCode);
    }
    public int getResponseCode() {
	return responseCode;
    }
    public void setResponseCode(int responseCode) {
	this.responseCode = responseCode;
    }
}
