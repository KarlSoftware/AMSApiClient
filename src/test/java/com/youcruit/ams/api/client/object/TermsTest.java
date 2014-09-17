package com.youcruit.ams.api.client.object;

import static org.junit.Assert.assertEquals;

import java.io.IOException;
import java.io.InputStream;

import org.codehaus.jackson.map.ObjectMapper;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TermsTest {
    private InputStream is;
    private ObjectMapper om;
    private Terms expected;

    @Before
    public void setUp() {
	is = Thread.currentThread().getContextClassLoader().getResourceAsStream("terms.json");
	om = new ObjectMapper();
	expected = new Terms();
	expected.setPermanency("Tillsvidare");
	expected.setWorkingTime("Heltid/Deltid");
	expected.setWorkingTimePermanency("Tillsvidare/Heltid/Deltid");
	expected.setWageType("Rörlig lön");
	expected.setWageText("Rörlig lön");
    }

    @Test
    public void testParseDetails() throws IOException {
	Terms actual = om.readValue(is, Terms.class);
	assertEquals(expected, actual);
    }

    @After
    public void tearDown() throws IOException {
	is.close();
    }

}
