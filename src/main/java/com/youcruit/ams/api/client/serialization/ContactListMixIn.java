package com.youcruit.ams.api.client.serialization;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import com.youcruit.ams.api.client.object.Contact;

@JsonIgnoreProperties(ignoreUnknown=true)
public abstract class ContactListMixIn {
    @JsonProperty(value="kontaktpersondata")
    public abstract void setContacts(List<Contact> contacts);
}
