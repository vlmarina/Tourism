package com.tourism.app.service;

import com.tourism.app.dto.TouristPackageDto;
import com.tourism.app.exception.ValidException;

import java.util.List;

public interface TouristPackageService {

    TouristPackageDto saveTouristPackage(TouristPackageDto touristPackageDto) throws ValidException;

    void deleteTouristPackage(Integer touristPackageId);

    TouristPackageDto findByName(String name);

    List<TouristPackageDto> findAll();
}
