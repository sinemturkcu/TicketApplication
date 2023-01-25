package com.sinemturkcu.ticketapplication.Entities;

import lombok.Data;

import javax.persistence.*;
import java.util.List;


@Entity
@Data
public class Route {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String departureCity;
    private String destinationCity;

    @ManyToMany
    private List<Vehicle> vehicles;
    /*
    @OneToMany
    private List<Vehicle> vehicles;
     */


}
