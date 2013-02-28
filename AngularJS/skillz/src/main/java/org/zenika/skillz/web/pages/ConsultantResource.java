package org.zenika.skillz.web.pages;

import org.zenika.skillz.model.Consultant;

public class ConsultantResource {

    private Long resourceId;

    private String lastName;
    private String firstName;
    private String mail;
    private String title;
    private String subTitle;
    private Integer exp;
    private String blog;

    public ConsultantResource() {
    }

    public ConsultantResource(Consultant consultant) {
        this.resourceId = consultant.getId();
        this.lastName = consultant.getLastName();
        this.firstName = consultant.getFirstName();
//        add(linkTo(ConsultantController.class).slash(consultant.getId()).withSelfRel());
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

    public Consultant asConsultant() {
        Consultant consultant = new Consultant();
        consultant.setId(this.resourceId);
        consultant.setFirstName(this.firstName);
        consultant.setLastName(this.lastName);
        return consultant;
    }
}
