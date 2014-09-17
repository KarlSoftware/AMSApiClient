package com.youcruit.ams.api.client.object;

import java.util.Date;

import org.codehaus.jackson.annotate.JsonProperty;

public class Details {
    @JsonProperty(value="annonsid")
    private String adId;
    @JsonProperty(value="annonsrubrik")
    private String adHeader;
    @JsonProperty(value="annonstext")
    private String description;
    @JsonProperty(value="yrkesbenamning")
    private String professionName;
    @JsonProperty(value="yrkesid")
    private String professionId;
    @JsonProperty(value="publiceraddatum")
    private Date published;
    @JsonProperty(value="antal_platser")
    private int countOpenings;
    @JsonProperty(value="kommunnamn")
    private String municipialityName;

    public String getAdId() {
	return adId;
    }

    public void setAdId(String adId) {
	this.adId = adId;
    }

    public String getAdHeader() {
	return adHeader;
    }

    public void setAdHeader(String adHeader) {
	this.adHeader = adHeader;
    }

    public String getDescription() {
	return description;
    }

    public void setDescription(String description) {
	this.description = description;
    }

    public String getProfessionName() {
	return professionName;
    }

    public void setProfessionName(String professionName) {
	this.professionName = professionName;
    }

    public String getProfessionId() {
	return professionId;
    }

    public void setProfessionId(String professionId) {
	this.professionId = professionId;
    }

    public Date getPublished() {
	return published;
    }

    public void setPublished(Date published) {
	this.published = published;
    }

    public int getCountOpenings() {
	return countOpenings;
    }

    public void setCountOpenings(int countOpenings) {
	this.countOpenings = countOpenings;
    }

    public String getMunicipialityName() {
	return municipialityName;
    }

    public void setMunicipialityName(String municipialityName) {
	this.municipialityName = municipialityName;
    }

    @Override
    public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + ((adHeader == null) ? 0 : adHeader.hashCode());
	result = prime * result + ((adId == null) ? 0 : adId.hashCode());
	result = prime * result + countOpenings;
	result = prime * result + ((description == null) ? 0 : description.hashCode());
	result = prime * result + ((municipialityName == null) ? 0 : municipialityName.hashCode());
	result = prime * result + ((professionId == null) ? 0 : professionId.hashCode());
	result = prime * result + ((professionName == null) ? 0 : professionName.hashCode());
	result = prime * result + ((published == null) ? 0 : published.hashCode());
	return result;
    }

    @Override
    public boolean equals(Object obj) {
	if (this == obj) return true;
	if (obj == null) return false;
	if (!(obj instanceof Details)) return false;
	Details other = (Details) obj;
	if (adHeader == null) {
	    if (other.adHeader != null) return false;
	} else if (!adHeader.equals(other.adHeader)) return false;
	if (adId == null) {
	    if (other.adId != null) return false;
	} else if (!adId.equals(other.adId)) return false;
	if (countOpenings != other.countOpenings) return false;
	if (description == null) {
	    if (other.description != null) return false;
	} else if (!description.equals(other.description)) return false;
	if (municipialityName == null) {
	    if (other.municipialityName != null) return false;
	} else if (!municipialityName.equals(other.municipialityName)) return false;
	if (professionId == null) {
	    if (other.professionId != null) return false;
	} else if (!professionId.equals(other.professionId)) return false;
	if (professionName == null) {
	    if (other.professionName != null) return false;
	} else if (!professionName.equals(other.professionName)) return false;
	if (published == null) {
	    if (other.published != null) return false;
	} else if (!published.equals(other.published)) return false;
	return true;
    }

    @Override
    public String toString() {
	return "Details [adId=" + adId + ", adHeader=" + adHeader + ", description=" + description + ", professionName=" + professionName + ", professionId=" + professionId + ", published=" + published + ", countOpenings=" + countOpenings
		+ ", municipialityName=" + municipialityName + "]";
    }
}
