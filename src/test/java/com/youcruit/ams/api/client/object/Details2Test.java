package com.youcruit.ams.api.client.object;

import static org.junit.Assert.assertEquals;

import java.io.IOException;
import java.io.InputStream;
import java.util.Calendar;
import java.util.TimeZone;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class Details2Test extends AbstractTest{
    private InputStream is;
    private Details expected;

    @Before
    public void setUp() {
	is = Thread.currentThread().getContextClassLoader().getResourceAsStream("details2.json");
	expected = new Details();
	expected.setAdId("2534149");
	expected.setAdHeader("Taxiförare/Hela Stockholm/Taxikurir");
	expected.setDescription("description");
	expected.setProfessionName("Taxiförare/Taxichaufför");
	expected.setProfessionId("6242");
	expected.setMunicipialityName("Stockholm");
	Calendar cal = Calendar.getInstance(TimeZone.getTimeZone("Europe/Stockholm"));
	cal.set(Calendar.YEAR, 2017);
	cal.set(Calendar.MONTH, Calendar.MAY);
	cal.set(Calendar.DAY_OF_MONTH, 3);
	cal.set(Calendar.HOUR_OF_DAY, 12);
	cal.set(Calendar.MINUTE, 20);
	cal.set(Calendar.SECOND, 36);
	cal.set(Calendar.MILLISECOND, 360);
	expected.setPublished(cal.getTime());
	expected.setCountOpenings(2);
    }

    @Test
    public void testParseDetailsWithFuckedDate() throws IOException {
	Details actual = om.readValue(is, Details.class);
	assertEquals(expected, actual);
    }

    @After
    public void tearDown() throws IOException {
	is.close();
    }

}
