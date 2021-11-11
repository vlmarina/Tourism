package com.tourism.app.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "tourist_packages")
@Data//генерирует геттеры, сеттеры, иквалс, хеш код методы
@NoArgsConstructor//конструктор без аргуметов
public class TouristPackage {

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "touristPackage", cascade= CascadeType.MERGE)
    private List<Client> clients;

    @Id
    @Column(name = "id")
    @SequenceGenerator(name = "packagesIdSeq", sequenceName = "packages_id_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "packagesIdSeq")
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "direction")
    private String direction;

    @Column(name = "date_start")
    private Date dateStart;

    @Column(name = "date_end")
    private Date dateEnd;

    @Column(name = "date_of_departure")
    private Date dateOfDeparture;


}
