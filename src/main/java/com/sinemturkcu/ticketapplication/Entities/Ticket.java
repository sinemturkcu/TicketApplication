package com.sinemturkcu.ticketapplication.Entities;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Ticket {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private double price;

    @OneToOne
    Vehicle vehicle;

    @OneToOne
    Route route;

}
