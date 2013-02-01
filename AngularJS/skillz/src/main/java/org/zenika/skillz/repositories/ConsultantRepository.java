package org.zenika.skillz.repositories;

import org.zenika.skillz.model.Consultant;

import java.util.Collection;

public interface ConsultantRepository {

    Collection<Consultant> findAll();

    Consultant create(Consultant consultant);

    void update(Consultant consultant);

    void remove(long id);

    Consultant findById(long id);
}
