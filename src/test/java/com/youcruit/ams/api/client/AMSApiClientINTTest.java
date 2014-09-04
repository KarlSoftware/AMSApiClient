package com.youcruit.ams.api.client;

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
	System.out.println("No of items inte the list: " + dataList.getMatchDataList().size());
    }
}
