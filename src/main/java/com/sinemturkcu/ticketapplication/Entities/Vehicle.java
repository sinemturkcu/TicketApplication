package com.sinemturkcu.ticketapplication.Entities;


import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Vehicle {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true)
    private String serialNumber;
    private String vehicleCompany;
    private String seatNumber;
    private String restSeat;

    /*
    @ManyToOne
    @JoinColumn(name = "route_id")
    private Route route;
     */

}
