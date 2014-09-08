package com.youcruit.ams.api.client.object;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.youcruit.ams.api.client.deserializers.ProfessionSubCategoryListDeserializer;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonDeserialize(using=ProfessionSubCategoryListDeserializer.class)
public class ProfessionSubCategoryList implements AMSList<ProfessionSubCategory> {
    @JacksonXmlProperty(localName="listnamn")
    private String name;
    @JacksonXmlProperty(localName="totalt_antal_platsannonser")
    private int count;
    private List<ProfessionSubCategory> list;
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getCount() {
        return count;
    }
    public void setCount(int count) {
        this.count = count;
    }
    public List<ProfessionSubCategory> getList() {
	if(list==null){
	    list = new ArrayList<ProfessionSubCategory>();
	}
        return list;
    }
    public void setList(List<ProfessionSubCategory> list) {
        this.list = list;
    }
    @Override
    public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + count;
	result = prime * result + ((name == null) ? 0 : name.hashCode());
	result = prime * result + ((list == null) ? 0 : list.hashCode());
	return result;
    }
    @Override
    public boolean equals(Object obj) {
	if (this == obj) return true;
	if (obj == null) return false;
	if (!(obj instanceof ProfessionSubCategoryList)) return false;
	ProfessionSubCategoryList other = (ProfessionSubCategoryList) obj;
	if (count != other.count) return false;
	if (name == null) {
	    if (other.name != null) return false;
	} else if (!name.equals(other.name)) return false;
	if (list == null) {
	    if (other.list != null) return false;
	} else if (!list.equals(other.list)) return false;
	return true;
    }
    @Override
    public String toString() {
	return "ProfessionSubCategoryList [name=" + name + ", count=" + count + ", list=" + list + "]";
    }
}
