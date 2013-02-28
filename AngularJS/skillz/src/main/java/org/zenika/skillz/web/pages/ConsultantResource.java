package org.zenika.skillz.web.pages;

import com.google.common.base.Objects;
import org.zenika.skillz.model.Competence;
import org.zenika.skillz.model.Consultant;
import org.zenika.skillz.model.Profil;

import java.util.List;

public class ConsultantResource {

    private Long resourceId;

    private String lastName;
    private String firstName;
    private String mail;
    private String title;
    private String subTitle;
    private Integer exp;
    private String blog;
    private List<Profil> profils;
    private List<Competence> competences;

    public ConsultantResource() {
    }

    public ConsultantResource(Consultant consultant) {
        this.resourceId = consultant.getId();
        this.lastName = consultant.getLastName();
        this.firstName = consultant.getFirstName();
        this.title = consultant.getTitle();
        this.subTitle = consultant.getSubTitle();
        this.exp = consultant.getExperienceLength();
        this.mail = consultant.getMail();
        this.profils = consultant.getProfils();
        this.competences = consultant.getCompetences();
    }

    public Long getResourceId() {
        return resourceId;
    }

    public void setResourceId(Long resourceId) {
        this.resourceId = resourceId;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSubTitle() {
        return subTitle;
    }

    public void setSubTitle(String subTitle) {
        this.subTitle = subTitle;
    }

    public Integer getExp() {
        return exp;
    }

    public void setExp(Integer exp) {
        this.exp = exp;
    }

    public String getBlog() {
        return blog;
    }

    public void setBlog(String blog) {
        this.blog = blog;
    }

    public List<Profil> getProfils() {
        return profils;
    }

    public void setProfils(List<Profil> profils) {
        this.profils = profils;
    }

    public List<Competence> getCompetences() {
        return competences;
    }

    public void setCompetences(List<Competence> competences) {
        this.competences = competences;
    }

    public Consultant asConsultant() {
        Consultant consultant = new Consultant();
        consultant.setId(this.resourceId);
        consultant.setFirstName(this.firstName);
        consultant.setLastName(this.lastName);
        consultant.setMail(this.mail);
        consultant.setTitle(this.title);
        consultant.setSubTitle(this.subTitle);
        consultant.setProfils(this.profils);
        consultant.setCompetences(this.competences);
        return consultant;
    }

    @Override
    public String toString() {
        return Objects.toStringHelper(this)
                .add("resourceId", resourceId)
                .add("lastName", lastName)
                .add("firstName", firstName)
                .add("mail", mail)
                .add("title", title)
                .add("subTitle", subTitle)
                .add("exp", exp)
                .add("blog", blog)
                .add("profils", profils)
                .add("competences", competences)
                .toString();
    }
}
