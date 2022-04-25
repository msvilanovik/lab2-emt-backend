package com.finki.backend.service;

import com.finki.backend.domain.Country;
import com.finki.backend.repository.CountryRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CountryService {

    private final CountryRepository repository;

    public CountryService(CountryRepository repository) {
        this.repository = repository;
    }

    public List<Country> findAll() {
        return repository.findAll();
    }

    public Country save(Country country) {
        return repository.save(country);
    }
}
