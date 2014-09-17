package com.youcruit.ams.api.client.object;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Workplace {
    @JsonProperty(value="arbetsplatsnamn")
    private String name;
    @JsonProperty(value="postnummer")
    private String postalCode;
    @JsonProperty(value="postadress")
    private String adress;
    @JsonProperty(value="besoksadress")
    private String visitingAddress;
    @JsonProperty(value="besoksort")
    private String visitingCity;
    @JsonProperty(value="land")
    private String visitingCountry;
    @JsonProperty(value="postort")
    private String city;
    @JsonProperty(value="postland")
    private String country;
    @JsonProperty(value="telefonnummer")
    private String phone;
    @JsonProperty(value="faxnummer")
    private String fax;
    @JsonProperty(value="hemsida")
    private String homepage;
    @JsonProperty(value="epostadress")
    private String email;
    @JsonProperty(value="kontaktpersonlista")
    private ContactList contacts;
    @JsonProperty(value="logotypurl")
    private String logoUrl;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public String getVisitingAddress() {
        return visitingAddress;
    }

    public void setVisitingAddress(String visitingAddress) {
        this.visitingAddress = visitingAddress;
    }

    public String getVisitingCity() {
        return visitingCity;
    }

    public void setVisitingCity(String visitingCity) {
        this.visitingCity = visitingCity;
    }

    public String getVisitingCountry() {
        return visitingCountry;
    }

    public void setVisitingCountry(String visitingCountry) {
        this.visitingCountry = visitingCountry;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getFax() {
        return fax;
    }

    public void setFax(String fax) {
        this.fax = fax;
    }

    public String getHomepage() {
        return homepage;
    }

    public void setHomepage(String homepage) {
        this.homepage = homepage;
    }

    public ContactList getContacts() {
	if(contacts == null){
	    contacts = new ContactList();
	}
        return contacts;
    }

    public void setContacts(ContactList contacts) {
        this.contacts = contacts;
    }

    public String getLogoUrl() {
        return logoUrl;
    }

    public void setLogoUrl(String logoUrl) {
        this.logoUrl = logoUrl;
    }

    @Override
    public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + ((adress == null) ? 0 : adress.hashCode());
	result = prime * result + ((city == null) ? 0 : city.hashCode());
	result = prime * result + ((contacts == null) ? 0 : contacts.hashCode());
	result = prime * result + ((country == null) ? 0 : country.hashCode());
	result = prime * result + ((email == null) ? 0 : email.hashCode());
	result = prime * result + ((fax == null) ? 0 : fax.hashCode());
	result = prime * result + ((homepage == null) ? 0 : homepage.hashCode());
	result = prime * result + ((logoUrl == null) ? 0 : logoUrl.hashCode());
	result = prime * result + ((name == null) ? 0 : name.hashCode());
	result = prime * result + ((phone == null) ? 0 : phone.hashCode());
	result = prime * result + ((postalCode == null) ? 0 : postalCode.hashCode());
	result = prime * result + ((visitingAddress == null) ? 0 : visitingAddress.hashCode());
	result = prime * result + ((visitingCity == null) ? 0 : visitingCity.hashCode());
	result = prime * result + ((visitingCountry == null) ? 0 : visitingCountry.hashCode());
	return result;
    }

    @Override
    public boolean equals(Object obj) {
	if (this == obj) return true;
	if (obj == null) return false;
	if (!(obj instanceof Workplace)) return false;
	Workplace other = (Workplace) obj;
	if (adress == null) {
	    if (other.adress != null) return false;
	} else if (!adress.equals(other.adress)) return false;
	if (city == null) {
	    if (other.city != null) return false;
	} else if (!city.equals(other.city)) return false;
	if (contacts == null) {
	    if (other.contacts != null) return false;
	} else if (!contacts.equals(other.contacts)) return false;
	if (country == null) {
	    if (other.country != null) return false;
	} else if (!country.equals(other.country)) return false;
	if (email == null) {
	    if (other.email != null) return false;
	} else if (!email.equals(other.email)) return false;
	if (fax == null) {
	    if (other.fax != null) return false;
	} else if (!fax.equals(other.fax)) return false;
	if (homepage == null) {
	    if (other.homepage != null) return false;
	} else if (!homepage.equals(other.homepage)) return false;
	if (logoUrl == null) {
	    if (other.logoUrl != null) return false;
	} else if (!logoUrl.equals(other.logoUrl)) return false;
	if (name == null) {
	    if (other.name != null) return false;
	} else if (!name.equals(other.name)) return false;
	if (phone == null) {
	    if (other.phone != null) return false;
	} else if (!phone.equals(other.phone)) return false;
	if (postalCode == null) {
	    if (other.postalCode != null) return false;
	} else if (!postalCode.equals(other.postalCode)) return false;
	if (visitingAddress == null) {
	    if (other.visitingAddress != null) return false;
	} else if (!visitingAddress.equals(other.visitingAddress)) return false;
	if (visitingCity == null) {
	    if (other.visitingCity != null) return false;
	} else if (!visitingCity.equals(other.visitingCity)) return false;
	if (visitingCountry == null) {
	    if (other.visitingCountry != null) return false;
	} else if (!visitingCountry.equals(other.visitingCountry)) return false;
	return true;
    }

    @Override
    public String toString() {
	return "Workplace [name=" + name + ", postalCode=" + postalCode + ", adress=" + adress + ", visitingAddress=" + visitingAddress + ", visitingCity=" + visitingCity + ", visitingCountry=" + visitingCountry + ", city=" + city
		+ ", country=" + country + ", phone=" + phone + ", fax=" + fax + ", homepage=" + homepage + ", email=" + email + ", contacts=" + contacts + ", logoUrl=" + logoUrl + "]";
    }
}
