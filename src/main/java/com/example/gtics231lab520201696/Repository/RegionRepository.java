package com.example.gtics231lab520201696.Repository;

import com.example.gtics231lab520201696.Entitys.Region;
import org.springframework.data.jpa.repository.JpaRepository;

import java.math.BigDecimal;

public interface RegionRepository extends JpaRepository<Region, BigDecimal> {
}