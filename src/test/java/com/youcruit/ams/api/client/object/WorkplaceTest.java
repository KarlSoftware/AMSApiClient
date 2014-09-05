package com.youcruit.ams.api.client.object;

import static org.junit.Assert.*;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

public class WorkplaceTest {
    /*<arbetsplatsnamn>SWEDEN GREEN TRADING AB</arbetsplatsnamn>
	<postnummer>13140</postnummer>
	<postadress>Kantatvägen 18</postadress>
	<postort>Nacka</postort>
	<postland>Sverige</postland>
	<land>Sverige</land>
	<besoksadress>Kantatvägen 18</besoksadress>
	<besoksort>Nacka</besoksort>
	<telefonnummer>076-2899405</telefonnummer>
	<faxnummer />
	<epostadress>11111@3333.3333</epostadress>
	<hemsida>http://www.swedengreentrading.se</hemsida>*/
    private InputStream is;
    private ObjectMapper om;
    private Workplace expected;

    @Before
    public void setUp() {
	is = Thread.currentThread().getContextClassLoader().getResourceAsStream("workplace.xml");
	om = new XmlMapper();
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
	expected.getContacts().add(c);
	expected.setHomepage("http://www.swedengreentrading.se");
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
