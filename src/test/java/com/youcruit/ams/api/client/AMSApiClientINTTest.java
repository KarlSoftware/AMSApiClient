package com.youcruit.ams.api.client;

import com.youcruit.ams.api.client.object.Ad;
import com.youcruit.ams.api.client.object.MatchData;
import com.youcruit.ams.api.client.object.MatchDataList;
import org.junit.Test;

import java.io.IOException;
import java.net.URISyntaxException;

public class AMSApiClientINTTest {

    private static String amsApiUrl = "http://api.arbetsformedlingen.se";

    @Test
    public void testMatchDataListApiCall() throws IOException, URISyntaxException {
	AMSApiClient client = new AMSApiClient(amsApiUrl);
	AMSQuery query = new AMSQueryBuilder(AMSQuery.EndPoint.MATCHING).county(17).build();
	MatchDataList dataList;
	dataList = client.executeQuery(query, MatchDataList.class);

	for(MatchData d : dataList.getMatchDataList()) {
	    AMSQuery adQuery = new AMSQueryBuilder(AMSQuery.EndPoint.AD).id(d.getAdId()).build();
	    Ad ad = client.executeQuery(adQuery, Ad.class);
	    if(ad.getEmail() != null) {
		System.out.println(ad.getEmail());
	    }
	}
    }
}
