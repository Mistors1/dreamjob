package org.dreamjob.repository;

import org.dreamjob.model.Vacancy;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Repository
public class MemoryVacancyRepository implements VacancyRepository {

    private int nextId = 1;

    private final Map<Integer, Vacancy> vacancies = new HashMap<>();

    public MemoryVacancyRepository() {
        save(new Vacancy(0, "Intern Java Developer", "1", LocalDateTime.now(), true, 1, 0));
        save(new Vacancy(0, "Junior Java Developer", "2",  LocalDateTime.now(), true, 3, 0));
        save(new Vacancy(0, "Junior+ Java Developer", "3",  LocalDateTime.now(), true, 3, 0));
        save(new Vacancy(0, "Middle Java Developer", "4",  LocalDateTime.now(), true, 2, 0));
        save(new Vacancy(0, "Middle+ Java Developer", "5",  LocalDateTime.now(), true, 2, 0));
        save(new Vacancy(0, "Senior Java Developer", "6",  LocalDateTime.now(), true, 1, 0));
    }

    @Override
    public Vacancy save(Vacancy vacancy) {
        vacancy.setId(nextId++);
        vacancies.put(vacancy.getId(), vacancy);
        return vacancy;
    }

    @Override
    public boolean deleteById(int id) {
        return vacancies.remove(id) != null;
    }

    @Override
    public boolean update(Vacancy vacancy) {
        return vacancies.computeIfPresent(vacancy.getId(), (id, oldVacancy) ->
                new Vacancy(oldVacancy.getId(),
                        vacancy.getTitle(),
                        vacancy.getDescription(),
                        vacancy.getCreationDate(),
                        vacancy.getVisible(),
                        vacancy.getCityId(),
                        vacancy.getFileId())) != null;
    }

    @Override
    public Optional<Vacancy> findById(int id) {
        return Optional.ofNullable(vacancies.get(id));
    }

    @Override
    public Collection<Vacancy> findAll() {
        return vacancies.values();
    }

}
