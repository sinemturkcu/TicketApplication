package com.sinemturkcu.ticketapplication.Entities;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Vehicle {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true)
    private String serialNumber;
    private String vehicleCompany;

    @ManyToOne
    @JoinColumn(name = "route_id")
    private Route route;
}
