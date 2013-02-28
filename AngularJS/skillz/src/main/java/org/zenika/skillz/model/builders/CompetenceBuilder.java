package org.zenika.skillz.model.builders;

import org.zenika.skillz.model.Competence;

public class CompetenceBuilder {
    private String categorie;
    private String detailedCompetences;

    private CompetenceBuilder() {
    }

    public static CompetenceBuilder aCompetence() {
        return new CompetenceBuilder();
    }

    public CompetenceBuilder withCategorie(String categorie) {
        this.categorie = categorie;
        return this;
    }

    public CompetenceBuilder withDetailedCompetences(String detailedCompetences) {
        this.detailedCompetences = detailedCompetences;
        return this;
    }

    public Competence build() {
        Competence competence = new Competence();
        competence.setCategorie(categorie);
        competence.setDetailedCompetences(detailedCompetences);
        return competence;
    }
}
