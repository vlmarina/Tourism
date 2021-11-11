package com.tourism.app.service;

import com.tourism.app.dto.ClientDto;
import com.tourism.app.exception.ValidException;

import java.util.List;

public interface ClientService {

    ClientDto saveClient(ClientDto clientDto) throws ValidException;

    void deleteClient(Integer clientId);

    ClientDto findByName(String name);

    List<ClientDto> findAll();

    List<ClientDto> findByTouristPackageId(Integer touristPackageId);
}
