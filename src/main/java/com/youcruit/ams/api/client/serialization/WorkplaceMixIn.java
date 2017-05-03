package com.youcruit.ams.api.client.serialization;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import com.youcruit.ams.api.client.object.ContactList;

@JsonIgnoreProperties(ignoreUnknown = true)
public abstract class WorkplaceMixIn {
    @JsonProperty(value = "epostadress")
    public abstract void setEmail(String email);

    @JsonProperty(value = "arbetsplatsnamn")
    public abstract void setName(String name);

    @JsonProperty(value = "postnummer")
    public abstract void setPostalCode(String postalCode);

    @JsonProperty(value = "postadress")
    public abstract void setAdress(String adress);

    @JsonProperty(value = "besoksadress")
    public abstract void setVisitingAddress(String visitingAddress);

    @JsonProperty(value = "besoksort")
    public abstract void setVisitingCity(String visitingCity);

    @JsonProperty(value = "land")
    public abstract void setVisitingCountry(String visitingCountry);

    @JsonProperty(value = "postort")
    public abstract void setCity(String city);

    @JsonProperty(value = "postland")
    public abstract void setCountry(String country);

    @JsonProperty(value = "telefonnummer")
    public abstract void setPhone(String phone);

    @JsonProperty(value = "faxnummer")
    public abstract void setFax(String fax);

    @JsonProperty(value = "hemsida")
    public abstract void setHomepage(String homepage);

    @JsonProperty(value = "kontaktpersonlista")
    public abstract void setContacts(ContactList contacts);

    @JsonProperty(value = "logotypurl")
    public abstract void setLogoUrl(String logoUrl);

}
