package com.youcruit.ams.api.client;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;

import com.youcruit.ams.api.client.object.Ad;
import com.youcruit.ams.api.client.object.MatchData;
import com.youcruit.ams.api.client.object.MatchDataList;
import com.youcruit.ams.api.client.object.Municipiality;
import com.youcruit.ams.api.client.object.MunicipialityList;
import com.youcruit.ams.api.client.object.Profession;
import com.youcruit.ams.api.client.object.ProfessionCategory;
import com.youcruit.ams.api.client.object.ProfessionCategoryList;
import com.youcruit.ams.api.client.object.ProfessionList;
import com.youcruit.ams.api.client.object.ProfessionSubCategory;
import com.youcruit.ams.api.client.object.ProfessionSubCategoryList;

public class AMSApiClientINTTest {

    private static String amsApiUrl = "http://api.arbetsformedlingen.se";
    private static String from = "inttest@youcruit.com";
    private AMSApiClient client;
    private AMSQuery query;

    @Before
    public void setup() {
	client = new AMSApiClient(amsApiUrl, from);
	query = null;
    }

    @Test
    public void testMatchDataListApiCall() throws IOException, URISyntaxException {
	MatchDataList dataList = null;
	int numberOfPages = 1;
	int realCount = 0;
	int countDupes = 0;
	HashMap<String, String> adNames = new HashMap<String, String>();
	for (int i = 1; i <= numberOfPages; i++) {
	    System.out.println("Fetching Searchresults for page " + i);
	    query = new AMSQueryBuilder(AMSQuery.EndPoint.MATCHING).county(County.VARMLAND).page(i).build();

	    dataList = client.executeQuery(query, MatchDataList.class);
	    if (i == 1) {
		numberOfPages = dataList.getCountPages();
		System.out.println("Found " + numberOfPages + " pages");
	    }
	    for (MatchData d : dataList.getList()) {
		realCount++;
		AMSQuery adQuery = new AMSQueryBuilder(AMSQuery.EndPoint.AD).id(d.getAdId()).build();
		Ad ad = client.executeQuery(adQuery, Ad.class);
		if (ad.getApplication() != null) {
		    if (adNames.put(ad.getWorkplace().getName(), ad.getWorkplace().getName()) != null) {
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
	for (ProfessionCategory pc : result.getList()) {
	    System.out.println(pc);
	}
    }

    @Test
    public void testGetProfessionSubCategories() throws IOException, URISyntaxException {
	query = new AMSQueryBuilder(AMSQuery.EndPoint.PROFESSION_SUB_CATEGORIES).professionCategory(1).build();
	ProfessionSubCategoryList result = client.executeQuery(query, ProfessionSubCategoryList.class);
	System.out.println("Found " + result.getList().size() + " different categories. Number of positionopenings available total: " + result.getCount());
	for (ProfessionSubCategory pc : result.getList()) {
	    System.out.println(pc);
	}
    }

    @Test
    public void testGetProfessions() throws IOException, URISyntaxException {
	query = new AMSQueryBuilder(AMSQuery.EndPoint.PROFESSION).professionSubCategory(2131).build();
	ProfessionList result = client.executeQuery(query, ProfessionList.class);
	System.out.println("Found " + result.getList().size() + " different categories. Number of positionopenings available total: " + result.getCount());
	for (Profession pc : result.getList()) {
	    System.out.println(pc);
	}
    }

    @Test
    public void testGetMunicipialities() throws IOException, URISyntaxException {
	query = new AMSQueryBuilder(AMSQuery.EndPoint.MUNICIPILAITY).county(County.SKANE).build();
	MunicipialityList list = client.executeQuery(query, MunicipialityList.class);
	System.out.println("Found " + list.getList().size() + " different munis. Number of positionopenings available total: " + list.getCount());
	for (Municipiality m : list.getList()) {
	    System.out.println(m);
	}
    }

    @Test
    public void getALLProfessions() throws Exception {
	Map<String, Profession> professions = new HashMap<String, Profession>();
	AMSQuery pCQuery = new AMSQueryBuilder(AMSQuery.EndPoint.PROFESSION_CATEGORIES).build();
	ProfessionCategoryList pCList = client.executeQuery(pCQuery, ProfessionCategoryList.class);
	for (ProfessionCategory pc : pCList.getList()) {
	    List<ProfessionSubCategory> subCategories = fetchSubCategories(Integer.parseInt(pc.getAmsId()));
	    for (ProfessionSubCategory psc : subCategories) {
		List<Profession> pL = fetchProfessions(Integer.parseInt(psc.getAmsId()));
		for (Profession p : pL) {
		    professions.put(p.getAmsId(), p);
		}
	    }
	}
	System.err.printf("7649: %s\n", professions.get("7649"));
    }

    private List<ProfessionSubCategory> fetchSubCategories(final Integer categoryId) throws IOException, URISyntaxException {
	AMSQuery pSCQuery = new AMSQueryBuilder(AMSQuery.EndPoint.PROFESSION_SUB_CATEGORIES).professionCategory(categoryId).build();
	ProfessionSubCategoryList pSCList = client.executeQuery(pSCQuery, ProfessionSubCategoryList.class);
	return pSCList.getList();
    }

    private List<Profession> fetchProfessions(final Integer subCategoryId) throws IOException, URISyntaxException {
	AMSQuery pQuery = new AMSQueryBuilder(AMSQuery.EndPoint.PROFESSION).professionSubCategory(subCategoryId).build();
	ProfessionList pList = client.executeQuery(pQuery, ProfessionList.class);
	return pList.getList();
    }

    public void getAd() throws Exception {
	query = new AMSQueryBuilder(AMSQuery.EndPoint.AD).id("10381431").build();
	Ad ad = client.executeQuery(query, Ad.class);
	System.err.println(ad);
    }
}
