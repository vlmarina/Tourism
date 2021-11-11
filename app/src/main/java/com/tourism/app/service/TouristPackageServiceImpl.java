package com.tourism.app.service;

import com.tourism.app.dto.TouristPackageDto;
import com.tourism.app.exception.ValidException;
import com.tourism.app.model.TouristPackage;
import com.tourism.app.repository.TouristPackageRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.*;

import static java.util.Objects.isNull;

@Service
@AllArgsConstructor
public class TouristPackageServiceImpl implements TouristPackageService {

    private final TouristPackageRepository touristPackageRepository;
    private final TouristPackageConverter touristPackageConverter;

    @Override
    public TouristPackageDto saveTouristPackage(TouristPackageDto touristPackageDto) throws ValidException {
        validateTouristPackageDto(touristPackageDto);
        TouristPackage savedTouristPackage = touristPackageRepository.save(touristPackageConverter.fromTouristPackageDtoToTouristPackage(touristPackageDto));
        return touristPackageConverter.fromTouristPackageToTouristPackageDto(savedTouristPackage);
    }

    @Override
    public void deleteTouristPackage(Integer touristPackageId) {

        touristPackageRepository.deleteById(touristPackageId);
    }

    @Override
    public TouristPackageDto findByName(String name) {

        TouristPackage touristPackage = touristPackageRepository.findByName(name);
        if (touristPackage != null) {
            return touristPackageConverter.fromTouristPackageToTouristPackageDto(touristPackage);
        }
        return null;
    }

    @Override
    public List<TouristPackageDto> findAll() {
        List<TouristPackage> touristPackage = touristPackageRepository.findAll();

        if (touristPackage != null) {

            List<TouristPackageDto> touristPackageDto=new ArrayList<>();
            for (TouristPackage tp:touristPackage) {
                touristPackageDto.add(touristPackageConverter.fromTouristPackageToTouristPackageDto(tp));
            }
            return touristPackageDto;
        }
        return null;
    }

    private void validateTouristPackageDto(TouristPackageDto touristPackageDto) throws ValidException {
        if (isNull(touristPackageDto)) {
            throw new ValidException("Object TouristPackage is null");
        }
        if (isNull(touristPackageDto.getName())) {
            throw new ValidException("TouristPackage name is empty");
        }
    }
}
