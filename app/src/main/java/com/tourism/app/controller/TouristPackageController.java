package com.tourism.app.controller;

import com.tourism.app.dto.TouristPackageDto;
import com.tourism.app.exception.ValidException;
import com.tourism.app.service.TouristPackageService;
import lombok.AllArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/touristPackages")
@AllArgsConstructor
@Log
public class TouristPackageController {

    private final TouristPackageService touristPackageService;

    @PostMapping("/save")
    public TouristPackageDto saveTouristPackage(@RequestBody TouristPackageDto touristPackageDto) throws ValidException {
        log.info("Handling save touristPackage: " + touristPackageDto);
        return touristPackageService.saveTouristPackage(touristPackageDto);
    }

    @GetMapping("/findAll")
    public List<TouristPackageDto> findAllTouristPackage() {
        log.info("Handling find all touristPackage request");
        return touristPackageService.findAll();
    }

    @GetMapping("/findByName/{name}")
    public TouristPackageDto findByName(@PathVariable String name) {
        log.info("Handling find by name request: " + name);
        return touristPackageService.findByName(name);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteTouristPackage(@PathVariable Integer id) {
        log.info("Handling delete touristPackage request: " + id);
        touristPackageService.deleteTouristPackage(id);
        return ResponseEntity.ok().build();
    }

}
