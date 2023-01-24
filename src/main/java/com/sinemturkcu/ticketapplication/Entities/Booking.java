package com.sinemturkcu.ticketapplication.Entities;

import com.sinemturkcu.ticketapplication.Entities.Enums.TicketStatus;
import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Booking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    User user;

    @ManyToOne
    Ticket ticket;

    @Enumerated(EnumType.STRING)
    private TicketStatus ticketStatus;


}
