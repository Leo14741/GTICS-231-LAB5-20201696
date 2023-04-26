package com.example.gtics231lab520201696.Repository;

import com.example.gtics231lab520201696.Entitys.Country;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CountryRepository extends JpaRepository<Country, String> {
}