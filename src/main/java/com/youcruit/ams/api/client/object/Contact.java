package com.youcruit.ams.api.client.object;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

public class Contact {
    @JacksonXmlProperty(localName = "namn")
    private String name;
    @JacksonXmlProperty(localName = "titel")
    private String role;
    @JacksonXmlProperty(localName = "mobilnummer")
    private String mobilePhone;
    @JacksonXmlProperty(localName = "telefonnummer")
    private String phone;
    @JacksonXmlProperty(localName = "telefonnummer2")
    private String phone2;
    @JacksonXmlProperty(localName = "epostadress")
    private String email;
    @JacksonXmlProperty(localName = "kontaktpersonertelefon1beskrivning")
    private String phoneDescription;
    @JacksonXmlProperty(localName = "kontaktpersonertelefon2beskrivning")
    private String phone2Description;
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getRole() {
        return role;
    }
    public void setRole(String role) {
        this.role = role;
    }
    public String getMobilePhone() {
        return mobilePhone;
    }
    public void setMobilePhone(String mobilePhone) {
        this.mobilePhone = mobilePhone;
    }
    public String getPhone() {
        return phone;
    }
    public void setPhone(String phone) {
        this.phone = phone;
    }
    public String getPhone2() {
        return phone2;
    }
    public void setPhone2(String phone2) {
        this.phone2 = phone2;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getPhoneDescription() {
        return phoneDescription;
    }
    public void setPhoneDescription(String phoneDescription) {
        this.phoneDescription = phoneDescription;
    }
    public String getPhone2Description() {
        return phone2Description;
    }
    public void setPhone2Description(String phone2Description) {
        this.phone2Description = phone2Description;
    }
    @Override
    public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + ((email == null) ? 0 : email.hashCode());
	result = prime * result + ((mobilePhone == null) ? 0 : mobilePhone.hashCode());
	result = prime * result + ((name == null) ? 0 : name.hashCode());
	result = prime * result + ((phone == null) ? 0 : phone.hashCode());
	result = prime * result + ((phone2 == null) ? 0 : phone2.hashCode());
	result = prime * result + ((phone2Description == null) ? 0 : phone2Description.hashCode());
	result = prime * result + ((phoneDescription == null) ? 0 : phoneDescription.hashCode());
	result = prime * result + ((role == null) ? 0 : role.hashCode());
	return result;
    }
    @Override
    public boolean equals(Object obj) {
	if (this == obj) return true;
	if (obj == null) return false;
	if (!(obj instanceof Contact)) return false;
	Contact other = (Contact) obj;
	if (email == null) {
	    if (other.email != null) return false;
	} else if (!email.equals(other.email)) return false;
	if (mobilePhone == null) {
	    if (other.mobilePhone != null) return false;
	} else if (!mobilePhone.equals(other.mobilePhone)) return false;
	if (name == null) {
	    if (other.name != null) return false;
	} else if (!name.equals(other.name)) return false;
	if (phone == null) {
	    if (other.phone != null) return false;
	} else if (!phone.equals(other.phone)) return false;
	if (phone2 == null) {
	    if (other.phone2 != null) return false;
	} else if (!phone2.equals(other.phone2)) return false;
	if (phone2Description == null) {
	    if (other.phone2Description != null) return false;
	} else if (!phone2Description.equals(other.phone2Description)) return false;
	if (phoneDescription == null) {
	    if (other.phoneDescription != null) return false;
	} else if (!phoneDescription.equals(other.phoneDescription)) return false;
	if (role == null) {
	    if (other.role != null) return false;
	} else if (!role.equals(other.role)) return false;
	return true;
    }
    @Override
    public String toString() {
	return "Contact [name=" + name + ", role=" + role + ", mobilePhone=" + mobilePhone + ", phone=" + phone + ", phone2=" + phone2 + ", email=" + email + ", phoneDescription=" + phoneDescription + ", phone2Description="
		+ phone2Description + "]";
    }
}
