package com.youcruit.ams.api.client.serialization;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown=true)
public abstract class SearchItemMixIn {
    
    @JsonProperty(value="id")
    public abstract void setAmsId(String id);

    @JsonProperty(value="namn")
    public abstract void setName(String name);
    
    @JsonProperty(value="antal_platsannonser")
    public abstract void setCount(int count);
}
