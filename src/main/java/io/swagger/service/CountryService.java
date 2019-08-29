package io.swagger.service;

import io.swagger.entity.CountryEntity;
import io.swagger.model.Country;
import io.swagger.repository.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CountryService {
    @Autowired
    private CountryRepository countryRepository;

    public List<Country> listAll() {
        List<Country> results = new ArrayList<>();
        for(CountryEntity entity: countryRepository.findAll()) {
            Country country = new Country();
            country.setCode(entity.getCode());
            country.setName(entity.getName());
            country.setPopulation(entity.getPopulation());
            results.add(country);
        }
        return results;
    }
}
