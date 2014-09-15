package com.youcruit.ams.api.client.object;

import static org.junit.Assert.assertEquals;

import java.io.IOException;
import java.io.InputStream;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

public class ProfessionCategoryTest {
    private InputStream is;
    private ObjectMapper om;
    private SearchItem expected;

    @Before
    public void setUp() {
	is = Thread.currentThread().getContextClassLoader().getResourceAsStream("professioncategory.xml");
	om = new XmlMapper();
	expected = new ProfessionCategory();
	expected.setAmsId("1");
	expected.setName("Administration, ekonomi, juridik");
	expected.setCount(2013);
    }

    @Test
    public void testParseDetails() throws IOException {
	SearchItem actual = om.readValue(is, ProfessionCategory.class);
	assertEquals(expected, actual);
    }

    @After
    public void tearDown() throws IOException {
	is.close();
    }

}
