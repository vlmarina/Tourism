package com.tourism.app.repository;

import com.tourism.app.model.TouristPackage;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TouristPackageRepository extends JpaRepository<TouristPackage, Integer> {

    TouristPackage findByName(String name);
}
