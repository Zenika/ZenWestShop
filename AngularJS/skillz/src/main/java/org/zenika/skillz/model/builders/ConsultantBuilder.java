package org.zenika.skillz.model.builders;

import org.zenika.skillz.model.Consultant;

public class ConsultantBuilder {
    private Long id;
    private String lastName;
    private String firstName;

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

    public Consultant build() {
        Consultant consultant = new Consultant();
        consultant.setId(id);
        consultant.setLastName(lastName);
        consultant.setFirstName(firstName);
        return consultant;
    }
}
