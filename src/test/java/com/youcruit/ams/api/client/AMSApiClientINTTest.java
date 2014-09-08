package com.youcruit.ams.api.client;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.HashMap;

import org.junit.Before;
import org.junit.Test;

import com.youcruit.ams.api.client.object.Ad;
import com.youcruit.ams.api.client.object.MatchData;
import com.youcruit.ams.api.client.object.MatchDataList;
import com.youcruit.ams.api.client.object.ProfessionCategory;
import com.youcruit.ams.api.client.object.ProfessionCategoryList;
import com.youcruit.ams.api.client.object.ProfessionSubCategory;
import com.youcruit.ams.api.client.object.ProfessionSubCategoryList;

public class AMSApiClientINTTest {

    private static String amsApiUrl = "http://api.arbetsformedlingen.se";
    private AMSApiClient client;
    private AMSQuery query;
    
    @Before
    public void setup(){
	client = new AMSApiClient(amsApiUrl);
	query = null;
    }

    @Test
    public void testMatchDataListApiCall() throws IOException, URISyntaxException {
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
	    for(MatchData d : dataList.getList()) {
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
    
    @Test
    public void testGetProfessionCategories() throws IOException, URISyntaxException {
	query = new AMSQueryBuilder(AMSQuery.EndPoint.PROFESSION_CATEGORIES).build();
	ProfessionCategoryList result = client.executeQuery(query, ProfessionCategoryList.class);
	System.out.println("Found " + result.getList().size() + " different categories. Number of positionopenings available total: " + result.getCount());
	for(ProfessionCategory pc : result.getList()){
	    System.out.println(pc);
	}
    }
    
    @Test
    public void testGetProfessionSubCategories() throws IOException, URISyntaxException {
	query = new AMSQueryBuilder(AMSQuery.EndPoint.PROFESSION_SUB_CATEGORIES).professionCategory(1).build();
	ProfessionSubCategoryList result = client.executeQuery(query, ProfessionSubCategoryList.class);
	System.out.println("Found " + result.getList().size() + " different categories. Number of positionopenings available total: " + result.getCount());
	for(ProfessionSubCategory pc : result.getList()){
	    System.out.println(pc);
	}
    }
}
