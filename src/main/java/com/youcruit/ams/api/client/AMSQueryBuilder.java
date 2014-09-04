package com.youcruit.ams.api.client;

public class AMSQueryBuilder {

    private AMSQuery query;

    public AMSQueryBuilder(AMSQuery.EndPoint endPoint) {
	query = new AMSQuery(endPoint);
    }

    public AMSQueryBuilder page(Integer pageId) {
	query.add("sida", pageId.toString());
	return this;
    }

    public AMSQueryBuilder county(Integer countyId) {
	query.add("lanid", countyId.toString());
	return this;
    }

    public AMSQueryBuilder profession(Integer professionId) {
	query.add("yrkesid", professionId.toString());
	return this;
    }

    public AMSQueryBuilder professionCategory(Integer professionCategoryId) {
	query.add("yrkesomradeid", professionCategoryId.toString());
	return this;
    }

    public AMSQueryBuilder professionSubCategory(Integer professionSubCategoryId) {
	query.add("yrkesgruppid", professionSubCategoryId.toString());
	return this;
    }

    public AMSQueryBuilder municipality(Integer municipalityId) {
	query.add("kommunid", municipalityId.toString());
	return this;
    }

    public AMSQueryBuilder continentPart(Integer continentPartId) {
	query.add("omradeid", continentPartId.toString());
	return this;
    }

    public AMSQueryBuilder keyword(String freeTextKeyWord) {
	query.add("nyckelord", freeTextKeyWord);
	return this;
    }

    public AMSQueryBuilder country(Integer countryId) {
	query.add("landid", countryId.toString());
	return this;
    }
    
    public AMSQuery build(){
	return query;
    }

}
