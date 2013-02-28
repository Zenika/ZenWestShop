package org.zenika.skillz.web.pages;

import com.google.common.base.Function;
import com.google.common.base.Joiner;
import com.google.common.collect.Collections2;
import com.sun.istack.internal.Nullable;
import org.zenika.skillz.model.Competence;
import org.zenika.skillz.model.Consultant;
import org.zenika.skillz.model.Profil;

import java.util.Collection;

public class ConsultantShortResource {

    private Long resourceId;
    private String fullName;
    private String profils;
    private String competences;

    public ConsultantShortResource() {

    }

    public ConsultantShortResource(Consultant consultant) {
        this.resourceId = consultant.getId();
        this.fullName = consultant.getFullName();
        this.profils = Joiner.on(" / ").join(getTitlesOfProfils(consultant));
        this.competences = Joiner.on(" / ").join(getCategoriesOfCompetences(consultant));
    }

    Collection<String> getTitlesOfProfils(Consultant consultant) {
        return Collections2.transform(consultant.getProfils(), new Function<Profil, String>() {
            @Override
            public String apply(@Nullable Profil profil) {
                return profil.getTitle();
            }
        });
    }

    Collection<String> getCategoriesOfCompetences(Consultant consultant) {
        return Collections2.transform(consultant.getCompetences(), new Function<Competence, String>() {
            @Override
            public String apply(@Nullable Competence competence) {
                return competence.getCategorie();
            }
        });
    }

    public Long getResourceId() {
        return resourceId;
    }

    public String getFullName() {
        return fullName;
    }

    public String getProfils() {
        return profils;
    }

    public String getCompetences() {
        return competences;
    }
}
