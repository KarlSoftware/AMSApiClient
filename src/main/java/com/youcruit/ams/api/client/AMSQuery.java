package com.youcruit.ams.api.client;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

public class AMSQuery {
    private static final String CHARSET_ENCODING = "UTF-8";
    private StringBuilder queryString;
    
    AMSQuery() {
	queryString = new StringBuilder();
    }
    void add(String queryParam, String value) {
	if(queryString.length() == 0) {
	    queryString.append("?");
	} else {
	    queryString.append("&");
	}
	try {
	    queryString.append(queryParam).append("=").append(URLEncoder.encode(value, CHARSET_ENCODING));
	} catch (UnsupportedEncodingException e) {
	    throw new RuntimeException(e);
	}
    }
    @Override
    public String toString() {
        return queryString.toString();
    }
    public StringBuilder toStringBuilder() {
	return queryString;
    }
}
