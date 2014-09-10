package com.youcruit.ams.api.client;

import com.youcruit.ams.api.client.object.Profession;
import com.youcruit.ams.api.client.object.ProfessionCategory;
import com.youcruit.ams.api.client.object.ProfessionSubCategory;

public class ProfessionCache {
    private String amsId;
    private String name;
    private String categoryId;
    private String categoryName;
    private String subCategoryId;
    private String subCategoryName;
    public String getAmsId() {
        return amsId;
    }
    public void setAmsId(String amdId) {
        this.amsId = amdId;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getCategoryId() {
        return categoryId;
    }
    public void setCategoryId(String categoryId) {
        this.categoryId = categoryId;
    }
    public String getCategoryName() {
        return categoryName;
    }
    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }
    public String getSubCategoryId() {
        return subCategoryId;
    }
    public void setSubCategoryId(String subCategoryId) {
        this.subCategoryId = subCategoryId;
    }
    public String getSubCategoryName() {
        return subCategoryName;
    }
    public void setSubCategoryName(String subCategoryName) {
        this.subCategoryName = subCategoryName;
    }
    @Override
    public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + ((amsId == null) ? 0 : amsId.hashCode());
	result = prime * result + ((categoryId == null) ? 0 : categoryId.hashCode());
	result = prime * result + ((categoryName == null) ? 0 : categoryName.hashCode());
	result = prime * result + ((name == null) ? 0 : name.hashCode());
	result = prime * result + ((subCategoryId == null) ? 0 : subCategoryId.hashCode());
	result = prime * result + ((subCategoryName == null) ? 0 : subCategoryName.hashCode());
	return result;
    }
    @Override
    public boolean equals(Object obj) {
	if (this == obj) return true;
	if (obj == null) return false;
	if (!(obj instanceof ProfessionCache)) return false;
	ProfessionCache other = (ProfessionCache) obj;
	if (amsId == null) {
	    if (other.amsId != null) return false;
	} else if (!amsId.equals(other.amsId)) return false;
	if (categoryId == null) {
	    if (other.categoryId != null) return false;
	} else if (!categoryId.equals(other.categoryId)) return false;
	if (categoryName == null) {
	    if (other.categoryName != null) return false;
	} else if (!categoryName.equals(other.categoryName)) return false;
	if (name == null) {
	    if (other.name != null) return false;
	} else if (!name.equals(other.name)) return false;
	if (subCategoryId == null) {
	    if (other.subCategoryId != null) return false;
	} else if (!subCategoryId.equals(other.subCategoryId)) return false;
	if (subCategoryName == null) {
	    if (other.subCategoryName != null) return false;
	} else if (!subCategoryName.equals(other.subCategoryName)) return false;
	return true;
    }
    @Override
    public String toString() {
	return "ProfessionCache [amsId=" + amsId + ", name=" + name + ", categoryId=" + categoryId + ", categoryName=" + categoryName + ", subCategoryId=" + subCategoryId + ", subCategoryName=" + subCategoryName + "]";
    }
    public void fillFrom(Profession p, ProfessionSubCategory psc, ProfessionCategory pc) {
	amsId = p.getId();
	name = p.getName();
	categoryId = pc.getId();
	categoryName = pc.getName();
	subCategoryId = psc.getId();
	subCategoryName = psc.getName();
    }
}
