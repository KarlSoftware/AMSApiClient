package com.youcruit.ams.api.client.object;

import java.util.ArrayList;
import java.util.List;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.map.annotate.JsonRootName;

import com.youcruit.ams.api.client.AMSLookUp;

@JsonRootName(value="platsannons")
@JsonIgnoreProperties(ignoreUnknown=true)
public class Ad {
    @JsonProperty(value="annonsid")
    private String id;
    @JsonProperty(value="ansokan")
    private Application application;
    @JsonProperty(value="arbetsplats")
    private Workplace workplace;
    @JsonProperty(value="annons")
    private Details details;
    @JsonProperty(value="villkor")
    private Terms terms;
    @JsonProperty(value="krav")
    private Requirement requirement;
    private String professionCategoryId;
    private String professionSubCategoryId;
    private String countyId;
    private List<String> municipialityIds;

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

    public String getCountyId() {
        return countyId;
    }
    public void setCountyId(String countyId) {
        this.countyId = countyId;
    }
    public List<String> getMunicipialityIds() {
	if(municipialityIds == null) {
	    municipialityIds = new ArrayList<String>();
	}
        return municipialityIds;
    }
    public void setMunicipialityIds(List<String> municipialityId) {
        this.municipialityIds = municipialityId;
    }
    public void fillCategories() {
	if(details != null && details.getProfessionId() != null) {
	    if(AMSLookUp.instance().getSubCategoryByProfessionId(details.getProfessionId()) != null) {
		professionCategoryId = AMSLookUp.instance().getCategoryByProfessionId(details.getProfessionId()).getAmsId();
		professionSubCategoryId = AMSLookUp.instance().getSubCategoryByProfessionId(details.getProfessionId()).getAmsId();
	    }
	}
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
	if (countyId == null) {
	    if (other.countyId != null) return false;
	} else if (!countyId.equals(other.countyId)) return false;
	if (details == null) {
	    if (other.details != null) return false;
	} else if (!details.equals(other.details)) return false;
	if (id == null) {
	    if (other.id != null) return false;
	} else if (!id.equals(other.id)) return false;
	if (municipialityIds == null) {
	    if (other.municipialityIds != null) return false;
	} else if (!municipialityIds.equals(other.municipialityIds)) return false;
	if (professionCategoryId == null) {
	    if (other.professionCategoryId != null) return false;
	} else if (!professionCategoryId.equals(other.professionCategoryId)) return false;
	if (professionSubCategoryId == null) {
	    if (other.professionSubCategoryId != null) return false;
	} else if (!professionSubCategoryId.equals(other.professionSubCategoryId)) return false;
	if (requirement == null) {
	    if (other.requirement != null) return false;
	} else if (!requirement.equals(other.requirement)) return false;
	if (terms == null) {
	    if (other.terms != null) return false;
	} else if (!terms.equals(other.terms)) return false;
	if (workplace == null) {
	    if (other.workplace != null) return false;
	} else if (!workplace.equals(other.workplace)) return false;
	return true;
    }

    @Override
    public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + ((application == null) ? 0 : application.hashCode());
	result = prime * result + ((countyId == null) ? 0 : countyId.hashCode());
	result = prime * result + ((details == null) ? 0 : details.hashCode());
	result = prime * result + ((id == null) ? 0 : id.hashCode());
	result = prime * result + ((municipialityIds == null) ? 0 : municipialityIds.hashCode());
	result = prime * result + ((professionCategoryId == null) ? 0 : professionCategoryId.hashCode());
	result = prime * result + ((professionSubCategoryId == null) ? 0 : professionSubCategoryId.hashCode());
	result = prime * result + ((requirement == null) ? 0 : requirement.hashCode());
	result = prime * result + ((terms == null) ? 0 : terms.hashCode());
	result = prime * result + ((workplace == null) ? 0 : workplace.hashCode());
	return result;
    }

    @Override
    public String toString() {
	return "Ad [id=" + id + ", application=" + application + ", workplace=" + workplace + ", details=" + details + ", terms=" + terms + ", requirement=" + requirement + ", professionCategoryId=" + professionCategoryId
		+ ", professionSubCategoryId=" + professionSubCategoryId + ", countyId=" + countyId + ", municipialityIds=" + municipialityIds + "]";
    }

}
