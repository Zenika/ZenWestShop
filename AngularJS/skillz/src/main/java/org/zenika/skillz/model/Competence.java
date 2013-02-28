package org.zenika.skillz.model;

import com.google.common.base.Objects;

public class Competence {

    private String categorie;
    private String detailedCompetences;

    public String getCategorie() {
        return categorie;
    }

    public void setCategorie(String categorie) {
        this.categorie = categorie;
    }

    public String getDetailedCompetences() {
        return detailedCompetences;
    }

    public void setDetailedCompetences(String detailedCompetences) {
        this.detailedCompetences = detailedCompetences;
    }

    @Override
    public String toString() {
        return Objects.toStringHelper(this)
                .add("categorie", categorie)
                .add("detailedCompetences", detailedCompetences)
                .toString();
    }
}
