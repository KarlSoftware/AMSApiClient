package com.youcruit.ams.api.client.object;

import static org.junit.Assert.assertEquals;

import java.io.IOException;
import java.io.InputStream;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ProfessionSubCategoryTest extends AbstractTest {
    private InputStream is;
    private ProfessionSubCategory expected;

    @Before
    public void setUp() {
	is = Thread.currentThread().getContextClassLoader().getResourceAsStream("professiongroup.json");
	expected = new ProfessionSubCategory();
	expected.setCount(1);
	expected.setName("Advokater");
	expected.setAmsId("2611");
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
