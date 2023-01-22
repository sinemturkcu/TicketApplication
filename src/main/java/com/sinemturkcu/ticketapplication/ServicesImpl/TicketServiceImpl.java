package com.sinemturkcu.ticketapplication.ServicesImpl;

import com.sinemturkcu.ticketapplication.Entities.Route;
import com.sinemturkcu.ticketapplication.Entities.Ticket;
import com.sinemturkcu.ticketapplication.Repositories.TicketRepository;
import com.sinemturkcu.ticketapplication.Services.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TicketServiceImpl implements TicketService {

    TicketRepository ticketRepository;

    @Autowired
    public TicketServiceImpl(TicketRepository ticketRepository) {
        this.ticketRepository = ticketRepository;
    }

    @Override
    public Ticket saveTicket(Ticket ticket) {
        return ticketRepository.save(ticket);
    }

    @Override
    public void deleteTicket(Long id) {
        Ticket ticket=ticketRepository.getById(id);
        ticketRepository.delete(ticket);
    }

    @Override
    public Ticket updateTicket(Ticket ticket, Long id) {
        return null;
    }

    @Override
    public List<Ticket> getAll() {
        return ticketRepository.findAll();
    }

    @Override
    public List<Ticket> findTicketsByDepartureCityAndDestinationCity(String departureCity, String destinationCity) {
        return ticketRepository.findTicketsByDepartureCityAndDestinationCity(departureCity, destinationCity);
    }


}
