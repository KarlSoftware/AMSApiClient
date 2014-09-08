package com.youcruit.ams.api.client.object;

import static org.junit.Assert.assertEquals;

import java.io.IOException;
import java.io.InputStream;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.fasterxml.jackson.dataformat.xml.XmlMapper;

public class ProfessionCategoryListTest {
    private InputStream is;
    private XmlMapper om;
    private ProfessionCategory expected;
    private ProfessionCategoryList expectedList;

    @Before
    public void setUp() {
	is = Thread.currentThread().getContextClassLoader().getResourceAsStream("professioncategories.xml");
	om = new XmlMapper();
	expectedList = new ProfessionCategoryList();
	expected = new ProfessionCategory();
	expected.setId("1");
	expected.setName("Administration, ekonomi, juridik");
	expected.setCount(2012);
	expectedList.getList().add(expected);
	expected = new ProfessionCategory();
	expected.setId("2");
	expected.setName("Bygg och anläggning");
	expected.setCount(915);
	expectedList.getList().add(expected);
	expectedList.setCount(23780);
	expectedList.setName("yrkesomraden");
    }

    @Test
    public void testParseAsList() throws IOException {
	ProfessionCategoryList actual = om.readValue(is, ProfessionCategoryList.class);
	assertEquals(expectedList, actual);
    }

    @After
    public void tearDown() throws IOException {
	is.close();
    }

}
