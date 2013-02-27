package org.zenika.skillz.web.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.zenika.skillz.model.Consultant;
import org.zenika.skillz.model.PageConstants;
import org.zenika.skillz.repositories.ConsultantRepository;
import org.zenika.skillz.web.pages.ConsultantListResource;
import org.zenika.skillz.web.pages.ConsultantResource;
import org.zenika.skillz.web.pages.ConsultantShortResource;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Controller
@RequestMapping(value = "/consultants")
public class ConsultantController {

    private static final Logger LOGGER = LoggerFactory.getLogger(ConsultantController.class);


    @Autowired
    private ConsultantRepository consultantRepository;

    @RequestMapping(method = RequestMethod.GET)
    public @ResponseBody ConsultantListResource list(@RequestParam(defaultValue = "0") int page) {
        Collection<Consultant> consultants = consultantRepository.find(page);
        int maxNumberOfConsultants = consultantRepository.getNumberOfConsultants();
        LOGGER.debug("Liste des consultants de la page {} : {}", page, consultants);
        LOGGER.debug("Nombre max de consultants : {}", maxNumberOfConsultants);
        ConsultantListResource consultantsResource = new ConsultantListResource();
        for (Consultant consultant : consultants) {
            consultantsResource.addConsultantResource(new ConsultantShortResource(consultant));
        }

        // à mettre dans le repository..
        int numberOfPages = maxNumberOfConsultants / PageConstants.MAX_ELEMENT_A_PAGE;
        numberOfPages = (maxNumberOfConsultants % PageConstants.MAX_ELEMENT_A_PAGE == 0) ? numberOfPages : numberOfPages+1;
        LOGGER.debug("maxNumberOfConsultants % PageConstants.MAX_ELEMENT_A_PAGE : {}", maxNumberOfConsultants % PageConstants.MAX_ELEMENT_A_PAGE);
        numberOfPages = (numberOfPages == 0) ? 1 : numberOfPages;

        LOGGER.debug("Nombre de page : {}", numberOfPages);
        consultantsResource.setNumberOfPages(numberOfPages);

        return consultantsResource;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public @ResponseBody ConsultantResource getById(@PathVariable long id) {
        return new ConsultantResource(consultantRepository.findById(id));
    }

    @RequestMapping(method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public @ResponseBody ConsultantResource create(@RequestBody ConsultantResource consultantResource) {
        Consultant consultant = consultantRepository.create(consultantResource.asConsultant());
        LOGGER.info("Ajout d'un consultant : {}", consultant);
        return new ConsultantResource(consultant);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    @ResponseStatus(HttpStatus.ACCEPTED)
    public @ResponseBody void update(@RequestBody ConsultantResource consultant) {
        LOGGER.info("Modification du consultant : {}", consultant.getResourceId());
        LOGGER.debug("Modifications: {}", consultant);
        consultantRepository.update(consultant.asConsultant());
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void delete(@PathVariable long id) {
        LOGGER.info("Suppression du consultant : {}", id);
        consultantRepository.remove(id);
    }

    @ExceptionHandler
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    ErrorMessage handleException(Exception ex) {

//        List<FieldError> fieldErrors = ex.getBindingResult().getFieldErrors();
//        List<ObjectError> globalErrors = ex.getBindingResult().getGlobalErrors();
//        List<String> errors = new ArrayList<>(fieldErrors.size() + globalErrors.size());
        LOGGER.error("Erreur : ",ex);
        List<String> errors = new ArrayList<String>();
//        String error;
//        for (FieldError fieldError : fieldErrors) {
//            error = fieldError.getField() + ", " + fieldError.getDefaultMessage();
//            errors.add(error);
//        }
//        for (ObjectError objectError : globalErrors) {
//            error = objectError.getObjectName() + ", " + objectError.getDefaultMessage();
//            errors.add(error);
//        }
        return new ErrorMessage(errors);
    }

    @XmlRootElement
    public class ErrorMessage {

        private List<String> errors;

        public ErrorMessage() {
        }

        public ErrorMessage(List<String> errors) {
            this.errors = errors;
        }

        public List<String> getErrors() {
            return errors;
        }

        public void setErrors(List<String> errors) {
            this.errors = errors;
        }
    }

}