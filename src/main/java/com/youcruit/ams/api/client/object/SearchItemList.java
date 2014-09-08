package com.youcruit.ams.api.client.object;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

public abstract class SearchItemList<T> implements AMSList<T>{

    @JacksonXmlProperty(localName = "listnamn")
    private String name;
    @JacksonXmlProperty(localName = "totalt_antal_platsannonser")
    private int count;
    private List<T> list;

    public SearchItemList() {
	super();
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

    public List<T> getList() {
        if(list==null){
            list = new ArrayList<T>();
        }
        return list;
    }

    public void setList(List<T> professionCategories) {
        this.list = professionCategories;
    }

    @Override
    public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + count;
	result = prime * result + ((list == null) ? 0 : list.hashCode());
	result = prime * result + ((name == null) ? 0 : name.hashCode());
	return result;
    }

    @Override
    public boolean equals(Object obj) {
	if (this == obj) return true;
	if (obj == null) return false;
	if (!(obj instanceof SearchItemList)) return false;
	SearchItemList<?> other = (SearchItemList<?>) obj;
	if (count != other.count) return false;
	if (list == null) {
	    if (other.list != null) return false;
	} else if (!list.equals(other.list)) return false;
	if (name == null) {
	    if (other.name != null) return false;
	} else if (!name.equals(other.name)) return false;
	return true;
    }

    @Override
    public String toString() {
	return "SearchItemList [name=" + name + ", count=" + count + ", list=" + list + "]";
    }

}