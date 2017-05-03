package com.youcruit.ams.api.client.serialization;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown=true)
public abstract class DriversLicenseClassesMixIn {
    @JsonProperty(value="korkortstyp")
    public abstract void setDriversLicenseClasses(List<String> driversLicenseClasses);
}
