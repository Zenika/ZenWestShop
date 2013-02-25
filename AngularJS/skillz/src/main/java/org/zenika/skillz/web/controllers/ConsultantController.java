package org.zenika.skillz.web.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.zenika.skillz.model.Consultant;
import org.zenika.skillz.repositories.ConsultantRepository;
import org.zenika.skillz.web.pages.ConsultantListResource;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping(value = "/consultants")
public class ConsultantController {

    private static final Logger LOGGER = LoggerFactory.getLogger(ConsultantController.class);


    @Autowired
    private ConsultantRepository consultantRepository;

    @RequestMapping(method = RequestMethod.GET)
    public @ResponseBody List<ConsultantListResource> list() {
        List<Consultant> consultants = new ArrayList<Consultant>(consultantRepository.findAll());
        LOGGER.debug("Consultants : {}", consultants);
        List<ConsultantListResource> consultantsResource = new ArrayList<ConsultantListResource>(consultants.size());
        for (Consultant consultant : consultants) {
            ConsultantListResource consultantResource = new ConsultantListResource(consultant);
//            Link detail = linkTo(ConsultantController.class).slash(consultant.getId()).withSelfRel();
//            consultantResource.addLIn(detail);

            consultantsResource.add(consultantResource);
        }

        return consultantsResource;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public @ResponseBody Consultant getById(@PathVariable long id) {
        return consultantRepository.findById(id);
    }

    @RequestMapping(method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public @ResponseBody Consultant create(@RequestBody Consultant consultant) {
//        long id = consultantIdGenerator.incrementAndGet();
//        consultant.setId(id);
        consultantRepository.create(consultant);
        return consultant;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void delete(@PathVariable long id) {
        consultantRepository.remove(id);
    }

}