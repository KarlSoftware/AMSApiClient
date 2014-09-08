package com.youcruit.ams.api.client.object;

import static org.junit.Assert.assertEquals;

import java.io.IOException;
import java.io.InputStream;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

public class ProfessionSubCategoryTest {
    private InputStream is;
    private ObjectMapper om;
    private ProfessionSubCategory expected;

    @Before
    public void setUp() {
	is = Thread.currentThread().getContextClassLoader().getResourceAsStream("professiongroup.xml");
	om = new XmlMapper();
	expected = new ProfessionSubCategory();
	expected.setCount(1);
	expected.setName("Advokater");
	expected.setId("2611");
    }

    @Test
    public void testParseDetails() throws IOException {
	ProfessionSubCategory actual = om.readValue(is, ProfessionSubCategory.class);
	assertEquals(expected, actual);
    }

    @After
    public void tearDown() throws IOException {
	is.close();
    }

}
