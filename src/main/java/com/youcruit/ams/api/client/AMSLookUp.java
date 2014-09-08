package com.youcruit.ams.api.client;

import com.youcruit.ams.api.client.object.*;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AMSLookUp {

    private Map<String, ProfessionCategory> professionCategories;
    private Map<String, ProfessionSubCategory> professionSubCategories;
    private Map<String, Profession> profession;
    private boolean inited = false;

    private static class Instance {
	private static final AMSLookUp instance = new AMSLookUp();
    }

    public static AMSLookUp instance() {
	return Instance.instance;
    }

    private AMSLookUp() {
	professionCategories = new HashMap<String, ProfessionCategory>();
	professionSubCategories = new HashMap<String, ProfessionSubCategory>();
	profession = new HashMap<String, Profession>();
    }

    public void fetch(String amsBaseUrl) throws IOException, URISyntaxException {
	AMSQuery pCQuery = new AMSQueryBuilder(AMSQuery.EndPoint.PROFESSION_CATEGORIES).build();
	ProfessionCategoryList pCList = new AMSApiClient(amsBaseUrl).executeQuery(pCQuery, ProfessionCategoryList.class);
	for(ProfessionCategory pc : pCList.getList()) {
	    List<ProfessionSubCategory> subCategories = fetchSubCategories(Integer.parseInt(pc.getId()), amsBaseUrl);
	    for(ProfessionSubCategory psc : subCategories) {
		List<Profession> pL = fetchProfessions(Integer.parseInt(psc.getId()), amsBaseUrl);
		for(Profession p : pL) {
		    profession.put(p.getId(), p);
		    professionSubCategories.put(p.getId(), psc);
		}
		professionCategories.put(psc.getId(), pc);
	    }
	}
	inited = true;
    }

    public ProfessionCategory getCategoryByProfessionId(final String professionId) {
	if(!inited) {
	    throw new RuntimeException("Fetch has to be run before anything can be returned");
	}
	return professionCategories.get(professionSubCategories.get(professionId).getId());
    }

    public ProfessionSubCategory getSubCategoryByProfessionId(final String professionId) {
	if(!inited) {
	    throw new RuntimeException("Fetch has to be run before anything can be returned");
	}
	return professionSubCategories.get(professionId);
    }

    public Profession getProfessionById(final String professionId) {
	if(!inited) {
	    throw new RuntimeException("Fetch has to be run before anything can be returned");
	}
	return profession.get(professionId);
    }

    private List<ProfessionSubCategory> fetchSubCategories(final Integer categoryId, final String amsBaseUrl) throws IOException, URISyntaxException {
	AMSQuery pSCQuery = new AMSQueryBuilder(AMSQuery.EndPoint.PROFESSION_SUB_CATEGORIES).professionCategory(categoryId).build();
	ProfessionSubCategoryList pSCList = new AMSApiClient(amsBaseUrl).executeQuery(pSCQuery, ProfessionSubCategoryList.class);
	return pSCList.getList();
    }

    private List<Profession> fetchProfessions(final Integer subCategoryId, final String amsBaseUrl) throws IOException, URISyntaxException {
	AMSQuery pQuery = new AMSQueryBuilder(AMSQuery.EndPoint.PROFESSION).professionSubCategory(subCategoryId).build();
	ProfessionList pList = new AMSApiClient(amsBaseUrl).executeQuery(pQuery, ProfessionList.class);
	return pList.getList();
    }

}
