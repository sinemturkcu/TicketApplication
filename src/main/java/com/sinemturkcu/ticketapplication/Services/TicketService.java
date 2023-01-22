package com.sinemturkcu.ticketapplication.Services;

import com.sinemturkcu.ticketapplication.Entities.Route;
import com.sinemturkcu.ticketapplication.Entities.Ticket;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface TicketService {
    Ticket saveTicket(Ticket ticket);
    void deleteTicket(Long id);
    Ticket updateTicket(Ticket ticket, Long id);
    List<Ticket> getAll();
    List<Ticket> findTicketsByDepartureCityAndDestinationCity(String departureCity, String destinationCity);

}
