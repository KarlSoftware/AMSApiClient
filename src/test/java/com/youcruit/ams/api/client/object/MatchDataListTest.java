package com.youcruit.ams.api.client.object;

import static org.junit.Assert.assertEquals;

import java.io.IOException;
import java.io.InputStream;
import java.util.Calendar;
import java.util.TimeZone;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.dataformat.xml.JacksonXmlModule;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

public class MatchDataListTest {
    private InputStream is;
    private XmlMapper om;
    private MatchData expected;
    private MatchList expectedList;

    @Before
    public void setUp() {
	is = Thread.currentThread().getContextClassLoader().getResourceAsStream("MatchDataList.xml");
	om = new XmlMapper();
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
	expectedList = new MatchList();
	expectedList.getMatchDataList().add(expected);
	expectedList.setCount(8440);
	expectedList.setCountExact(8440);
	expectedList.setCountAdjacent(0);
	expectedList.setCountPages(422);
	expected = new MatchData();
	expected.setAdId("2535235");
	expected.setAdHeader("Däckmontör säsong");
	expected.setProfessionName("Däckmontör/Däck- och hjulmekaniker");
	expected.setEmployerName("JOAKIM ERIKSSON BIL AB");
	expected.setMunicipialityName("Botkyrka");
	expected.setPublished(cal.getTime());
	expected.setRelevance(100);
	expected.setCountOpenings(3);
	expectedList.getMatchDataList().add(expected);
    }

    @Test
    public void testParseAddress() throws JsonParseException, JsonMappingException, IOException {
	MatchList actual = om.readValue(is, MatchList.class);
	assertEquals(expectedList, actual);
    }

    @Test
    public void testParseAsList() throws JsonParseException, JsonMappingException, IOException {
	JacksonXmlModule module = new JacksonXmlModule();
	module.addDeserializer(MatchList.class, new MatchListDeserializer());
	om.registerModule(module);
	MatchList actual = om.readValue(is, MatchList.class);
	assertEquals(expectedList, actual);
    }

    @After
    public void tearDown() throws IOException {
	is.close();
    }

}
