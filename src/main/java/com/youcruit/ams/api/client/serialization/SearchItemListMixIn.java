package com.youcruit.ams.api.client.serialization;

import java.util.List;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.map.annotate.JsonRootName;

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
