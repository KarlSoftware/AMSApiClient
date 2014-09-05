package com.youcruit.ams.api.client.object;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Application {
    @JacksonXmlProperty(localName="epostadress")
    private String email;
    @JacksonXmlProperty(localName="referens")
    private String reference;
    @JacksonXmlProperty(localName="sista_ansokningsdag")
    private Date closeDate;
    @JacksonXmlProperty(localName="ovrigt_om_ansokan")
    private String additionalInformation;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public Date getCloseDate() {
        return closeDate;
    }

    public void setCloseDate(Date closeDate) {
        this.closeDate = closeDate;
    }

    public String getAdditionalInformation() {
        return additionalInformation;
    }

    public void setAdditionalInformation(String additionalInformation) {
        this.additionalInformation = additionalInformation;
    }

    @Override
    public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + ((additionalInformation == null) ? 0 : additionalInformation.hashCode());
	result = prime * result + ((closeDate == null) ? 0 : closeDate.hashCode());
	result = prime * result + ((email == null) ? 0 : email.hashCode());
	result = prime * result + ((reference == null) ? 0 : reference.hashCode());
	return result;
    }

    @Override
    public boolean equals(Object obj) {
	if (this == obj) return true;
	if (obj == null) return false;
	if (!(obj instanceof Application)) return false;
	Application other = (Application) obj;
	if (additionalInformation == null) {
	    if (other.additionalInformation != null) return false;
	} else if (!additionalInformation.equals(other.additionalInformation)) return false;
	if (closeDate == null) {
	    if (other.closeDate != null) return false;
	} else if (!closeDate.equals(other.closeDate)) return false;
	if (email == null) {
	    if (other.email != null) return false;
	} else if (!email.equals(other.email)) return false;
	if (reference == null) {
	    if (other.reference != null) return false;
	} else if (!reference.equals(other.reference)) return false;
	return true;
    }

    @Override
    public String toString() {
	return "Application [email=" + email + ", reference=" + reference + ", closeDate=" + closeDate + ", additionalInformation=" + additionalInformation + "]";
    }
}
