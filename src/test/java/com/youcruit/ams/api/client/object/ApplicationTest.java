package com.youcruit.ams.api.client.object;

import static org.junit.Assert.assertEquals;

import java.io.IOException;
import java.io.InputStream;
import java.util.Calendar;
import java.util.TimeZone;

import org.codehaus.jackson.map.ObjectMapper;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ApplicationTest {
    private InputStream is;
    private ObjectMapper om;
    private Application expected;

    @Before
    public void setUp() {
	om = new ObjectMapper();
	is = Thread.currentThread().getContextClassLoader().getResourceAsStream("application.json");
	expected = new Application();
	expected.setEmail("kontakt@modelhouse.se");
	expected.setReference("Säljare/värdinna");
	expected.setAdditionalInformation("Fast lön");
	Calendar cal = Calendar.getInstance(TimeZone.getTimeZone("Europe/Stockholm"));
	cal.set(Calendar.YEAR, 2014);
	cal.set(Calendar.MONTH, Calendar.SEPTEMBER);
	cal.set(Calendar.DAY_OF_MONTH, 14);
	cal.set(Calendar.HOUR_OF_DAY, 0);
	cal.set(Calendar.MINUTE, 0);
	cal.set(Calendar.SECOND, 0);
	cal.set(Calendar.MILLISECOND, 0);
	expected.setCloseDate(cal.getTime());
    }

    @Test
    public void testParseDetails() throws IOException {
	Application actual = om.readValue(is, Application.class);
	assertEquals(expected, actual);
    }

    @After
    public void tearDown() throws IOException {
	is.close();
    }

}
