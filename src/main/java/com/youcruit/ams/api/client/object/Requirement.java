package com.youcruit.ams.api.client.object;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Requirement {
    @JsonProperty(value="egenbil")
    private boolean carOwner;
    @JsonProperty(value="korkortslista")
    private DriversLicenseClasses driversLicenseClass;
    public boolean isCarOwner() {
        return carOwner;
    }
    public void setCarOwner(boolean car) {
        this.carOwner = car;
    }
    public DriversLicenseClasses getDriversLicenseClass() {
	if(driversLicenseClass == null) {
	    driversLicenseClass = new DriversLicenseClasses();
	}
        return driversLicenseClass;
    }
    public void setDriversLicenseClass(DriversLicenseClasses driversLicenseClass) {
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
