package com.tourism.app.controller;

import com.tourism.app.dto.ClientDto;
import com.tourism.app.exception.ValidException;
import com.tourism.app.service.ClientService;
import lombok.AllArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/clients")
@AllArgsConstructor
@Log
public class ClientController {

    private final ClientService clientService;

    @PostMapping("/save")
    public ClientDto saveClient(@RequestBody ClientDto clientDto) throws ValidException {
        log.info("Handling save client: " + clientDto);
        return clientService.saveClient(clientDto);
    }

    @GetMapping("/findAll")
    public List<ClientDto> findAllClient() {
        log.info("Handling find all Client request");
        return clientService.findAll();
    }

    @GetMapping("/findByName/{name}")
    public ClientDto findByName(@PathVariable String name) {
        log.info("Handling find by name request: " + name);
        return clientService.findByName(name);
    }

    @GetMapping("/findByTouristPackageId/{touristPackageId}")
    public List<ClientDto> findByTouristPackageId(@PathVariable Integer touristPackageId) {
        log.info("Handling find by tourist package id request: " + touristPackageId);
        return clientService.findByTouristPackageId(touristPackageId);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteClient(@PathVariable Integer id) {
        log.info("Handling delete client request: " + id);
        clientService.deleteClient(id);
        return ResponseEntity.ok().build();
    }

}
