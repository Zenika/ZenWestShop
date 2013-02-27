package org.zenika.skillz.repositories.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import org.zenika.skillz.model.Consultant;
import org.zenika.skillz.repositories.ConsultantRepository;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentSkipListMap;
import java.util.concurrent.atomic.AtomicLong;

import static org.zenika.skillz.model.PageConstants.MAX_ELEMENT_A_PAGE;

@Repository
public class InMemoryConsultantRepository implements ConsultantRepository {

    private static final Logger LOGGER = LoggerFactory.getLogger(InMemoryConsultantRepository.class);
    private static final AtomicLong consultantIdGenerator = new AtomicLong(0);
    private static final Map<Long, Consultant> consultantRepository = new ConcurrentSkipListMap<Long, Consultant>();


    @PostConstruct
    public void initData() {
        LOGGER.info("Création du jeux de données...");
        Consultant consultant = new Consultant();
        consultant.setFirstName("Sébastien");
        consultant.setLastName("Brousse");
        create(consultant);
    }

    @Override
    public Collection<Consultant> findAll() {
        Collection<Consultant> consultants = consultantRepository.values();
        LOGGER.debug("consultants : {}", consultants);
        return consultantRepository.values();
    }

    @Override
    public Consultant create(Consultant consultant) {
        long id = consultantIdGenerator.incrementAndGet();
        consultant.setId(id);
        consultantRepository.put(id, consultant);
        return consultant;
    }

    @Override
    public void update(Consultant consultant) {
        consultantRepository.put(consultant.getId(), consultant);
    }

    @Override
    public void remove(long id) {
        consultantRepository.remove(id);
    }

    @Override
    public Consultant findById(long id) {
        return consultantRepository.get(id);
    }

    @Override
    public Collection<Consultant> find(int page) {
        Collection<Consultant> consultantCollection = consultantRepository.values();
        List<Consultant> consultants = new ArrayList<Consultant>(consultantCollection);
        Collection<Consultant> pageOfConsultants = new ArrayList<Consultant>(MAX_ELEMENT_A_PAGE);
        int startElement = page * MAX_ELEMENT_A_PAGE;
        LOGGER.trace("startElement : {}", startElement);
        int maxNumberOfConsultant = consultantCollection.size();
        LOGGER.trace("maxNumberOfConsultant : {}", maxNumberOfConsultant);
        int counter = startElement <= maxNumberOfConsultant ? startElement : maxNumberOfConsultant - MAX_ELEMENT_A_PAGE;
        LOGGER.trace("counter : {}", counter);
        counter = counter <= 0 ? 0 : counter;
        LOGGER.trace("counter < : {}", counter);
        while (counter < (startElement+MAX_ELEMENT_A_PAGE) && counter < maxNumberOfConsultant) {
            Consultant consultant = consultants.get(counter);
            LOGGER.trace("Ajout du consultant {} dans la page", consultant.getId());
            pageOfConsultants.add(consultant);
            counter++;
        }
        return pageOfConsultants;
    }

    @Override
    public int getNumberOfConsultants() {
        return consultantRepository.size();
    }

}
