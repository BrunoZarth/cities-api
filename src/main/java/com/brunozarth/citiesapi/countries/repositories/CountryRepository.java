package com.brunozarth.citiesapi.countries.repositories;

import com.brunozarth.citiesapi.countries.entities.Country;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.awt.print.Pageable;

@Repository
public interface CountryRepository extends JpaRepository<Country, Long> {
}
