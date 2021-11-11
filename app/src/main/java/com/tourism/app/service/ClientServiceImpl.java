package com.tourism.app.service;

import com.tourism.app.dto.ClientDto;
import com.tourism.app.exception.ValidException;
import com.tourism.app.model.Client;
import com.tourism.app.repository.ClientRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

import static java.util.Objects.isNull;

@Service
@AllArgsConstructor
public class ClientServiceImpl implements ClientService {

    private final ClientRepository clientRepository;
    private final ClientConverter clientConverter;

    @Override
    public ClientDto saveClient(ClientDto clientDto) throws ValidException {
        validateClientDto(clientDto);
        Client savedClient=clientRepository.save(clientConverter.fromClientDtoToClient(clientDto));
        return clientConverter.fromClientToClientDto(savedClient);
    }

    @Override
    public void deleteClient(Integer clientId) {

        clientRepository.deleteById(clientId);
    }

    @Override
    public ClientDto findByName(String name) {

        Client client=clientRepository.findByName(name);
        if(client!=null) {
            return clientConverter.fromClientToClientDto(client);
        }
        return null;
    }

    @Override
    public List<ClientDto> findByTouristPackageId(Integer touristPackageId) {
        List<Client> client = clientRepository.findByTouristPackageId(touristPackageId);
        if (client != null) {

            List<ClientDto> clientDto=new ArrayList<>();
            for (Client cl: client) {
                clientDto.add(clientConverter.fromClientToClientDto(cl));
            }
            return clientDto;
        }
        return null;
    }

    @Override
    public List<ClientDto> findAll() {

        List<Client> client = clientRepository.findAll();
        if (client != null) {

            List<ClientDto> clientDto=new ArrayList<>();
            for (Client cl: client) {
                clientDto.add(clientConverter.fromClientToClientDto(cl));
            }
            return clientDto;
        }
        return null;
    }

    private void validateClientDto(ClientDto clientDto) throws ValidException {
        if (isNull(clientDto)) {
            throw new ValidException("Object Client is null");
        }
        if (isNull(clientDto.getName())) {
            throw new ValidException("Client name is empty");
        }
    }
}
