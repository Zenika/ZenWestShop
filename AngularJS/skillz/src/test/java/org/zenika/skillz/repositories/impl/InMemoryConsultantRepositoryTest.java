package org.zenika.skillz.repositories.impl;

import org.junit.Before;
import org.zenika.skillz.repositories.ConsultantRepositoryTest;

public class InMemoryConsultantRepositoryTest extends ConsultantRepositoryTest {

    @Before
    public void init() {
        consultantRepository = new InMemoryConsultantRepository();
    }


}
