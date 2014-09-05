package com.youcruit.ams.api.client.object;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Ad {
    @JacksonXmlProperty(localName="ansokan")
    private Application application;
    @JacksonXmlProperty(localName="arbetsplats")
    private Workplace workplace;
    public Application getApplication() {
        return application;
    }
    public void setApplication(Application application) {
        this.application = application;
    }
    public Workplace getWorkplace() {
        return workplace;
    }
    public void setWorkplace(Workplace workplace) {
        this.workplace = workplace;
    }
    @Override
    public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + ((application == null) ? 0 : application.hashCode());
	result = prime * result + ((workplace == null) ? 0 : workplace.hashCode());
	return result;
    }
    @Override
    public boolean equals(Object obj) {
	if (this == obj) return true;
	if (obj == null) return false;
	if (!(obj instanceof Ad)) return false;
	Ad other = (Ad) obj;
	if (application == null) {
	    if (other.application != null) return false;
	} else if (!application.equals(other.application)) return false;
	if (workplace == null) {
	    if (other.workplace != null) return false;
	} else if (!workplace.equals(other.workplace)) return false;
	return true;
    }
    @Override
    public String toString() {
	return "Ad [application=" + application + ", workplace=" + workplace + "]";
    }
    public String getEmail() {
	return getEmail(false);
    }

    public String getEmail(boolean preferWorkplace) {
	String email = null;
	if (preferWorkplace) {
	    email = getWorkPlaceEmail(email);
	    email = getApplicationEmail(email);
	} else {
	    email = getApplicationEmail(email);
	    email = getWorkPlaceEmail(email);
	}
	return email;
    }

    private String getWorkPlaceEmail(String email) {
	if ((email == null || email.equals("")) && workplace != null) {
	    if (getWorkplace().getEmail() != null && getWorkplace().getEmail().length() > 0) {
		email = getWorkplace().getEmail();
	    }
	}
	return email;
    }

    private String getApplicationEmail(String email) {
	if ((email == null || email.equals("")) && application != null) {
        	if (getApplication() != null && getApplication().getEmail() != null && getApplication().getEmail().length() > 0) {
        	    email = getApplication().getEmail();
        	}
	}
	return email;
    }
}
