package org.zenika.skillz.model.builders;

import org.zenika.skillz.model.Competence;
import org.zenika.skillz.model.Consultant;
import org.zenika.skillz.model.Profil;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class ConsultantBuilder {
    private Long id;
    private String lastName;
    private String firstName;
    private String mail;
    private String title;
    private String subTitle;
    private Integer experienceLength;
    private Set<Competence> competences;
    private Set<Profil> profils = new HashSet<Profil>();

    private ConsultantBuilder() {
    }

    public static ConsultantBuilder aConsultant() {
        return new ConsultantBuilder();
    }

    public ConsultantBuilder withId(Long id) {
        this.id = id;
        return this;
    }

    public ConsultantBuilder withLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public ConsultantBuilder withFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public ConsultantBuilder withMail(String mail) {
        this.mail = mail;
        return this;
    }

    public ConsultantBuilder withTitle(String title) {
        this.title = title;
        return this;
    }

    public ConsultantBuilder withSubTitle(String subTitle) {
        this.subTitle = subTitle;
        return this;
    }

    public ConsultantBuilder withExperienceLength(Integer experienceLength) {
        this.experienceLength = experienceLength;
        return this;
    }

    public ConsultantBuilder withCompetences(Set<Competence> competences) {
        this.competences = competences;
        return this;
    }

    public ConsultantBuilder withProfils(Profil... profils) {
        this.profils = new HashSet<Profil>(Arrays.asList(profils));
        return this;
    }

    public Consultant build() {
        Consultant consultant = new Consultant();
        consultant.setId(id);
        consultant.setLastName(lastName);
        consultant.setFirstName(firstName);
        consultant.setMail(mail);
        consultant.setTitle(title);
        consultant.setSubTitle(subTitle);
        consultant.setExperienceLength(experienceLength);
        consultant.setCompetences(competences);
        consultant.setProfils(profils);
        return consultant;
    }
}
