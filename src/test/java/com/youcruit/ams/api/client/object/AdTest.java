package com.youcruit.ams.api.client.object;

import static org.junit.Assert.assertEquals;

import java.io.IOException;
import java.io.InputStream;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class AdTest extends AbstractListTest {

    private InputStream is;
    private Ad expected;
    private Workplace workplace;
    private Application application;

    @Before
    public void setUp() {
	is = Thread.currentThread().getContextClassLoader().getResourceAsStream("ad.json");
	expected = new Ad();
	application = new Application();
	application.setEmail("hasanin.farhan@swedengreentrading.se");
	expected.setApplication(application);
	workplace = new Workplace();
	workplace.setEmail("hasanin.farhan@swedengreentrading.se");
	expected.setWorkplace(workplace);
	Contact contact = new Contact();
	contact.setEmail("lena.grahn@partner.verisure.se");
	contact.setName("Lena Grahn");
	contact.setRole("Operativ chef");
	contact.setMobilePhone("0703-53 83 49");
	contact.setPhone("");
	contact.setPhone2("");
	contact.setPhoneDescription("");
	contact.setPhone2Description("");
	workplace.getContacts().getContacts().add(contact);
    }

    @Test
    public void testParseAd() throws IOException {
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
