package com.youcruit.ams.api.client.object;

import static org.junit.Assert.assertEquals;

import java.io.IOException;
import java.io.InputStream;

import org.codehaus.jackson.map.DeserializationConfig.Feature;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ProfessionListTest extends AbstractTest {
    private InputStream is;
    private Profession expected;
    private ProfessionList expectedList;

    @Before
    public void setUp() {
	is = Thread.currentThread().getContextClassLoader().getResourceAsStream("professions.json");
	om.configure(Feature.UNWRAP_ROOT_VALUE, true);
	expectedList = new ProfessionList();
	expected = new Profession();
	expected.setAmsId("4742");
	expected.setName("Bakteriolog");
	expected.setCount(0);
	expectedList.getList().add(expected);
	expected = new Profession();
	expected.setAmsId("6902");
	expected.setName("Bioinformatiker");
	expected.setCount(1);
	expectedList.getList().add(expected);
	expectedList.setCount(20);
	expectedList.setName("yrken");
    }

    @Test
    public void testParseAsList() throws IOException {
	ProfessionList actual = om.readValue(is, ProfessionList.class);
	assertEquals(expectedList, actual);
    }

    @After
    public void tearDown() throws IOException {
	is.close();
    }

}
