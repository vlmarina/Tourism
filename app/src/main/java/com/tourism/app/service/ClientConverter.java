package com.tourism.app.service;



import com.tourism.app.dto.ClientDto;
import com.tourism.app.model.Client;
import org.springframework.stereotype.Component;

@Component
public class ClientConverter {

    public ClientDto fromClientToClientDto(Client client) {
        ClientDto clientDto = new ClientDto();
        clientDto.setId(client.getId());
        clientDto.setName(client.getName());
        clientDto.setAge(client.getAge());
        clientDto.setDateOfBirth(client.getDateOfBirth());

        clientDto.setTouristPackage(client.getTouristPackage());
        return clientDto;
    }

    public Client fromClientDtoToClient(ClientDto clientDto) {
        Client client = new Client();
        client.setId(clientDto.getId());
        client.setName(clientDto.getName());
        client.setAge(clientDto.getAge());
        client.setDateOfBirth(clientDto.getDateOfBirth());

        client.setTouristPackage(clientDto.getTouristPackage());
        return client;
    }
}
