package com.youcruit.ams.api.client.object;

import java.util.ArrayList;
import java.util.List;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonProperty;
@JsonIgnoreProperties(ignoreUnknown=true)
public class ContactList {
    @JsonProperty(value="kontaktpersondata")
    private List<Contact> contacts;

    public List<Contact> getContacts() {
	if(contacts==null){
	    contacts =  new ArrayList<Contact>();
	}
        return contacts;
    }

    public void setContacts(List<Contact> contacts) {
        this.contacts = contacts;
    }

    @Override
    public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + ((contacts == null) ? 0 : contacts.hashCode());
	return result;
    }

    @Override
    public boolean equals(Object obj) {
	if (this == obj) return true;
	if (obj == null) return false;
	if (!(obj instanceof ContactList)) return false;
	ContactList other = (ContactList) obj;
	if (contacts == null) {
	    if (other.contacts != null) return false;
	} else if (!contacts.equals(other.contacts)) return false;
	return true;
    }

    @Override
    public String toString() {
	return "ContactList [contacts=" + contacts + "]";
    }
    

}
