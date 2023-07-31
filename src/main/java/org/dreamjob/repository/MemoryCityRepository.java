package org.dreamjob.repository;

import org.springframework.stereotype.Repository;
import org.dreamjob.model.City;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Repository
public class MemoryCityRepository implements CityRepository {

    private final Map<Integer, City> cities;

    public MemoryCityRepository() {
        cities = new HashMap<>();
        cities.put(1, new City(1, "Moscow"));
        cities.put(2, new City(2, "New-York"));
        cities.put(3, new City(3, "Paris"));
    }

    @Override
    public Collection<City> findAll() {
        return cities.values();
    }

}
