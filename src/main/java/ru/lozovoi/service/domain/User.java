package ru.lozovoi.service.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;
import java.util.Set;

@Data
@Entity
@Table(name = "users")
@AllArgsConstructor
@NoArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String password;

    private String email;

    private Date registered;

//    @JoinColumn
//    @ElementCollection(fetch = FetchType.EAGER)
//    private Set<Role> roles;

//    @OneToMany
//    private List<Car> cars;
}
