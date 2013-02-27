package org.zenika.skillz.web.pages;

import org.zenika.skillz.model.Consultant;

public class ConsultantShortResource {

    private Long resourceId;
    private String fullName;
    private String profil;
    private String competence;

    public ConsultantShortResource() {

    }

    public ConsultantShortResource(Consultant consultant) {
        this.resourceId = consultant.getId();
        this.fullName = consultant.getFullName();
    }

    public Long getResourceId() {
        return resourceId;
    }

    public void setResourceId(Long resourceId) {
        this.resourceId = resourceId;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getProfil() {
        return profil;
    }

    public void setProfil(String profil) {
        this.profil = profil;
    }

    public String getCompetence() {
        return competence;
    }

    public void setCompetence(String competence) {
        this.competence = competence;
    }
}
