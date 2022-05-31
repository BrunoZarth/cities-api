package com.brunozarth.citiesapi.countries.resources;

import com.brunozarth.citiesapi.countries.entities.Country;
import com.brunozarth.citiesapi.countries.repositories.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/countries")
public class CountryResource {

    private final CountryRepository countryRepository;

    public CountryResource(final CountryRepository countryRepository) {
        this.countryRepository = countryRepository;
    }

    @GetMapping
    public Page<Country> countries(Pageable pageable){
        return countryRepository.findAll(pageable);
    }

    @GetMapping("/{country}")
    public ResponseEntity<Country> getOne(@PathVariable Long country){
        Optional<Country> optional = countryRepository.findById(country);

        return optional.map(value -> ResponseEntity.ok().body(value)).orElseGet(() -> ResponseEntity.notFound().build());

    }

}
