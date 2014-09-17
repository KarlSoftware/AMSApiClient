package com.youcruit.ams.api.client.serialization;

import java.util.List;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonProperty;

import com.youcruit.ams.api.client.object.Contact;

@JsonIgnoreProperties(ignoreUnknown=true)
public abstract class ContactListMixIn {
    @JsonProperty(value="kontaktpersondata")
    public abstract void setContacts(List<Contact> contacts);
}
