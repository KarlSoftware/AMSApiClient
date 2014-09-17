package com.youcruit.ams.api.client.object;

import static org.junit.Assert.assertEquals;

import java.io.IOException;
import java.io.InputStream;

import org.codehaus.jackson.map.ObjectMapper;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class RequirementTest extends AbstractTest {
    private InputStream is;
    private ObjectMapper om;
    private Requirement expected;

    @Before
    public void setUp() {
	is = Thread.currentThread().getContextClassLoader().getResourceAsStream("requirement.json");
	expected = new Requirement();
	expected.setCarOwner(false);
	expected.getDriversLicenseClass().getDriversLicenseClasses().add("B");
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
