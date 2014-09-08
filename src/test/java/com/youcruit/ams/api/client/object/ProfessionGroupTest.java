package com.youcruit.ams.api.client.object;

import static org.junit.Assert.assertEquals;

import java.io.IOException;
import java.io.InputStream;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

public class ProfessionGroupTest {
    private InputStream is;
    private ObjectMapper om;
    private ProfessionGroup expected;

    @Before
    public void setUp() {
	is = Thread.currentThread().getContextClassLoader().getResourceAsStream("professiongroup.xml");
	om = new XmlMapper();
	expected = new ProfessionGroup();
	expected.setCount(1);
	expected.setName("Advokater");
	expected.setId("2611");
    }

    @Test
    public void testParseDetails() throws IOException {
	ProfessionGroup actual = om.readValue(is, ProfessionGroup.class);
	assertEquals(expected, actual);
    }

    @After
    public void tearDown() throws IOException {
	is.close();
    }

}
