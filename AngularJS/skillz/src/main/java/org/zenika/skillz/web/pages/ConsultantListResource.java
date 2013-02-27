package org.zenika.skillz.web.pages;

import java.util.ArrayList;
import java.util.Collection;

public class ConsultantListResource {

    private Integer numberOfPages;
    private Collection<ConsultantShortResource> consultants;

    public ConsultantListResource() {
        consultants = new ArrayList<ConsultantShortResource>();
    }

    public void addConsultantResource(ConsultantShortResource consultantShortResource) {
        consultants.add(consultantShortResource);
    }

    public Collection<ConsultantShortResource> getConsultants() {
        return consultants;
    }

    public Integer getNumberOfPages() {
        return numberOfPages;
    }

    public void setNumberOfPages(Integer numberOfPages) {
        this.numberOfPages = numberOfPages;
    }
}
