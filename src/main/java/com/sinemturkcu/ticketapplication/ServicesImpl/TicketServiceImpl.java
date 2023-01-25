
package com.sinemturkcu.ticketapplication.ServicesImpl;
import com.sinemturkcu.ticketapplication.Entities.Enums.TicketStatus;
import com.sinemturkcu.ticketapplication.Entities.Ticket;
import com.sinemturkcu.ticketapplication.Entities.User;
import com.sinemturkcu.ticketapplication.Entities.Vehicle;
import com.sinemturkcu.ticketapplication.Repositories.TicketRepository;
import com.sinemturkcu.ticketapplication.Services.TicketService;
import com.sinemturkcu.ticketapplication.Services.UserService;
import com.sinemturkcu.ticketapplication.Services.VehicleService;
import com.sinemturkcu.ticketapplication.dto.BuyTicketDto;
import com.sinemturkcu.ticketapplication.dto.TicketDelayDto;
import com.sinemturkcu.ticketapplication.dto.UserEmailDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class TicketServiceImpl implements TicketService {

    private final TicketRepository ticketRepository;
    private final VehicleService busService;
    private final UserService userService;

    @Transactional
    public void save(long busId) {
        Vehicle inDB = busService.getById(busId);
        ArrayList<Ticket> tickets = new ArrayList<>();
        System.out.println(inDB.getCapacity());
        for (int i = 1; i <= inDB.getCapacity(); i++) {
            Ticket ticket = new Ticket();
            UUID uuid = UUID.randomUUID();
            ticket.setId(uuid.toString());
            ticket.setStatus(TicketStatus.TICKET_STATUS_FREE);
            ticket.setTicketDate(new Date().toString());
            ticket.setTicketPrice(inDB.getSeatPrice());
            ticket.setToDirection(inDB.getDestinationCity());
            ticket.setFromDirection(inDB.getDepartureCity());
            ticket.setTicketNumber(i);
            ticket.setBusDepartureTime(inDB.getDepartureTime());
            ticket.setVehicle(inDB);
            ticket.setUser(null);
            ticket.setTicketSeat(i);
            tickets.add(ticket);
        }
        ticketRepository.saveAllAndFlush(tickets);
    }

    public List<Ticket> getTicketsByBusId(final long busId) {
        return ticketRepository.getAllByVehicleIdOrderByTicketSeat(busId);
    }



    @Override
    public void deleteTicket(Long id) {
        ticketRepository.deleteAllByVehicleId(id);
    }


    @Override
    public List<Ticket> getAll() {
        return ticketRepository.findAll();
    }

    @Transactional
    public String buyTicket(final BuyTicketDto buyTicketVM) {
        User inDBUser = userService.findByEmail(buyTicketVM.getUserEmail());
        if (inDBUser == null) {
            return "User not found";
        }
        Ticket inDBTicket = ticketRepository.getById(buyTicketVM.getSeatId());
        if (inDBTicket.getStatus() != TicketStatus.TICKET_STATUS_FREE) {
            return "Ticket is not free";
        }
        inDBTicket.setStatus(TicketStatus.TICKET_STATUS_PURCHASED);
        inDBTicket.setUser(inDBUser);
        ticketRepository.save(inDBTicket);
        return "Ticket bought";
    }

    @Override
    public List<Ticket> getTicketsByVehicleId(long busId) {
        return null;
    }

    public List<Ticket> getTicketByUserEmail(final String email) {
        User inDBUser = userService.findByEmail(email);
        if (inDBUser == null) {
            return new ArrayList<>();
        }
        return  ticketRepository.findByUser(inDBUser);
    }

    @Override
    public String cancelTicket(String ticketId) {
        Ticket inDBTicket = ticketRepository.getById(ticketId);
        if (inDBTicket.getStatus() != TicketStatus.TICKET_STATUS_PURCHASED) {
            return "Ticket is not sold";
        }
        if (inDBTicket.getTicketDate().compareTo(new Date().toString()) < 0) {
            return "Ticket is expired";
        }
        inDBTicket.setStatus(TicketStatus.TICKET_STATUS_FREE);
        inDBTicket.setUser(null);
        ticketRepository.save(inDBTicket);
        return "Ticket canceled";
    }

    @Override
    public String delayTicket(TicketDelayDto ticketDelay) {
        Ticket inDBTicket = ticketRepository.getById(ticketDelay.getTicketId());

        if (inDBTicket.getStatus() != TicketStatus.TICKET_STATUS_PURCHASED) {
            return "Ticket is not sold";
        }
        if (inDBTicket.getTicketDate().compareTo(new Date().toString()) < 0) {
            return "Ticket is expired";
        }
        inDBTicket.setTicketDate(ticketDelay.getDate());
        inDBTicket.setStatus(TicketStatus.TICKET_STATUS_DELAYED);
        System.out.println(ticketDelay.getDate() + " " + ticketDelay.getTicketId());
        ticketRepository.save(inDBTicket);
        return "Ticket delayed";
    }

    @Override
    public List<Ticket> getTicketByUserIdAndFromDirections(UserEmailDto userEmail) {
        User inDBUser = userService.findByEmail(userEmail.getEmail());
        if (inDBUser == null) {
            return new ArrayList<>();
        }
        final List<Ticket> byUserAndFromDirection = ticketRepository.findByUserAndFromDirection(inDBUser, userEmail.getFromDirection());
        if (byUserAndFromDirection.isEmpty()) {
            return new ArrayList<>();
        }
        return byUserAndFromDirection;
    }

}
