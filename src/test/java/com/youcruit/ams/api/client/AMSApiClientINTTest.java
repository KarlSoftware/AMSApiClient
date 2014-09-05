package com.youcruit.ams.api.client;

import com.youcruit.ams.api.client.object.Ad;
import com.youcruit.ams.api.client.object.MatchData;
import com.youcruit.ams.api.client.object.MatchDataList;
import org.junit.Test;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;

public class AMSApiClientINTTest {

    private static String amsApiUrl = "http://api.arbetsformedlingen.se";

    @Test
    public void testMatchDataListApiCall() throws IOException, URISyntaxException {
	AMSApiClient client = new AMSApiClient(amsApiUrl);
	AMSQuery query = new AMSQueryBuilder(AMSQuery.EndPoint.MATCHING).county(17).build();
	MatchDataList dataList = null;
	int numberOfPages = 1;
	int realCount = 0;
	ArrayList<String> emailAdresses = new ArrayList<String>();
	for(int i=1; i<=numberOfPages; i++) {
	    query = new AMSQueryBuilder(AMSQuery.EndPoint.MATCHING).county(17).page(i).build();
	    dataList = client.executeQuery(query, MatchDataList.class);
	    numberOfPages = dataList.getCountPages();
	    for(MatchData d : dataList.getMatchDataList()) {
		realCount++;
		AMSQuery adQuery = new AMSQueryBuilder(AMSQuery.EndPoint.AD).id(d.getAdId()).build();
		Ad ad = client.executeQuery(adQuery, Ad.class);
		if(ad.getEmail() != null) {
		    emailAdresses.add(ad.getEmail(true));
		    System.out.println(ad.getEmail(true));
		}
	    }
	}

	System.out.println("Found email adresses: " + emailAdresses.size());
	System.out.println("No entries by AMS: " + dataList.getCount());
	System.out.println("No entries real: " + realCount);
    }
}
