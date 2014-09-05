package com.youcruit.ams.api.client;

import com.youcruit.ams.api.client.object.Ad;
import com.youcruit.ams.api.client.object.MatchData;
import com.youcruit.ams.api.client.object.MatchDataList;
import org.junit.Test;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.HashMap;

public class AMSApiClientINTTest {

    private static String amsApiUrl = "http://api.arbetsformedlingen.se";

    @Test
    public void testMatchDataListApiCall() throws IOException, URISyntaxException {
	AMSApiClient client = new AMSApiClient(amsApiUrl);
	AMSQuery query;
	MatchDataList dataList = null;
	int numberOfPages = 1;
	int realCount = 0;
	int countDupes = 0;
	HashMap<String, String> adNames = new HashMap<String,String>();
	for(int i=1; i<=numberOfPages; i++) {
	    query = new AMSQueryBuilder(AMSQuery.EndPoint.MATCHING).county(County.VARMLAND).page(i).build();
	    dataList = client.executeQuery(query, MatchDataList.class);
	    if(i == 1) {
		numberOfPages = dataList.getCountPages();
	    }
	    for(MatchData d : dataList.getMatchDataList()) {
		realCount++;
		AMSQuery adQuery = new AMSQueryBuilder(AMSQuery.EndPoint.AD).id(d.getAdId()).build();
		Ad ad = client.executeQuery(adQuery, Ad.class);
		if(ad.getApplication() != null) {
		    if(adNames.put(ad.getWorkplace().getName(), ad.getWorkplace().getName()) != null) {
			countDupes++;
		    }
		}
	    }
	}
	System.out.println("Found ads: " + adNames.size());
	System.out.println("No entries by AMS: " + dataList.getCount());
	System.out.println("No entries real: " + realCount);
	System.out.println("No dupes: " + countDupes);
    }
}
