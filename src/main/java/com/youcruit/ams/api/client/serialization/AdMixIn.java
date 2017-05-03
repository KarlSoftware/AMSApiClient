package com.youcruit.ams.api.client.serialization;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;
import com.youcruit.ams.api.client.object.Application;
import com.youcruit.ams.api.client.object.Details;
import com.youcruit.ams.api.client.object.Requirement;
import com.youcruit.ams.api.client.object.Terms;
import com.youcruit.ams.api.client.object.Workplace;

@JsonRootName(value="platsannons")
@JsonIgnoreProperties(ignoreUnknown=true)
public abstract class AdMixIn {
    @JsonProperty(value="annonsid")
    public abstract void setId(String id);
    @JsonProperty(value="ansokan")
    public abstract void setApplication(Application application);
    @JsonProperty(value="arbetsplats")
    public abstract void setWorkplace(Workplace workplace);
    @JsonProperty(value="annons")
    public abstract void setDetails(Details details);
    @JsonProperty(value="villkor")
    public abstract void setTerms(Terms terms);
    @JsonProperty(value="krav")
    public abstract void setRequirement(Requirement requirement);
}
