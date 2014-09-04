package com.youcruit.ams.api.client;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;


public class AMSQueryBuilder {

    private static final String CHARSET_ENCODING = "UTF-8";
    private StringBuilder queryString;

    public AMSQueryBuilder() {
	queryString = new StringBuilder();
    }

    public AMSQueryBuilder page(Integer pageId) {
	addQuery("sida", pageId.toString());
	return this;
    }

    public AMSQueryBuilder county(Integer countyId) {
	addQuery("lanid", countyId.toString());
	return this;
    }

    public AMSQueryBuilder profession(Integer professionId) {
	addQuery("yrkesid", professionId.toString());
	return this;
    }

    public AMSQueryBuilder professionCategory(Integer professionCategoryId) {
	addQuery("yrkesomradeid", professionCategoryId.toString());
	return this;
    }

    public AMSQueryBuilder professionSubCategory(Integer professionSubCategoryId) {
	addQuery("yrkesgruppid", professionSubCategoryId.toString());
	return this;
    }

    public AMSQueryBuilder municipality(Integer municipalityId) {
	addQuery("kommunid", municipalityId.toString());
	return this;
    }

    public AMSQueryBuilder continentPart(Integer continentPartId) {
	addQuery("omradeid", continentPartId.toString());
	return this;
    }

    public AMSQueryBuilder keyword(String freeTextKeyWord) {
	addQuery("nyckelord", freeTextKeyWord);
	return this;
    }

    public AMSQueryBuilder country(Integer countryId) {
	addQuery("landid", countryId.toString());
	return this;
    }
    
    public String build(){
	return queryString.toString();
    }

    private void addQuery(String queryParam, String value) {
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
}
