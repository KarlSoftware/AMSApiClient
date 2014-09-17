package com.youcruit.ams.api.client.serialization;

import java.util.List;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown=true)
public abstract class DriversLicenseClassesMixIn {
    @JsonProperty(value="korkortstyp")
    public abstract void setDriversLicenseClasses(List<String> driversLicenseClasses);
}
