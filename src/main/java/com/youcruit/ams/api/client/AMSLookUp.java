package com.youcruit.ams.api.client;

import com.youcruit.ams.api.client.object.*;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
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
	if(!inited) {
	    AMSQuery pCQuery = new AMSQueryBuilder(AMSQuery.EndPoint.PROFESSION_CATEGORIES).build();
	    ProfessionCategoryList pCList = new AMSApiClient(amsBaseUrl).executeQuery(pCQuery, ProfessionCategoryList.class);
	    for (ProfessionCategory pc : pCList.getList()) {
		List<ProfessionSubCategory> subCategories = fetchSubCategories(Integer.parseInt(pc.getAmsId()), amsBaseUrl);
		for (ProfessionSubCategory psc : subCategories) {
		    List<Profession> pL = fetchProfessions(Integer.parseInt(psc.getAmsId()), amsBaseUrl);
		    for (Profession p : pL) {
			profession.put(p.getAmsId(), p);
			professionSubCategories.put(p.getAmsId(), psc);
		    }
		    professionCategories.put(psc.getAmsId(), pc);
		}
	    }
	    inited = true;
	}
    }

    public void clearCache() {
	inited = false;
	profession = new HashMap<String, Profession>();
	professionCategories = new HashMap<String, ProfessionCategory>();
	professionSubCategories = new HashMap<String, ProfessionSubCategory>();
    }

    public ProfessionCategory getCategoryByProfessionId(final String professionId) {
	if(!inited) {
	    throw new RuntimeException("Fetch has to be run before anything can be returned");
	}
	if(professionSubCategories.containsKey(professionId)) {
	    return professionCategories.get(professionSubCategories.get(professionId).getAmsId());
	} else {
	    return null;
	}
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
    
    public List<ProfessionCache> getCacheableRepresentation() {
	List<ProfessionCache> cache = new ArrayList<ProfessionCache>();
	for(Profession p : profession.values()){
	    ProfessionCache pcache = new ProfessionCache();
	    ProfessionSubCategory psc = professionSubCategories.get(p.getAmsId());
	    ProfessionCategory pc = professionCategories.get(psc.getAmsId());
	    pcache.fillFrom(p, psc, pc);
	    cache.add(pcache);
	}
	return cache;
    }
    
    public void populateFromCache(final List<? extends ProfessionCache> cache){
	clearCache();
	for(ProfessionCache pcache : cache){
	    Profession p = new Profession();
	    p.setAmsId(pcache.getAmsId());
	    p.setName(pcache.getName());
	    profession.put(p.getAmsId(), p);
	    ProfessionSubCategory subCategory = new ProfessionSubCategory();
	    subCategory.setAmsId(pcache.getSubCategoryId());
	    subCategory.setName(pcache.getSubCategoryName());
	    professionSubCategories.put(p.getAmsId(), subCategory);
	    if(!professionCategories.containsKey(subCategory.getAmsId())){
		ProfessionCategory category = new ProfessionCategory();
		category.setAmsId(pcache.getCategoryId());
		category.setName(pcache.getCategoryName());
		professionCategories.put(subCategory.getAmsId(), category);
	    }
	}
	inited = true;
    }
}
