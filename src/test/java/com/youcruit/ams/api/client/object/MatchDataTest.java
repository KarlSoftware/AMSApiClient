package com.youcruit.ams.api.client.object;

import static org.junit.Assert.assertEquals;

import java.io.IOException;
import java.io.InputStream;
import java.util.Calendar;
import java.util.TimeZone;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class MatchDataTest extends AbstractTest {
    private InputStream is;
    private MatchData expected;

    @Before
    public void setUp() {
	is = Thread.currentThread().getContextClassLoader().getResourceAsStream("MatchData.json");
	expected = new MatchData();
	expected.setAdId("2534149");
	expected.setAdHeader("Taxiförare / Hela Stockholm / Taxikurir");
	expected.setProfessionName("Taxiförare/Taxichaufför");
	expected.setEmployerName("SWEDEN GREEN TRADING AB");
	expected.setMunicipialityName("Stockholm");
	Calendar cal = Calendar.getInstance(TimeZone.getTimeZone("Europe/Stockholm"));
	cal.set(Calendar.YEAR, 2014);
	cal.set(Calendar.MONTH, Calendar.SEPTEMBER);
	cal.set(Calendar.DAY_OF_MONTH, 4);
	cal.set(Calendar.HOUR_OF_DAY, 0);
	cal.set(Calendar.MINUTE, 0);
	cal.set(Calendar.SECOND, 0);
	cal.set(Calendar.MILLISECOND, 0);
	expected.setPublished(cal.getTime());
	expected.setRelevance(100);
	expected.setCountOpenings(2);
    }

    @Test
    public void testParseMatchData() throws IOException {
	MatchData actual = om.readValue(is, MatchData.class);
	assertEquals(expected, actual);
    }

    @After
    public void tearDown() throws IOException {
	is.close();
    }

}
