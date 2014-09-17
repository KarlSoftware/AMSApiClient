package com.youcruit.ams.api.client.object;

import static org.junit.Assert.assertEquals;

import java.io.IOException;
import java.io.InputStream;

import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.DeserializationConfig.Feature;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ProfessionSubCategoryListTest {
    private InputStream is;
    private ObjectMapper om;
    private ProfessionSubCategory expected;
    private ProfessionSubCategoryList expectedList;

    @Before
    public void setUp() {
	is = Thread.currentThread().getContextClassLoader().getResourceAsStream("professiongroups.json");
	om = new ObjectMapper();
	om.configure(Feature.UNWRAP_ROOT_VALUE, true);
	expectedList = new ProfessionSubCategoryList();
	expected = new ProfessionSubCategory();
	expected.setAmsId("2611");
	expected.setName("Advokater");
	expected.setCount(1);
	expectedList.getList().add(expected);
	expected = new ProfessionSubCategory();
	expected.setAmsId("2614");
	expected.setName("Affärs- och företagsjurister");
	expected.setCount(17);
	expectedList.getList().add(expected);
	expectedList.setCount(2039);
	expectedList.setName("yrkesgrupper");
    }

    @Test
    public void testParseAsList() throws IOException {
	ProfessionSubCategoryList actual = om.readValue(is, ProfessionSubCategoryList.class);
	assertEquals(expectedList, actual);
    }

    @After
    public void tearDown() throws IOException {
	is.close();
    }

}
