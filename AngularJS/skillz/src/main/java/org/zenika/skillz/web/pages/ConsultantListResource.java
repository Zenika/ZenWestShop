package org.zenika.skillz.web.pages;

import org.springframework.hateoas.ResourceSupport;
import org.zenika.skillz.model.Consultant;
import org.zenika.skillz.web.controllers.ConsultantController;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;

public class ConsultantListResource extends ResourceSupport {

    private Long resourceId;
    private String fullName;
    private String profil;
    private String competence;

    public ConsultantListResource(Consultant consultant) {
        this.resourceId = consultant.getId();
        this.fullName = consultant.getFullName();
        add(linkTo(ConsultantController.class).slash(consultant.getId()).withSelfRel());
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
