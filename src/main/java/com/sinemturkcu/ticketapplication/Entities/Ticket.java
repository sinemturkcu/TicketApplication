package com.sinemturkcu.ticketapplication.Entities;

import com.sinemturkcu.ticketapplication.Entities.Enums.TicketStatus;
import lombok.Data;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
@Data
public class Ticket {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private double price;
    private String departureTime;
    private String arrivalTime;

    @OneToOne
    Vehicle vehicle;

    @OneToOne
    Route route;





}
