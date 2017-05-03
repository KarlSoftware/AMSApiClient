package com.youcruit.ams.api.client.serialization;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;

@JsonRootName(value="soklista")
@JsonIgnoreProperties(ignoreUnknown=true)
public abstract class SearchItemListMixIn<T> {
    @JsonProperty(value="listnamn")
    public abstract void setName(String name);
    @JsonProperty(value="totalt_antal_platsannonser")
    public abstract void setCount(int count);
    @JsonProperty(value="sokdata")
    public abstract void setList(List<T> professionCategories);
}
