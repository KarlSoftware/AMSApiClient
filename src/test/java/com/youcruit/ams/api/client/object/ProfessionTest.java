package com.youcruit.ams.api.client.object;

import static org.junit.Assert.assertEquals;

import java.io.IOException;
import java.io.InputStream;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ProfessionTest extends AbstractTest {
    private InputStream is;
    private Profession expected;

    @Before
    public void setUp() {
	is = Thread.currentThread().getContextClassLoader().getResourceAsStream("profession.json");
	expected = new Profession();
	expected.setCount(0);
	expected.setAmsId("4742");
	expected.setName("Bakteriolog");
    }

    @Test
    public void testParseDetails() throws IOException {
	Profession actual = om.readValue(is, Profession.class);
	assertEquals(expected, actual);
    }

    @After
    public void tearDown() throws IOException {
	is.close();
    }

}
