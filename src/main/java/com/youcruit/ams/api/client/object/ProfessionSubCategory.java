package com.youcruit.ams.api.client.object;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ProfessionSubCategory {
    private String id;
    @JacksonXmlProperty(localName="namn")
    private String name;
    @JacksonXmlProperty(localName="antal_platsannonser")
    private int count;
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
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
    @Override
    public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + count;
	result = prime * result + ((id == null) ? 0 : id.hashCode());
	result = prime * result + ((name == null) ? 0 : name.hashCode());
	return result;
    }
    @Override
    public boolean equals(Object obj) {
	if (this == obj) return true;
	if (obj == null) return false;
	if (!(obj instanceof ProfessionSubCategory)) return false;
	ProfessionSubCategory other = (ProfessionSubCategory) obj;
	if (count != other.count) return false;
	if (id == null) {
	    if (other.id != null) return false;
	} else if (!id.equals(other.id)) return false;
	if (name == null) {
	    if (other.name != null) return false;
	} else if (!name.equals(other.name)) return false;
	return true;
    }
    @Override
    public String toString() {
	return "ProfessionCategory [id=" + id + ", name=" + name + ", count=" + count + "]";
    }

}
