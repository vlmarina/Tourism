package com.tourism.app.dto;

import com.tourism.app.model.TouristPackage;
import lombok.Data;

import java.util.Date;

@Data
public class ClientDto {

    private Integer id;
    private String name;
    private Integer age;
    private Date dateOfBirth;

    private TouristPackage touristPackage;

}
