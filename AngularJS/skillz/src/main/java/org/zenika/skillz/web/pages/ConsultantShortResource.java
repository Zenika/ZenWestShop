package org.zenika.skillz.web.pages;

import com.google.common.base.Function;
import com.google.common.base.Joiner;
import com.google.common.collect.Collections2;
import com.sun.istack.internal.Nullable;
import org.zenika.skillz.model.Consultant;
import org.zenika.skillz.model.Profil;

import java.util.Collection;

public class ConsultantShortResource {

    private Long resourceId;
    private String fullName;
    private String profils;
    private String competence;

    public ConsultantShortResource() {

    }

    public ConsultantShortResource(Consultant consultant) {
        this.resourceId = consultant.getId();
        this.fullName = consultant.getFullName();
        this.profils = Joiner.on(" / ").join(getTitlesOfProfils(consultant));
    }

    private Collection<String> getTitlesOfProfils(Consultant consultant) {
        return Collections2.transform(consultant.getProfils(), new Function<Profil, String>() {
            @Override
            public String apply(@Nullable Profil profil) {
                return profil.getTitle();
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

    public String getCompetence() {
        return competence;
    }
}
