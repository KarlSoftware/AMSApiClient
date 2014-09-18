package com.youcruit.ams.api.client.serialization;

import java.util.Date;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public abstract class ApplicationMixIn {
    @JsonProperty(value="epostadress")
    public abstract void setEmail(String email);
    @JsonProperty(value="referens")
    public abstract void setReference(String reference);
    @JsonProperty(value="sista_ansokningsdag")
    public abstract void setCloseDate(Date closeDate);
    @JsonProperty(value="ovrigt_om_ansokan")
    public abstract void setAdditionalInformation(String additionalInformation);
}