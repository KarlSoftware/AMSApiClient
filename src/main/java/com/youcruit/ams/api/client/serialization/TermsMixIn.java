package com.youcruit.ams.api.client.serialization;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public abstract class TermsMixIn {
    @JsonProperty(value="varaktighet")
    public abstract void setPermanency(String permanency);
    @JsonProperty(value="arbetstid")
    public abstract void setWorkingTime(String workingTime);
    @JsonProperty(value="arbetstidvaraktighet")
    public abstract void setWorkingTimePermanency(String workingTimePermanency);
    @JsonProperty(value="lonetyp")
    public abstract void setWageType(String wageType);
    @JsonProperty(value="loneform")
    public abstract void setWageText(String wageText);
}
