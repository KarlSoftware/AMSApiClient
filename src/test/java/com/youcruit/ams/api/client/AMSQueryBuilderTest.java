package com.youcruit.ams.api.client;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class AMSQueryBuilderTest {
    
    AMSQueryBuilder queryBuilder;
    
    @Before
    public void setup() {
	queryBuilder = new AMSQueryBuilder(AMSQuery.EndPoint.MATCHING);
    }

    @Test
    public void testId() {
	assertEquals(AMSQuery.EndPoint.MATCHING.getEndPoint() + "/1", queryBuilder.id("1").build().toString());
    }

    @Test
    public void testPage() {
	assertEquals(AMSQuery.EndPoint.MATCHING.getEndPoint() + "?sida=1", queryBuilder.page(1).build().toString());
    }

    @Test
    public void testCounty() {
	assertEquals(AMSQuery.EndPoint.MATCHING.getEndPoint() + "?lanid=1", queryBuilder.county(County.STOCKHOLM).build().toString());
    }

    @Test
    public void testProfession() {
	assertEquals(AMSQuery.EndPoint.MATCHING.getEndPoint() + "?yrkesid=5", queryBuilder.profession(5).build().toString());
    }

    @Test
    public void testProfessionCategory() {
	assertEquals(AMSQuery.EndPoint.MATCHING.getEndPoint() + "?yrkesomradeid=5", queryBuilder.professionCategory(5).build().toString());
    }

    @Test
    public void testProfessionSubCategory() {
	assertEquals(AMSQuery.EndPoint.MATCHING.getEndPoint() + "?yrkesgruppid=2131", queryBuilder.professionSubCategory(2131).build().toString());
    }

    @Test
    public void testMunicipality() {
	assertEquals(AMSQuery.EndPoint.MATCHING.getEndPoint() + "?kommunid=180", queryBuilder.municipality(180).build().toString());
    }

    @Test
    public void testContinentPart() {
	assertEquals(AMSQuery.EndPoint.MATCHING.getEndPoint() + "?omradeid=2", queryBuilder.continentPart(2).build().toString());
    }

    @Test
    public void testKeyword() {
	assertEquals(AMSQuery.EndPoint.MATCHING.getEndPoint() + "?nyckelord=bagare", queryBuilder.keyword("bagare").build().toString());
    }
    
    @Test
    public void testCountry(){
	assertEquals(AMSQuery.EndPoint.MATCHING.getEndPoint() + "?landid=59", queryBuilder.country(59).build().toString());
    }
    
    @Test
    public void multiQuery(){
	assertEquals(AMSQuery.EndPoint.MATCHING.getEndPoint() + "?landid=59&nyckelord=bagare", queryBuilder.country(59).keyword("bagare").build().toString());
    }
    
    @Test
    public void urlEncode(){
	assertEquals(AMSQuery.EndPoint.MATCHING.getEndPoint() + "?nyckelord=%C3%A5%C3%A4%C3%B6%C3%BC%2F%5Chttp%3A%2F%2F%3Fnyckelord%3Db%C3%A4gare", queryBuilder.keyword("åäöü/\\http://?nyckelord=bägare").build().toString());
    }
    
    @Test
    public void unicode() {
	assertEquals(AMSQuery.EndPoint.MATCHING.getEndPoint() + "?nyckelord=%E2%98%A2", queryBuilder.keyword("☢").build().toString());
    }
    
    @Test
    public void testProfessionSubCategoryQuery() {
	queryBuilder = new AMSQueryBuilder(AMSQuery.EndPoint.PROFESSION_SUB_CATEGORIES);
	assertEquals("/platsannons/soklista/yrkesgrupper?yrkesomradeid=1", queryBuilder.professionCategory(1).build().toString());
    }

}
