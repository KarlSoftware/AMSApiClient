package com.youcruit.ams.api.client.object;

import static org.junit.Assert.assertEquals;

import java.io.IOException;
import java.io.InputStream;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TermsTest extends AbstractTest {
    private InputStream is;
    private Terms expected;

    @Before
    public void setUp() {
	is = Thread.currentThread().getContextClassLoader().getResourceAsStream("terms.json");
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
