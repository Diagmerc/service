//package ru.lozovoi.service.domain;
//
//import jakarta.persistence.*;
//import lombok.AllArgsConstructor;
//import lombok.Data;
//import lombok.NoArgsConstructor;
//
//import java.util.Date;
//import java.util.List;
//
//@Data
//@Entity
//@NoArgsConstructor
//@AllArgsConstructor
//public class Car {
//
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;
//
//    @Column(name = "vin")
//    private String VIN;
//
//    @Column(name = "car_birth_date")
//    private Date carBirthDate;
//
//    @Enumerated(EnumType.ORDINAL)
//    private Motor motor;
//
//    @OneToMany
//    private List<ServiceNote> serviceNotes;
//
//}
