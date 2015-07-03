package com.youcruit.ams.api.client.serialization;

import java.util.Date;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown=true)
public abstract class DetailsMixIn {
    @JsonProperty(value="annonsid")
    public abstract void setAdId(String adId);
    @JsonProperty(value="annonsrubrik")
    public abstract void setAdHeader(String adHeader);
    @JsonProperty(value="annonstext")
    public abstract void setDescription(String description);
    @JsonProperty(value="yrkesbenamning")
    public abstract void setProfessionName(String professionName);
    @JsonProperty(value="yrkesid")
    public abstract void setProfessionId(String professionId);
    @JsonProperty(value="publiceraddatum")
    public abstract void setPublished(Date published);
    @JsonProperty(value="antal_platser")
    public abstract void setCountOpenings(int countOpenings);
    @JsonProperty(value="kommunnamn")
    public abstract void setMunicipialityName(String municipialityName);
    @JsonProperty("kommunkod")
    public abstract void setMunicipialityId(String municipialityId);
}
