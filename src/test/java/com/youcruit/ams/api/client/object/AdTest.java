package com.youcruit.ams.api.client.object;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import java.io.IOException;
import java.io.InputStream;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

public class AdTest {

    private InputStream is;
    private ObjectMapper om;
    private Ad expected;
    private Workplace workplace;
    private Application application;

    @Before
    public void setUp() {
	is = Thread.currentThread().getContextClassLoader().getResourceAsStream("ad.xml");
	om = new XmlMapper();
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
	Ad actual = om.readValue(is, Ad.class);
	actual.setWorkplace(workplace);
	actual.setDetails(null);
	actual.setTerms(null);
	assertEquals(expected, actual);
    }
    
    @Test
    public void testGetEmailFromApplication(){
	expected.setWorkplace(null);
	String email = "111111@22222.3333";
	expected.getApplication().setEmail(email);
	assertEquals(email, expected.getEmail());
    }
    
    @Test
    public void testGetEmailFromApplicationWorkPlaceNoEmail(){
	expected.getWorkplace().setEmail(null);
	String email = "111111@22222.3333";
	expected.getApplication().setEmail(email);
	assertEquals(email, expected.getEmail());
    }
    
    @Test
    public void testGetEmailFromApplicationWorkPlaceEmnptyEmail(){
	expected.getWorkplace().setEmail("");
	String email = "111111@22222.3333";
	expected.getApplication().setEmail(email);
	assertEquals(email, expected.getEmail());
    }
    
    @Test
    public void testGetEmailFromApplicationEmptyString(){
	expected.setWorkplace(null);
	expected.getApplication().setEmail("");
	assertNull(expected.getEmail());
    }
    
    @Test
    public void testGetEmailFromWorkplaceEmptyString(){
	expected.getWorkplace().setEmail("");
	expected.getApplication().setEmail("");
	assertNull(expected.getEmail());
    }
    
    @Test
    public void testGetEmailFromWorkplaceEmptyStringApplicationNull(){
	expected.getWorkplace().setEmail("");
	expected.setApplication(null);
	assertNull(expected.getEmail());
    }
    
    @Test
    public void testGetEmailFromApplicationNoApplication(){
	expected.setWorkplace(null);
	expected.setApplication(null);
	assertNull(expected.getEmail());
    }
    @Test
    public void testGetEmailFromWorkplace(){
	expected.setApplication(null);
	String email = "111111@22222.3333";
	expected.getWorkplace().setEmail(email);
	assertEquals(email, expected.getEmail());
    }
    
    @Test
    public void testGetEmailFromWorkplaceApplicationNoEmail(){
	expected.getApplication().setEmail(null);
	String email = "111111@22222.3333";
	expected.getWorkplace().setEmail(email);
	assertEquals(email, expected.getEmail());
    }
    
    @Test
    public void testGetEmailFromWorkplaceApplicationEmptyEmail(){
	expected.getApplication().setEmail("");
	String email = "111111@22222.3333";
	expected.getWorkplace().setEmail(email);
	assertEquals(email, expected.getEmail());
    }
    
    @After
    public void tearDown() throws IOException {
	is.close();
    }
    
    @Test
    public void testGetEmailPreferWorkPlace(){
	expected.getApplication().setEmail("1");
	expected.getWorkplace().setEmail("2");
	assertEquals("2", expected.getEmail(true));
    }
}
