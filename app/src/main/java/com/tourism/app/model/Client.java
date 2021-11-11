package com.tourism.app.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "clients")
@Data//генерирует геттеры, сеттеры, иквалс, хеш код методы
@NoArgsConstructor//конструктор без аргуметов
public class Client {

    @JsonIgnore
    @ManyToOne (fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
    @JoinColumn (name="tourist_package_id")
    private TouristPackage touristPackage;

    @Id
    @Column(name = "id")
    @SequenceGenerator(name = "clientsIdSeq", sequenceName = "clients_id_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "clientsIdSeq")
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "age")
    private Integer age;

    @Column(name = "date_of_birth")
    private Date dateOfBirth;

}
