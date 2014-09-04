package com.youcruit.ams.api.client;

import com.youcruit.ams.api.client.object.MatchDataList;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

public class AMSQuery {
    private static final String CHARSET_ENCODING = "UTF-8";
    private StringBuilder queryString;
    public enum EndPoint {
	MATCHING("/platsannons/matchning");

	private String endPoint;
	private EndPoint(String endPoint) {
	    this.endPoint = endPoint;
	}

	protected String getEndPoint() {
	    return this.endPoint;
	}
    }
    private EndPoint endPoint;
    
    AMSQuery(EndPoint endPoint) {
	queryString = new StringBuilder();
	this.endPoint = endPoint;
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
        return this.endPoint.getEndPoint() + queryString.toString();
    }
}
