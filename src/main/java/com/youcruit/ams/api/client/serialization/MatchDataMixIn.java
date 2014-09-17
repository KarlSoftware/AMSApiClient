package com.youcruit.ams.api.client.serialization;

import java.util.Date;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public abstract class MatchDataMixIn {
    @JsonProperty(value="annonsid")
    public abstract void setAdId(String adId);
    @JsonProperty(value="annonsrubrik")
    public abstract void setAdHeader(String adHeader);
    @JsonProperty(value="yrkesbenamning")
    public abstract void setProfessionName(String professionName);
    @JsonProperty(value="arbetsplatsnamn")
    public abstract void setEmployerName(String employerName);
    @JsonProperty(value="kommunnamn")
    public abstract void setMunicipialityName(String municipialityName);
    @JsonProperty(value="publiceraddatum")
    public abstract void setPublished(Date published);
    @JsonProperty(value="relevans")
    public abstract void setRelevance(int relevance);
    @JsonProperty(value="antalplatser")
    public abstract void setCountOpenings(int countOpenings);

}
