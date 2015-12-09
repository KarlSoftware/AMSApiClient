package com.youcruit.ams.api.client;

import java.net.MalformedURLException;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.youcruit.ams.api.soap.Article;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.youcruit.ams.api.soap.Occupation;
import com.youcruit.ams.api.soap.OccupationList;
import com.youcruit.ams.api.soap.RelatedOccupation;
import com.youcruit.ams.api.soap.WSOccupationSoap;

public class SoapINTTest {

    private WSOccupationSoap wsOccupationSoap;
    private final Gson gson = new GsonBuilder().setPrettyPrinting().create();

    @BeforeClass
    public static void setupDump() throws ClassNotFoundException, NoSuchFieldException, IllegalAccessException {
	//Class.forName("com.sun.xml.internal.ws.transport.http.client.HttpTransportPipe").getField("dump").set(null, true);
    }

    @Before
    public void setup() throws MalformedURLException {
	wsOccupationSoap = AMSSoapClient.createClient();
    }

    @Test
    public void getOccupations() {
	OccupationList allOccupations = wsOccupationSoap.getAllOccupationsDetailed();
	//wsOccupationSoap.getAllOccupations().getOccupation().get(0).getArticles().getArticleLink().get(0);

	Occupation occupationToCheck = allOccupations.getOccupation().get(0);
	//System.err.println(wsOccupationSoap.loadAllOccupationIdAndName());
	//System.err.println(wsOccupationSoap.loadAllEducationConnections());
	for (RelatedOccupation relatedOccupation : occupationToCheck.getRelatedOccupations().getRelatedOccupation()) {
	    Occupation occupationById = wsOccupationSoap.getOccupationById(relatedOccupation.getId().intValue());
	    System.out.println(occupationById);
	}

	String localeGroups = wsOccupationSoap.getLocaleGroups(696);
	System.out.println(gson.toJson(allOccupations));
    }

    @Test
    public void getOccupation() {
	Occupation occupationById = wsOccupationSoap.getOccupationById(696);
	System.err.println(gson.toJson(occupationById));
    }

    @Test
    public void getAds() {
	Article result = wsOccupationSoap.getArticle(2817199);
	System.err.println(result);
    }
}
