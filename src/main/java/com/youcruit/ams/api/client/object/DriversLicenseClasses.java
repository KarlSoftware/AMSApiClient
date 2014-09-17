package com.youcruit.ams.api.client.object;

import java.util.ArrayList;
import java.util.List;

public class DriversLicenseClasses {
    private List<String> driversLicenseClasses;

    public List<String> getDriversLicenseClasses() {
	if(driversLicenseClasses==null){
	    driversLicenseClasses = new ArrayList<String>();
	}
        return driversLicenseClasses;
    }

    public void setDriversLicenseClasses(List<String> driversLicenseClasses) {
        this.driversLicenseClasses = driversLicenseClasses;
    }

    @Override
    public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + ((driversLicenseClasses == null) ? 0 : driversLicenseClasses.hashCode());
	return result;
    }

    @Override
    public boolean equals(Object obj) {
	if (this == obj) return true;
	if (obj == null) return false;
	if (!(obj instanceof DriversLicenseClasses)) return false;
	DriversLicenseClasses other = (DriversLicenseClasses) obj;
	if (driversLicenseClasses == null) {
	    if (other.driversLicenseClasses != null) return false;
	} else if (!driversLicenseClasses.equals(other.driversLicenseClasses)) return false;
	return true;
    }

    @Override
    public String toString() {
	return "DriversLicenseClasses [driversLicenseClasses=" + driversLicenseClasses + "]";
    }
}
