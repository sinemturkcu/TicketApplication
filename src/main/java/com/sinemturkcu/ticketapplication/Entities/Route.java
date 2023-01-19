package com.sinemturkcu.ticketapplication.Entities;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
public class Route {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String departureCity;
    private String destinationCity;

    /*
    @OneToMany
    private List<Vehicle> vehicles;
     */


}
