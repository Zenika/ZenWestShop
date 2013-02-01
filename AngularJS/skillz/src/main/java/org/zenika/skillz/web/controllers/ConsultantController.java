package org.zenika.skillz.web.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.zenika.skillz.model.Consultant;
import org.zenika.skillz.repositories.ConsultantRepository;

import java.util.ArrayList;
import java.util.List;

@Controller
public class ConsultantController {

    private static final Logger LOGGER = LoggerFactory.getLogger(ConsultantController.class);


    @Autowired
    private ConsultantRepository consultantRepository;

    @RequestMapping(value = "/consultant", method = RequestMethod.GET)
    public @ResponseBody List<Consultant> list() {
        List<Consultant> consultants = new ArrayList<Consultant>(consultantRepository.findAll());
        LOGGER.debug("Consultants : {}", consultants);
        return consultants;

    }

    @RequestMapping(value = "/consultant/{id}", method = RequestMethod.GET)
    public @ResponseBody Consultant getById(@PathVariable long id) {
        return consultantRepository.findById(id);
    }

    @RequestMapping(value = "/consultant", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public @ResponseBody Consultant create(@RequestBody Consultant consultant) {
//        long id = consultantIdGenerator.incrementAndGet();
//        consultant.setId(id);
        consultantRepository.create(consultant);
        return consultant;
    }

    @RequestMapping(value = "/consultant/{id}", method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void delete(@PathVariable long id) {
        consultantRepository.remove(id);
    }

}