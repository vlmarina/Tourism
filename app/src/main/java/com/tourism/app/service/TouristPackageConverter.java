package com.tourism.app.service;

import com.tourism.app.dto.TouristPackageDto;
import com.tourism.app.model.TouristPackage;
import org.springframework.stereotype.Component;

@Component
public class TouristPackageConverter {

    public TouristPackageDto fromTouristPackageToTouristPackageDto(TouristPackage touristPackage) {
        TouristPackageDto touristPackageDto = new TouristPackageDto();
        touristPackageDto.setId(touristPackage.getId());
        touristPackageDto.setName(touristPackage.getName());
        touristPackageDto.setDirection(touristPackage.getDirection());
        touristPackageDto.setDateStart(touristPackage.getDateStart());
        touristPackageDto.setDateEnd(touristPackage.getDateEnd());
        touristPackageDto.setDateOfDeparture(touristPackage.getDateOfDeparture());

        touristPackageDto.setClients(touristPackage.getClients());
        return touristPackageDto;
    }

    public TouristPackage fromTouristPackageDtoToTouristPackage(TouristPackageDto touristPackageDto) {
        TouristPackage touristPackage = new TouristPackage();
        touristPackage.setId(touristPackageDto.getId());
        touristPackage.setName(touristPackageDto.getName());
        touristPackage.setDirection(touristPackageDto.getDirection());
        touristPackage.setDateStart(touristPackageDto.getDateStart());
        touristPackage.setDateEnd(touristPackageDto.getDateEnd());
        touristPackage.setDateOfDeparture(touristPackageDto.getDateOfDeparture());

        touristPackage.setClients(touristPackageDto.getClients());
        return touristPackage;
    }
}
