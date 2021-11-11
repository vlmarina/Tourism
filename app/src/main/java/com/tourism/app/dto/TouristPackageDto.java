package com.tourism.app.dto;

import com.tourism.app.model.Client;
import lombok.Builder;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class TouristPackageDto {

    private Integer id;
    private String name;
    private String direction;
    private Date dateStart;
    private Date dateEnd;
    private Date dateOfDeparture;

    private List<Client> clients;

}
