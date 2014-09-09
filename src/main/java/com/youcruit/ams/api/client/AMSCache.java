package com.youcruit.ams.api.client;

import com.youcruit.ams.api.client.object.Profession;
import com.youcruit.ams.api.client.object.ProfessionCategory;
import com.youcruit.ams.api.client.object.ProfessionSubCategory;

import java.util.Date;
import java.util.Map;

public class AMSCache {

    public enum CacheType {
	LOOKUP
    }

    private Map<String, Profession> profession;
    private Map<String, ProfessionCategory> professionCategories;
    private Map<String, ProfessionSubCategory> professionSubCategories;
    private Date dateCreated;
    private CacheType cacheType;

    public AMSCache() {}

    public AMSCache(Map<String, Profession> profession, Map<String, ProfessionCategory> professionCategories, Map<String, ProfessionSubCategory> professionSubCategories) {
	this.profession = profession;
	this.professionCategories = professionCategories;
	this.professionSubCategories = professionSubCategories;
	this.dateCreated = new Date();
	this.cacheType = CacheType.LOOKUP;
    }

    public Map<String, Profession> getProfession() {
	return profession;
    }

    public void setProfession(Map<String, Profession> profession) {
	this.profession = profession;
    }

    public Map<String, ProfessionCategory> getProfessionCategories() {
	return professionCategories;
    }

    public void setProfessionCategories(Map<String, ProfessionCategory> professionCategories) {
	this.professionCategories = professionCategories;
    }

    public Map<String, ProfessionSubCategory> getProfessionSubCategories() {
	return professionSubCategories;
    }

    public void setProfessionSubCategories(Map<String, ProfessionSubCategory> professionSubCategories) {
	this.professionSubCategories = professionSubCategories;
    }

    public Date getDateCreated() {
	return dateCreated;
    }

    public void setDateCreated(Date dateCreated) {
	this.dateCreated = dateCreated;
    }

    public CacheType getCacheType() {
	return cacheType;
    }

    public void setCacheType(CacheType cacheType) {
	this.cacheType = cacheType;
    }
}
