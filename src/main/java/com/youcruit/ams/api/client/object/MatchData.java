package com.youcruit.ams.api.client.object;

import java.util.Date;

public class MatchData {
    private String adId;
    private String adHeader;
    private String professionName;
    private String employerName;
    private String municipialityName;
    private Date published;
    private int relevance;
    private int countOpenings;
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
    public String getProfessionName() {
        return professionName;
    }
    public void setProfessionName(String professionName) {
        this.professionName = professionName;
    }
    public String getEmployerName() {
        return employerName;
    }
    public void setEmployerName(String employerName) {
        this.employerName = employerName;
    }
    public String getMunicipialityName() {
        return municipialityName;
    }
    public void setMunicipialityName(String municipialityName) {
        this.municipialityName = municipialityName;
    }
    public Date getPublished() {
        return published;
    }
    public void setPublished(Date published) {
        this.published = published;
    }
    public int getRelevance() {
        return relevance;
    }
    public void setRelevance(int relevance) {
        this.relevance = relevance;
    }
    public int getCountOpenings() {
        return countOpenings;
    }
    public void setCountOpenings(int countOpenings) {
        this.countOpenings = countOpenings;
    }
    @Override
    public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + ((adHeader == null) ? 0 : adHeader.hashCode());
	result = prime * result + ((adId == null) ? 0 : adId.hashCode());
	result = prime * result + countOpenings;
	result = prime * result + ((employerName == null) ? 0 : employerName.hashCode());
	result = prime * result + ((municipialityName == null) ? 0 : municipialityName.hashCode());
	result = prime * result + ((professionName == null) ? 0 : professionName.hashCode());
	result = prime * result + ((published == null) ? 0 : published.hashCode());
	result = prime * result + relevance;
	return result;
    }
    @Override
    public boolean equals(Object obj) {
	if (this == obj) return true;
	if (obj == null) return false;
	if (!(obj instanceof MatchData)) return false;
	MatchData other = (MatchData) obj;
	if (adHeader == null) {
	    if (other.adHeader != null) return false;
	} else if (!adHeader.equals(other.adHeader)) return false;
	if (adId == null) {
	    if (other.adId != null) return false;
	} else if (!adId.equals(other.adId)) return false;
	if (countOpenings != other.countOpenings) return false;
	if (employerName == null) {
	    if (other.employerName != null) return false;
	} else if (!employerName.equals(other.employerName)) return false;
	if (municipialityName == null) {
	    if (other.municipialityName != null) return false;
	} else if (!municipialityName.equals(other.municipialityName)) return false;
	if (professionName == null) {
	    if (other.professionName != null) return false;
	} else if (!professionName.equals(other.professionName)) return false;
	if (published == null) {
	    if (other.published != null) return false;
	} else if (!published.equals(other.published)) return false;
	if (relevance != other.relevance) return false;
	return true;
    }
    @Override
    public String toString() {
	return "MatchData [adId=" + adId + ", adHeader=" + adHeader + ", professionName=" + professionName + ", employerName=" + employerName + ", municipialityName=" + municipialityName + ", published=" + published + ", relevance="
		+ relevance + ", countOpenings=" + countOpenings + "]";
    }
}
