package com.youcruit.ams.api.client.object;

import static org.junit.Assert.assertEquals;

import java.io.IOException;
import java.io.InputStream;

import org.codehaus.jackson.map.ObjectMapper;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class MunicipialityTest {
    private InputStream is;
    private ObjectMapper om;
    private Municipiality expected;

    @Before
    public void setUp() {
	is = Thread.currentThread().getContextClassLoader().getResourceAsStream("municipiality.json");
	om = new ObjectMapper();
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
