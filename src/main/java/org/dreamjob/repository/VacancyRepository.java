package org.dreamjob.repository;

import org.dreamjob.model.Vacancy;

import java.util.Collection;
import java.util.Optional;

public interface VacancyRepository {

    Vacancy save(Vacancy vacancy);

    boolean deleteById(int id);

    boolean update(Vacancy vacancy);

    Optional<Vacancy> findById(int id);

    Collection<Vacancy> findAll();

}
