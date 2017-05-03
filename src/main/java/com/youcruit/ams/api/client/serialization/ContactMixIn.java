package com.youcruit.ams.api.client.serialization;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public abstract class ContactMixIn {
    @JsonProperty(value="namn")
    public abstract void setName(String name);
    @JsonProperty(value="titel")
    public abstract void setRole(String role);
    @JsonProperty(value="mobilnummer")
    public abstract void setMobilePhone(String mobilePhone);
    @JsonProperty(value="telefonnummer")
    public abstract void setPhone(String phone);
    @JsonProperty(value="telefonnummer2")
    public abstract void setPhone2(String phone2);
    @JsonProperty(value="epostadress")
    public abstract void setEmail(String email);
    @JsonProperty(value="kontaktpersonertelefon1beskrivning")
    public abstract void setPhoneDescription(String phoneDescription);
    @JsonProperty(value="kontaktpersonertelefon2beskrivning")
    public abstract void setPhone2Description(String phone2Description);
}
