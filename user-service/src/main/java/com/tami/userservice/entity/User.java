package com.tami.userservice.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name= "users")
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    private String surname;

    @Column(nullable = false, unique = true)
    private String email;

    private String address;

    @Column(nullable = false)
    private boolean alerting = false;

    @Column(name = "energy_alerting_threshold", nullable = false)
    private double energyAlertingThreshold = 0.0;
}
