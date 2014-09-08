package com.youcruit.ams.api.client.object;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.youcruit.ams.api.client.AMSLookUp;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Ad {

    private String id;
    @JacksonXmlProperty(localName="ansokan")
    private Application application;
    @JacksonXmlProperty(localName="arbetsplats")
    private Workplace workplace;
    @JacksonXmlProperty(localName="annons")
    private Details details;
    @JacksonXmlProperty(localName="villkor")
    private Terms terms;
    @JacksonXmlProperty(localName="krav")
    private Requirement requirement;
    private String professionCategoryId;
    private String professionSubCategoryId;

    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
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
    public Details getDetails() {
        return details;
    }
    public void setDetails(Details details) {
	this.details = details;
	if (details != null) {
	    this.id = details.getAdId();
	}
    }
    public Terms getTerms() {
        return terms;
    }
    public void setTerms(Terms terms) {
        this.terms = terms;
    }
    public Requirement getRequirement() {
        return requirement;
    }
    public void setRequirement(Requirement requirement) {
        this.requirement = requirement;
    }
    public String getProfessionCategoryId() {
	return professionCategoryId;
    }

    public void setProfessionCategoryId(String professionCategoryId) {
	this.professionCategoryId = professionCategoryId;
    }

    public String getProfessionSubCategoryId() {
	return professionSubCategoryId;
    }

    public void setProfessionSubCategoryId(String professionSubCategoryId) {
	this.professionSubCategoryId = professionSubCategoryId;
    }

    public void fillCategories() {
	if(details != null && details.getProfessionId() != null) {
	    professionCategoryId = AMSLookUp.instance().getCategoryByProfessionId(details.getProfessionId()).getId();
	    professionSubCategoryId = AMSLookUp.instance().getSubCategoryByProfessionId(details.getProfessionId()).getId();
	}
    }

    @Override
    public boolean equals(Object o) {
	if (this == o) return true;
	if (!(o instanceof Ad)) return false;

	Ad ad = (Ad) o;

	if (application != null ? !application.equals(ad.application) : ad.application != null) return false;
	if (details != null ? !details.equals(ad.details) : ad.details != null) return false;
	if (id != null ? !id.equals(ad.id) : ad.id != null) return false;
	if (professionCategoryId != null ? !professionCategoryId.equals(ad.professionCategoryId) : ad.professionCategoryId != null)
	    return false;
	if (professionSubCategoryId != null ? !professionSubCategoryId.equals(ad.professionSubCategoryId) : ad.professionSubCategoryId != null)
	    return false;
	if (requirement != null ? !requirement.equals(ad.requirement) : ad.requirement != null) return false;
	if (terms != null ? !terms.equals(ad.terms) : ad.terms != null) return false;
	if (workplace != null ? !workplace.equals(ad.workplace) : ad.workplace != null) return false;

	return true;
    }

    @Override
    public int hashCode() {
	int result = id != null ? id.hashCode() : 0;
	result = 31 * result + (application != null ? application.hashCode() : 0);
	result = 31 * result + (workplace != null ? workplace.hashCode() : 0);
	result = 31 * result + (details != null ? details.hashCode() : 0);
	result = 31 * result + (terms != null ? terms.hashCode() : 0);
	result = 31 * result + (requirement != null ? requirement.hashCode() : 0);
	result = 31 * result + (professionCategoryId != null ? professionCategoryId.hashCode() : 0);
	result = 31 * result + (professionSubCategoryId != null ? professionSubCategoryId.hashCode() : 0);
	return result;
    }

    @Override
    public String toString() {
	return "Ad{" +
		"id='" + id + '\'' +
		", application=" + application +
		", workplace=" + workplace +
		", details=" + details +
		", terms=" + terms +
		", requirement=" + requirement +
		", professionCategoryId='" + professionCategoryId + '\'' +
		", professionSubCategoryId='" + professionSubCategoryId + '\'' +
		'}';
    }

}
