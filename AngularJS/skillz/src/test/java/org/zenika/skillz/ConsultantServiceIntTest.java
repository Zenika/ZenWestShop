package org.zenika.skillz;

import org.junit.BeforeClass;
import org.junit.ClassRule;
import org.junit.Ignore;
import org.junit.Test;
import org.zenika.skillz.model.Consultant;
import org.zenika.skillz.repositories.ConsultantRepository;
import org.zenika.skillz.repositories.impl.InMemoryConsultantRepository;
import org.zenika.test.WebServer;

import static com.jayway.restassured.RestAssured.expect;
import static org.hamcrest.collection.IsCollectionContaining.hasItem;
import static org.hamcrest.core.IsEqual.equalTo;

public class ConsultantServiceIntTest {

    @ClassRule
    public static WebServer server = new WebServer();

    @BeforeClass
    public static void initData() {
        Consultant consultant = new Consultant();
        consultant.setFirstName("Sébastien");
        consultant.setLastName("Brousse");
        ConsultantRepository consultantRepository = new InMemoryConsultantRepository();
        consultantRepository.create(consultant);
    }

    @Test
    @Ignore
    public void should_return_all_consultants() {
        expect().
                body("firstName", hasItem("Sébastien")).
                body("lastName", hasItem("Brousse")).
        when().
                get("/consultant");
    }

    @Test
    @Ignore
    public void should_return_a_consultant() {
        expect().
                body("firstName", equalTo("Sébastien")).
                body("lastName", equalTo("Brousse")).
        when().
                get("/consultant/1");
    }
}