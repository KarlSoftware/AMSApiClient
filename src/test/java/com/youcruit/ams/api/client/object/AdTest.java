package com.youcruit.ams.api.client.object;

import static org.junit.Assert.assertEquals;

import java.io.IOException;
import java.io.InputStream;

import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.DeserializationConfig.Feature;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class AdTest {

    private InputStream is;
    private ObjectMapper om;
    private Ad expected;
    private Workplace workplace;
    private Application application;

    @Before
    public void setUp() {
	is = Thread.currentThread().getContextClassLoader().getResourceAsStream("ad.json");
	om = new ObjectMapper();
	om.configure(Feature.UNWRAP_ROOT_VALUE, true);
	expected = new Ad();
	application = new Application();
	application.setEmail("hasanin.farhan@swedengreentrading.se");
	expected.setApplication(application);
	workplace = new Workplace();
	workplace.setEmail("hasanin.farhan@swedengreentrading.se");
	expected.setWorkplace(workplace);
    }

    @Test
    public void testParseAd() throws JsonParseException, JsonMappingException, IOException {
	expected.setId("2534149");
	Ad actual = om.readValue(is, Ad.class);
	actual.setWorkplace(workplace);
	actual.setDetails(null);
	actual.setTerms(null);
	actual.setRequirement(null);
	assertEquals(expected, actual);
    }

    @After
    public void tearDown() throws IOException {
	is.close();
    }
}
