package com.youcruit.ams.api.client.object;

public class Terms {
    private String permanency;
    private String workingTime;
    private String workingTimePermanency;
    private String wageType;
    private String wageText;

    public String getPermanency() {
	return permanency;
    }

    public void setPermanency(String permanency) {
	this.permanency = permanency;
    }

    public String getWorkingTime() {
	return workingTime;
    }

    public void setWorkingTime(String workingTime) {
	this.workingTime = workingTime;
    }

    public String getWorkingTimePermanency() {
	return workingTimePermanency;
    }

    public void setWorkingTimePermanency(String workingTimePermanency) {
	this.workingTimePermanency = workingTimePermanency;
    }

    public String getWageType() {
	return wageType;
    }

    public void setWageType(String wageType) {
	this.wageType = wageType;
    }

    public String getWageText() {
	return wageText;
    }

    public void setWageText(String wageText) {
	this.wageText = wageText;
    }

    @Override
    public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + ((permanency == null) ? 0 : permanency.hashCode());
	result = prime * result + ((wageText == null) ? 0 : wageText.hashCode());
	result = prime * result + ((wageType == null) ? 0 : wageType.hashCode());
	result = prime * result + ((workingTime == null) ? 0 : workingTime.hashCode());
	result = prime * result + ((workingTimePermanency == null) ? 0 : workingTimePermanency.hashCode());
	return result;
    }

    @Override
    public boolean equals(Object obj) {
	if (this == obj) return true;
	if (obj == null) return false;
	if (!(obj instanceof Terms)) return false;
	Terms other = (Terms) obj;
	if (permanency == null) {
	    if (other.permanency != null) return false;
	} else if (!permanency.equals(other.permanency)) return false;
	if (wageText == null) {
	    if (other.wageText != null) return false;
	} else if (!wageText.equals(other.wageText)) return false;
	if (wageType == null) {
	    if (other.wageType != null) return false;
	} else if (!wageType.equals(other.wageType)) return false;
	if (workingTime == null) {
	    if (other.workingTime != null) return false;
	} else if (!workingTime.equals(other.workingTime)) return false;
	if (workingTimePermanency == null) {
	    if (other.workingTimePermanency != null) return false;
	} else if (!workingTimePermanency.equals(other.workingTimePermanency)) return false;
	return true;
    }

    @Override
    public String toString() {
	return "Terms [permanency=" + permanency + ", workingTime=" + workingTime + ", workingTimePermanency=" + workingTimePermanency + ", wageType=" + wageType + ", wageText=" + wageText + "]";
    }

}
