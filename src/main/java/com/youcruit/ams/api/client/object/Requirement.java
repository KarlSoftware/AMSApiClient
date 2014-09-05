package com.youcruit.ams.api.client.object;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

public class Requirement {
    @JacksonXmlProperty(localName = "egenbil")
    private boolean carOwner;
    @JacksonXmlProperty(localName = "korkortslista")
    private List<String> driversLicenseClass;
    public boolean isCarOwner() {
        return carOwner;
    }
    public void setCarOwner(boolean car) {
        this.carOwner = car;
    }
    public List<String> getDriversLicenseClass() {
	if(driversLicenseClass==null){
	    driversLicenseClass = new ArrayList<String>();
	}
        return driversLicenseClass;
    }
    public void setDriversLicenseClass(List<String> driversLicenseClass) {
        this.driversLicenseClass = driversLicenseClass;
    }
    @Override
    public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + (carOwner ? 1231 : 1237);
	result = prime * result + ((driversLicenseClass == null) ? 0 : driversLicenseClass.hashCode());
	return result;
    }
    @Override
    public boolean equals(Object obj) {
	if (this == obj) return true;
	if (obj == null) return false;
	if (!(obj instanceof Requirement)) return false;
	Requirement other = (Requirement) obj;
	if (carOwner != other.carOwner) return false;
	if (driversLicenseClass == null) {
	    if (other.driversLicenseClass != null) return false;
	} else if (!driversLicenseClass.equals(other.driversLicenseClass)) return false;
	return true;
    }
    @Override
    public String toString() {
	return "Requirement [carOwner=" + carOwner + ", driversLicenseClass=" + driversLicenseClass + "]";
    } 

}
