package com.youcruit.ams.api.client.object;

import java.util.Date;

public class Application {
    private String email;
    private String reference;
    private Date closeDate;
    private String additionalInformation;
    private String webAddress;

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

    public String getWebAddress() {
        return webAddress;
    }

    public void setWebAddress(String webAddress) {
        this.webAddress = webAddress;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Application)) return false;

        Application that = (Application) o;

        if (getEmail() != null ? !getEmail().equals(that.getEmail()) : that.getEmail() != null) return false;
        if (getReference() != null ? !getReference().equals(that.getReference()) : that.getReference() != null) return false;
        if (getCloseDate() != null ? !getCloseDate().equals(that.getCloseDate()) : that.getCloseDate() != null) return false;
        if (getAdditionalInformation() != null ? !getAdditionalInformation().equals(that.getAdditionalInformation()) : that.getAdditionalInformation() != null) return false;
        return !(getWebAddress() != null ? !getWebAddress().equals(that.getWebAddress()) : that.getWebAddress() != null);
    }

    @Override
    public int hashCode() {
        int result = getEmail() != null ? getEmail().hashCode() : 0;
        result = 31 * result + (getReference() != null ? getReference().hashCode() : 0);
        result = 31 * result + (getCloseDate() != null ? getCloseDate().hashCode() : 0);
        result = 31 * result + (getAdditionalInformation() != null ? getAdditionalInformation().hashCode() : 0);
        result = 31 * result + (getWebAddress() != null ? getWebAddress().hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Application{" +
                        "email='" + email + '\'' +
                        ", reference='" + reference + '\'' +
                        ", closeDate=" + closeDate +
                        ", additionalInformation='" + additionalInformation + '\'' +
                        ", webAddress='" + webAddress + '\'' +
                        '}';
    }
}
