package com.youcruit.ams.api.client.object;

import static org.junit.Assert.assertEquals;

import java.io.IOException;
import java.io.InputStream;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class MunicipialityTest extends AbstractTest {
    private InputStream is;
    private Municipiality expected;

    @Before
    public void setUp() {
	is = Thread.currentThread().getContextClassLoader().getResourceAsStream("municipiality.json");
	expected = new Municipiality();
	expected.setName("Karlshamn");
	expected.setAmsId("1082");
	expected.setCount(34);
    }

    @Test
    public void testParseDetails() throws IOException {
	Municipiality actual = om.readValue(is, Municipiality.class);
	assertEquals(expected, actual);
    }

    @After
    public void tearDown() throws IOException {
	is.close();
    }

}
