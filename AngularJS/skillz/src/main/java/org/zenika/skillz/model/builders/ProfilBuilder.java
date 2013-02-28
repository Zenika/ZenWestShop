package org.zenika.skillz.model.builders;

import org.zenika.skillz.model.Profil;

public class ProfilBuilder {

    private String title;
    private String description;

    private ProfilBuilder() {
    }

    public static ProfilBuilder aProfil() {
        return new ProfilBuilder();
    }

    public ProfilBuilder withTitle(String title) {
        this.title = title;
        return this;
    }

    public ProfilBuilder withDescription(String description) {
        this.description = description;
        return this;
    }

    public Profil build() {
        Profil profil = new Profil();
        profil.setTitle(title);
        profil.setDescription(description);
        return profil;
    }
}
