package com.youcruit.ams.api.client.serialization;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonProperty;

import com.youcruit.ams.api.client.object.DriversLicenseClasses;

@JsonIgnoreProperties(ignoreUnknown = true)
public abstract class RequirementMixIn {
    @JsonProperty(value="egenbil")
    public abstract void setCarOwner(boolean car);
    @JsonProperty(value="korkortslista")
    public abstract void setDriversLicenseClass(DriversLicenseClasses driversLicenseClass);
}
