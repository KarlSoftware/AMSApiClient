package com.youcruit.ams.api.client;

public class AMSQueryBuilder {

    private AMSQuery query;

    public AMSQueryBuilder(AMSQuery.EndPoint endPoint) {
	query = new AMSQuery(endPoint);
    }

    public AMSQueryBuilder id(String id) {
	query.addPath(id);
	return this;
    }

    public AMSQueryBuilder page(Integer pageId) {
	query.add("sida", pageId.toString());
	return this;
    }

    public AMSQueryBuilder county(County countyId) {
	query.add("lanid", countyId.getId());
	return this;
    }

    public AMSQueryBuilder profession(String professionId) {
	query.add("yrkesid", professionId);
	return this;
    }

    public AMSQueryBuilder professionCategory(String professionCategoryId) {
	query.add("yrkesomradeid", professionCategoryId);
	return this;
    }

    public AMSQueryBuilder professionSubCategory(String professionSubCategoryId) {
	query.add("yrkesgruppid", professionSubCategoryId);
	return this;
    }

    public AMSQueryBuilder municipality(String municipalityId) {
	query.add("kommunid", municipalityId);
	return this;
    }

    public AMSQueryBuilder continentPart(String continentPartId) {
	query.add("omradeid", continentPartId);
	return this;
    }

    public AMSQueryBuilder keyword(String freeTextKeyWord) {
	query.add("nyckelord", freeTextKeyWord);
	return this;
    }

    public AMSQueryBuilder country(String countryId) {
	query.add("landid", countryId);
	return this;
    }
    
    public AMSQuery build(){
	return query;
    }

}
