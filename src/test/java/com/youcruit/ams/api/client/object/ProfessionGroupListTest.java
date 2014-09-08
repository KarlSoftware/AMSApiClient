package com.youcruit.ams.api.client.object;

import static org.junit.Assert.assertEquals;

import java.io.IOException;
import java.io.InputStream;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.fasterxml.jackson.dataformat.xml.XmlMapper;

public class ProfessionGroupListTest {
    private InputStream is;
    private XmlMapper om;
    private ProfessionGroup expected;
    private ProfessionGroupList expectedList;

    @Before
    public void setUp() {
	is = Thread.currentThread().getContextClassLoader().getResourceAsStream("professiongroups.xml");
	om = new XmlMapper();
	expectedList = new ProfessionGroupList();
	expected = new ProfessionGroup();
	expected.setId("2611");
	expected.setName("Advokater");
	expected.setCount(1);
	expectedList.getList().add(expected);
	expected = new ProfessionGroup();
	expected.setId("2614");
	expected.setName("Affärs- och företagsjurister");
	expected.setCount(17);
	expectedList.getList().add(expected);
	expectedList.setCount(2039);
	expectedList.setName("yrkesgrupper");
    }

    @Test
    public void testParseAsList() throws IOException {
	ProfessionGroupList actual = om.readValue(is, ProfessionGroupList.class);
	assertEquals(expectedList, actual);
    }

    @After
    public void tearDown() throws IOException {
	is.close();
    }

}
