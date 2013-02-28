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
import static org.zenika.skillz.model.builders.CompetenceBuilder.aCompetence;
import static org.zenika.skillz.model.builders.ConsultantBuilder.aConsultant;
import static org.zenika.skillz.model.builders.ProfilBuilder.aProfil;

@Repository
public class InMemoryConsultantRepository implements ConsultantRepository {

    private static final Logger LOGGER = LoggerFactory.getLogger(InMemoryConsultantRepository.class);
    private static final AtomicLong consultantIdGenerator = new AtomicLong(0);
    private static final Map<Long, Consultant> consultantRepository = new ConcurrentSkipListMap<Long, Consultant>();


    @PostConstruct
    public void initData() {
        LOGGER.info("Création du jeux de données...");
        Consultant consultant = aConsultant().withFirstName("Sébastien")
                                             .withLastName("Brousse")
                                             .withExperienceLength(6)
                                             .withMail("sebastien.brousse@zenika.com")
                                             .withProfils(aProfil().withTitle("Architecte").withDescription("Mise en place d'architecture SOA").build(),
                                                     aProfil().withTitle("Consultant").withDescription("Expertise SOA\n" +
                                                             "Mise en place de forge logicielle").build(),
                                                     aProfil().withTitle("Formateur").withDescription("Intégration continue\n" +
                                                             "Tester ses Web Services avec SoapUI Pro\n" +
                                                             "ESB\n" +
                                                             "Web Services\n" +
                                                             "GWT\n" +
                                                             "Git\n" +
                                                             "Architecture RESTful").build())
                                             .withCompetences(aCompetence().withCategorie("Java").withDetailedCompetences("Jav - Eclipse - IntelliJ - Spring").build(),
                                                     aCompetence().withCategorie("Web").withDetailedCompetences("AngularJS - GWT - Wicket - Struts2 - JSP/Servlet - HTML - CSS").build(),
                                                     aCompetence().withCategorie("Persistance").withDetailedCompetences("Hibernate - JPA - JDBC").build(),
                                                     aCompetence().withCategorie("SOA/Intégration").withDetailedCompetences("Camel - Web Services (WS-* - JAX-WS/CXF) - JMS - Spring Batch").build(),
                                                     aCompetence().withCategorie("Serveurs d'applications").withDetailedCompetences("ServiceMix (Fuse ESB 4) - Tomcat 7 - Jetty - Weblogic 10.3 (Oracle SOA Suite)").build(),
                                                     aCompetence().withCategorie("MOM").withDetailedCompetences("ActiveMQ").build(),
                                                     aCompetence().withCategorie("Production logicielle").withDetailedCompetences("Maven - Ant/Ivy - Jenkins/Hudson - Sonar - Nexus - Git - SVN - CVS").build())
                                             .build();
        create(consultant);

        consultant = aConsultant().withFirstName("Alexandre")
                .withLastName("Baron")
                .withExperienceLength(6)
                .withMail("alexandre.baron@zenika.com")
                .withProfils(aProfil().withTitle("Architecte").withDescription("Conception technique et réalisation de plusieurs applications télécom JEE multi-tiers").build(),
                        aProfil().withTitle("Consultant").withDescription("Expertise Java/JEE dans le domaine télécom").build())
                .withCompetences(aCompetence().withCategorie("Java").withDetailedCompetences("Java - Eclipse - Spring").build(),
                        aCompetence().withCategorie("Web").withDetailedCompetences("GWT - JSP/Servlet - Struts - HTML - CSS").build(),
                        aCompetence().withCategorie("Persistance").withDetailedCompetences("Hibernate - JPA - JDBC").build(),
                        aCompetence().withCategorie("SOA/Intégration").withDetailedCompetences("Web Services (WS-* - JAX-WS/CXF) - JMS - Spring Batch").build(),
                        aCompetence().withCategorie("MOM").withDetailedCompetences("Websphere MQ").build())
                .build();

        create(consultant);

        consultant = aConsultant().withFirstName("Martin")
                .withLastName("Mouterde")
                .withExperienceLength(4)
                .withMail("martin.mouterde@zenika.com")
                .withProfils(aProfil().withTitle("Consultant").withDescription("Expertise Java/JEE et Flex sur un projet télécom\n" +
                        "Expertise Agilité Scrum/Kanban, certifié Scrum Master").build(),
                        aProfil().withTitle("Architecte").withDescription("Conception d'une application de manipulation de gros volume de données dans le domaine des télécoms.\n" +
                                "Refonte de l'architecture d'un projet avec un objectif de performance fort").build(),
                        aProfil().withTitle("Formateur").withDescription("Java – Flex").build())
                .withCompetences(aCompetence().withCategorie("Java").withDetailedCompetences("Java - Eclipse - Spring - Swing - Groovy - OSGi").build(),
                        aCompetence().withCategorie("Web").withDetailedCompetences("Flex - Struts - JSP/Servlet - PHP").build(),
                        aCompetence().withCategorie("Persistance").withDetailedCompetences("Hibernate - JPA - JDBC").build(),
                        aCompetence().withCategorie("Serveurs d'applications").withDetailedCompetences("Tomcat 5/6 - Jetty").build(),
                        aCompetence().withCategorie("Production logicielle").withDetailedCompetences("Maven - Ant - Jenkins/Hudson - Sonar - SVN").build())
                .build();

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
