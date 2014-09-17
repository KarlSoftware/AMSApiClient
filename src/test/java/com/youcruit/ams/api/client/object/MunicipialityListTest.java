package com.youcruit.ams.api.client.object;

import static org.junit.Assert.assertEquals;

import java.io.IOException;
import java.io.InputStream;

import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.DeserializationConfig.Feature;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class MunicipialityListTest {
    private InputStream is;
    private ObjectMapper om;
    private Municipiality expected;
    private MunicipialityList expectedList;

    @Before
    public void setUp() {
	is = Thread.currentThread().getContextClassLoader().getResourceAsStream("municipialities.json");
	om = new ObjectMapper();
	om.configure(Feature.UNWRAP_ROOT_VALUE, true);
	expectedList = new MunicipialityList();
	expected = new Municipiality();
	expected.setName("Karlshamn");
	expected.setAmsId("1082");
	expected.setCount(34);
	expectedList.getList().add(expected);
	expectedList.setCount(241);
	expectedList.setName("kommuner");
    }

    @Test
    public void testParseAsList() throws IOException {
	MunicipialityList actual = om.readValue(is, MunicipialityList.class);
	assertEquals(expectedList, actual);
    }

    @After
    public void tearDown() throws IOException {
	is.close();
    }

}
