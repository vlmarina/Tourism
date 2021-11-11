package com.tourism.app.repository;

import com.tourism.app.model.Client;
import com.tourism.app.model.TouristPackage;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ClientRepository extends JpaRepository<Client, Integer> {

    Client findByName(String name);
    List<Client> findByTouristPackageId(Integer touristPackageId);
}
