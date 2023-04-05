package ru.lozovoi.service.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "cars")
public class Car {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "vin")
    private String VIN;

//    @Enumerated(EnumType.ORDINAL)
    private String motor;

    @OneToMany
    @JoinColumn(name = "car_id")
    private List<ServiceRecord> serviceRecords;

}
