package org.zenika.skillz.repositories;

import org.junit.Before;
import org.junit.Test;
import org.zenika.skillz.model.Consultant;

import java.util.Collection;

import static org.fest.assertions.Assertions.assertThat;
import static org.zenika.skillz.model.builders.ConsultantBuilder.aConsultant;

public abstract class ConsultantRepositoryTest {

    protected ConsultantRepository consultantRepository;

    protected Consultant consultant;

    @Before
    public void initData() {
        consultant = aConsultant().withFirstName("firstName")
                .withLastName("lastName")
                .build();

    }

    @Test
    public void findAll_should_return_a_collection_of_Consultants() {
        Consultant returnedConsultant = consultantRepository.create(consultant);
        Collection<Consultant> returnedConsultants = consultantRepository.findAll();

        assertThat(returnedConsultants).isNotEmpty();
    }

    @Test
    public void create_should_return_a_Consultant_with_an_Id() {
        int expectedSize = consultantRepository.findAll().size() + 1;

        Consultant returnedConsultant = consultantRepository.create(consultant);
        assertThat(returnedConsultant).isNotNull();
        assertThat(returnedConsultant.getId()).isNotNull();
        assertThat(consultantRepository.findAll().size()).isEqualTo(expectedSize);

    }

    @Test
    public void update_should_modify_an_existing_Consultant() {

        Consultant createdConsultant = consultantRepository.create(consultant);

        createdConsultant.setFirstName("modified_firstName");
        Consultant modifiedConsultant = createdConsultant;

        consultantRepository.update(modifiedConsultant);

        Consultant returnedConsultant = consultantRepository.findById(createdConsultant.getId());
        assertThat(returnedConsultant).isNotNull();
        assertThat(returnedConsultant.getFirstName()).isEqualTo("modified_firstName");
    }

    @Test
    public void remove_should_lesser_the_size_of_repository() {
        Consultant createdConsultant = consultantRepository.create(consultant);

        int expectedSize = consultantRepository.findAll().size() - 1;
        consultantRepository.remove(createdConsultant.getId());

        assertThat(consultantRepository.findAll().size()).isEqualTo(expectedSize);
    }

    @Test
    public void testFindById() {
        Consultant createdConsultant = consultantRepository.create(consultant);

        Consultant expectedConsultant = createdConsultant;
        Consultant returnedConsultant = consultantRepository.findById(createdConsultant.getId());

        assertThat(returnedConsultant).isEqualTo(expectedConsultant);
    }
}
