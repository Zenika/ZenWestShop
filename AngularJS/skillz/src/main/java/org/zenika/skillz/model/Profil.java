package org.zenika.skillz.model;

public class Profil {

    private enum TYPE {
        CONFERENCIER,ARCHITECTE,CONSULTANT
    }

    private String title;
    private String description;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Profil{" +
                "title='" + title + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
