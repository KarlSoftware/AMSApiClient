package com.youcruit.ams.api.client.object;

import static org.junit.Assert.assertEquals;

import java.io.IOException;
import java.io.InputStream;

import org.codehaus.jackson.map.ObjectMapper;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ContactTest {
    private InputStream is;
    private ObjectMapper om;
    private Contact expected;

    @Before
    public void setUp() {
	is = Thread.currentThread().getContextClassLoader().getResourceAsStream("contact.json");
	om = new ObjectMapper();
	expected = new Contact();
	expected.setName("Sara Al-Amrri");
	expected.setRole("Regionskoordinator");
	expected.setMobilePhone("0766 34 89 79");
	expected.setPhone("07 66 34 89 79");
	expected.setPhone2(null);
	expected.setEmail("sara@backupevent.se");
	expected.setPhoneDescription(null);
	expected.setPhone2Description(null);
    }

    @Test
    public void testParseDetails() throws IOException {
	Contact actual = om.readValue(is, Contact.class);
	assertEquals(expected, actual);
    }

    @After
    public void tearDown() throws IOException {
	is.close();
    }

}
