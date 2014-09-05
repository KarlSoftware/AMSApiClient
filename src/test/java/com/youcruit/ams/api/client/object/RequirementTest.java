package com.youcruit.ams.api.client.object;

import static org.junit.Assert.assertEquals;

import java.io.IOException;
import java.io.InputStream;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

public class RequirementTest {
    private InputStream is;
    private ObjectMapper om;
    private Requirement expected;

    @Before
    public void setUp() {
	is = Thread.currentThread().getContextClassLoader().getResourceAsStream("requirement.xml");
	om = new XmlMapper();
	expected = new Requirement();
	expected.setCarOwner(false);
	expected.getDriversLicenseClass().add("B");
    }

    @Test
    public void testParseDetails() throws IOException {
	Requirement actual = om.readValue(is, Requirement.class);
	assertEquals(expected, actual);
    }

    @After
    public void tearDown() throws IOException {
	is.close();
    }

}
