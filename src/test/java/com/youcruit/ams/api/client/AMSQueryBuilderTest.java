package com.youcruit.ams.api.client;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class AMSQueryBuilderTest {
    
    AMSQueryBuilder queryBuilder;
    
    @Before
    public void setup() {
	queryBuilder = new AMSQueryBuilder();
    }

    @Test
    public void testPage() {
	assertEquals("?sida=1", queryBuilder.page(1).build().toString());
    }

    @Test
    public void testCounty() {
	assertEquals("?lanid=5", queryBuilder.county(5).build().toString());
    }

    @Test
    public void testProfession() {
	assertEquals("?yrkesid=5", queryBuilder.profession(5).build().toString());
    }

    @Test
    public void testProfessionCategory() {
	assertEquals("?yrkesomradeid=5", queryBuilder.professionCategory(5).build().toString());
    }

    @Test
    public void testProfessionSubCategory() {
	assertEquals("?yrkesgruppid=2131", queryBuilder.professionSubCategory(2131).build().toString());
    }

    @Test
    public void testMunicipality() {
	assertEquals("?kommunid=180", queryBuilder.municipality(180).build().toString());
    }

    @Test
    public void testContinentPart() {
	assertEquals("?omradeid=2", queryBuilder.continentPart(2).build().toString());
    }

    @Test
    public void testKeyword() {
	assertEquals("?nyckelord=bagare", queryBuilder.keyword("bagare").build().toString());
    }
    
    @Test
    public void testCountry(){
	assertEquals("?landid=59", queryBuilder.country(59).build().toString());
    }
    
    @Test
    public void multiQuery(){
	assertEquals("?landid=59&nyckelord=bagare", queryBuilder.country(59).keyword("bagare").build().toString());
    }
    
    @Test
    public void urlEncode(){
	assertEquals("?nyckelord=%C3%A5%C3%A4%C3%B6%C3%BC%2F%5Chttp%3A%2F%2F%3Fnyckelord%3Db%C3%A4gare", queryBuilder.keyword("åäöü/\\http://?nyckelord=bägare").build().toString());
    }
    
    @Test
    public void unicode() {
	assertEquals("?nyckelord=%E2%98%A2", queryBuilder.keyword("☢").build().toString());
    }

}
