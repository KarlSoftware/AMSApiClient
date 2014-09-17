package com.youcruit.ams.api.client.object;

import org.codehaus.jackson.annotate.JsonProperty;

public abstract class SearchItem {

    @JsonProperty(value="id")
    private String amsId;
    @JsonProperty(value="namn")
    private String name;
    @JsonProperty(value="antal_platsannonser")
    private int count;

    public SearchItem() {
	super();
    }

    public String getAmsId() {
        return amsId;
    }

    public void setAmsId(String id) {
        this.amsId = id;
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
        result = prime * result + ((amsId == null) ? 0 : amsId.hashCode());
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null) return false;
        if (!(obj instanceof SearchItem)) return false;
        SearchItem other = (SearchItem) obj;
        if (count != other.count) return false;
        if (amsId == null) {
            if (other.amsId != null) return false;
        } else if (!amsId.equals(other.amsId)) return false;
        if (name == null) {
            if (other.name != null) return false;
        } else if (!name.equals(other.name)) return false;
        return true;
    }

    @Override
    public String toString() {
        return "SearchItem [amsId=" + amsId + ", name=" + name + ", count=" + count + "]";
    }

}