package com.youcruit.ams.api.client;


public class AMSQueryBuilder {

    StringBuilder queryString;

    public AMSQueryBuilder() {
	queryString = new StringBuilder();
    }

    public AMSQueryBuilder page(Integer pageId) {
	addQuery("sida", pageId.toString());
	return this;
    }

    public AMSQueryBuilder county(Integer countyId) {
	addQuery("lanId", countyId.toString());
	return this;
    }

    public AMSQueryBuilder profession(Integer professionId) {
	addQuery("yrkesid", professionId.toString());
	return this;
    }

    public AMSQueryBuilder professionCategory(Integer professionCategoryId) {
	addQuery("yrkesgruppid", professionCategoryId);
	return this;
    }

    public AMSQueryBuilder professionSubCategory(Integer professionSubCategoryId) {
	return this;
    }

    public AMSQueryBuilder municipality(Integer municipalityId) {
	return this;
    }

    public AMSQueryBuilder continentPart(Integer continendPartId) {
	return this;
    }

    public AMSQueryBuilder keyword(String freeTextKeyWord) {
	return this;
    }

    private void addQuery(String queryParam, String value) {
	if(queryString.length() == 0) {
	    queryString.append("?").append(queryParam);
	} else {
	    queryString.append("&").append(queryParam);
	}
    }
}
