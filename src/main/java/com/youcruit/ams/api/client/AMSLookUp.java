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
    private String amsBaseUrl;

    public AMSLookUp(final String amsBaseUrl) {
	this.amsBaseUrl = amsBaseUrl;
	professionCategories = new HashMap<String, ProfessionCategory>();
	professionSubCategories = new HashMap<String, ProfessionSubCategory>();
	profession = new HashMap<String, Profession>();
    }

    public void fetch() throws IOException, URISyntaxException {
	AMSQuery pCQuery = new AMSQueryBuilder(AMSQuery.EndPoint.PROFESSION_CATEGORIES).build();
	ProfessionCategoryList pCList = new AMSApiClient(amsBaseUrl).executeQuery(pCQuery, ProfessionCategoryList.class);
	for(ProfessionCategory pc : pCList.getList()) {
	    List<ProfessionSubCategory> subCategories = fetchSubCategories(Integer.parseInt(pc.getId()));
	    for(ProfessionSubCategory psc : subCategories) {
		List<Profession> pL = fetchProfessions(Integer.parseInt(psc.getId()));
		for(Profession p : pL) {
		    profession.put(p.getId(), p);
		    professionSubCategories.put(p.getId(), psc);
		}
		professionCategories.put(psc.getId(), pc);
	    }
	}
    }

    public ProfessionCategory getCategoryByProfessionId(final String professionId) {
	return professionCategories.get(professionSubCategories.get(professionId).getId());
    }

    public ProfessionSubCategory getSubCategoryByProfessionId(final String professionId) {
	return professionSubCategories.get(professionId);
    }

    public Profession getProfessionById(final String professionId) {
	return profession.get(professionId);
    }

    private List<ProfessionSubCategory> fetchSubCategories(final Integer categoryId) throws IOException, URISyntaxException {
	AMSQuery pSCQuery = new AMSQueryBuilder(AMSQuery.EndPoint.PROFESSION_SUB_CATEGORIES).professionCategory(categoryId).build();
	ProfessionSubCategoryList pSCList = new AMSApiClient(amsBaseUrl).executeQuery(pSCQuery, ProfessionSubCategoryList.class);
	return pSCList.getList();
    }

    private List<Profession> fetchProfessions(final Integer subCategoryId) throws IOException, URISyntaxException {
	AMSQuery pQuery = new AMSQueryBuilder(AMSQuery.EndPoint.PROFESSION).professionSubCategory(subCategoryId).build();
	ProfessionList pList = new AMSApiClient(amsBaseUrl).executeQuery(pQuery, ProfessionList.class);
	return pList.getList();
    }

}
