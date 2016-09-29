package com.youcruit.ams.api.client;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.youcruit.ams.api.client.object.Profession;
import com.youcruit.ams.api.client.object.ProfessionCategory;
import com.youcruit.ams.api.client.object.ProfessionCategoryList;
import com.youcruit.ams.api.client.object.ProfessionList;
import com.youcruit.ams.api.client.object.ProfessionSubCategory;
import com.youcruit.ams.api.client.object.ProfessionSubCategoryList;

public class AMSLookUp {

    private static class Cache {
	private final Map<String, ProfessionCategory> professionCategories = new HashMap<>();
	private final Map<String, ProfessionSubCategory> professionSubCategories = new HashMap<>();
	private final Map<String, Profession> profession = new HashMap<>();
    }

    private Cache professionCache;

    private static class Instance {
	private static final AMSLookUp instance = new AMSLookUp();
    }

    public static AMSLookUp instance() {
	return Instance.instance;
    }

    private AMSLookUp() {
    }

    public void fetch(String amsBaseUrl, String fromEmail) throws IOException, URISyntaxException {
	if (professionCache == null) {
	    forceFetch(amsBaseUrl, fromEmail);
	}
    }

    public void forceFetch(String amsBaseUrl, String fromEmail) throws IOException, URISyntaxException {
	Cache cache = new Cache();
	AMSQuery pCQuery = new AMSQueryBuilder(AMSQuery.EndPoint.PROFESSION_CATEGORIES).build();
	ProfessionCategoryList pCList = new AMSApiClient(amsBaseUrl, fromEmail).executeQuery(pCQuery, ProfessionCategoryList.class);
	for (ProfessionCategory pc : pCList.getList()) {
	    List<ProfessionSubCategory> subCategories = fetchSubCategories(pc.getAmsId(), amsBaseUrl, fromEmail);
	    for (ProfessionSubCategory psc : subCategories) {
		List<Profession> pL = fetchProfessions(psc.getAmsId(), amsBaseUrl, fromEmail);
		for (Profession p : pL) {
		    cache.profession.put(p.getAmsId(), p);
		    cache.professionSubCategories.put(p.getAmsId(), psc);
		}
		cache.professionCategories.put(psc.getAmsId(), pc);
	    }
	}
	this.professionCache = cache;
    }

    @Deprecated
    // Use forceFetch instead
    public void clearCache() {
    }

    public ProfessionCategory getCategoryByProfessionId(final String professionId) {
	if (professionCache == null) {
	    throw new RuntimeException("Fetch has to be run before anything can be returned");
	}
	if (professionCache.professionSubCategories.containsKey(professionId)) {
	    return professionCache.professionCategories.get(professionCache.professionSubCategories.get(professionId).getAmsId());
	} else {
	    return null;
	}
    }

    public ProfessionSubCategory getSubCategoryByProfessionId(final String professionId) {
	if (professionCache == null) {
	    throw new RuntimeException("Fetch has to be run before anything can be returned");
	}
	return professionCache.professionSubCategories.get(professionId);
    }

    public Profession getProfessionById(final String professionId) {
	if (professionCache == null) {
	    throw new RuntimeException("Fetch has to be run before anything can be returned");
	}
	return professionCache.profession.get(professionId);
    }

    private List<ProfessionSubCategory> fetchSubCategories(final String categoryId, final String amsBaseUrl, final String fromEmail) throws IOException, URISyntaxException {
	AMSQuery pSCQuery = new AMSQueryBuilder(AMSQuery.EndPoint.PROFESSION_SUB_CATEGORIES).professionCategory(categoryId).build();
	ProfessionSubCategoryList pSCList = new AMSApiClient(amsBaseUrl, fromEmail).executeQuery(pSCQuery, ProfessionSubCategoryList.class);
	return pSCList.getList();
    }

    private List<Profession> fetchProfessions(final String subCategoryId, final String amsBaseUrl, final String fromEmail) throws IOException, URISyntaxException {
	AMSQuery pQuery = new AMSQueryBuilder(AMSQuery.EndPoint.PROFESSION).professionSubCategory(subCategoryId).build();
	ProfessionList pList = new AMSApiClient(amsBaseUrl, fromEmail).executeQuery(pQuery, ProfessionList.class);
	return pList.getList();
    }

    public List<ProfessionCache> getCacheableRepresentation() {
	List<ProfessionCache> cache = new ArrayList<>();
	for (Profession p : professionCache.profession.values()) {
	    ProfessionCache pcache = new ProfessionCache();
	    ProfessionSubCategory psc = professionCache.professionSubCategories.get(p.getAmsId());
	    ProfessionCategory pc = professionCache.professionCategories.get(psc.getAmsId());
	    pcache.fillFrom(p, psc, pc);
	    cache.add(pcache);
	}
	return cache;
    }

    public void populateFromCache(final List<? extends ProfessionCache> cache) {
	Cache professionCache = new Cache();
	for (ProfessionCache pcache : cache) {
	    Profession p = new Profession();
	    p.setAmsId(pcache.getAmsId());
	    p.setName(pcache.getName());
	    professionCache.profession.put(p.getAmsId(), p);
	    ProfessionSubCategory subCategory = new ProfessionSubCategory();
	    subCategory.setAmsId(pcache.getSubCategoryId());
	    subCategory.setName(pcache.getSubCategoryName());
	    professionCache.professionSubCategories.put(p.getAmsId(), subCategory);
	    if (!professionCache.professionCategories.containsKey(subCategory.getAmsId())) {
		ProfessionCategory category = new ProfessionCategory();
		category.setAmsId(pcache.getCategoryId());
		category.setName(pcache.getCategoryName());
		professionCache.professionCategories.put(subCategory.getAmsId(), category);
	    }
	}
	this.professionCache = professionCache;
    }
}
