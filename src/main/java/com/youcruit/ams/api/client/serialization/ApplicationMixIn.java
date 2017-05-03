package com.youcruit.ams.api.client.serialization;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

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
    @JsonProperty(value="webbplats")
    public abstract void setWebAddress(String webAddress);

}
