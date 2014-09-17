package com.youcruit.ams.api.client.object;

import static org.junit.Assert.assertEquals;

import java.io.IOException;
import java.io.InputStream;

import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class WorkplaceTest extends AbstractTest {
    private InputStream is;
    private Workplace expected;

    @Before
    public void setUp() {
	is = Thread.currentThread().getContextClassLoader().getResourceAsStream("workplace.json");
	expected = new Workplace();
	expected.setName("SWEDEN GREEN TRADING AB");
	expected.setPostalCode("13140");
	expected.setAdress("Kantatvägen 18");
	expected.setCity("Nacka");
	expected.setCountry("Sverige");
	expected.setVisitingAddress("Kantatvägen 18");
	expected.setVisitingCity("Nacka");
	expected.setVisitingCountry("Sverige");
	expected.setPhone("076-2899405");
	expected.setEmail("11111@3333.3333");
	Contact c = new Contact();
	c.setName("Sara Al-Amrri");
	c.setRole("Regionskoordinator");
	expected.getContacts().getContacts().add(c);
	expected.setHomepage("http://www.swedengreentrading.se");
	expected.setLogoUrl("api.arbetsformedlingen.se/platsannons/2535965/logotyp");
    }

    @Test
    public void testParseAd() throws JsonParseException, JsonMappingException, IOException {
	Workplace actual = om.readValue(is, Workplace.class);
	assertEquals(expected, actual);
    }
    
    @After
    public void tearDown() throws IOException {
	is.close();
    }
}
