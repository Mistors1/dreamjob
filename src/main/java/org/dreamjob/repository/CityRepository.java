package org.dreamjob.repository;

import org.dreamjob.model.City;

import java.util.Collection;

public interface CityRepository {

    Collection<City> findAll();
}
