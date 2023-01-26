package com.sinemturkcu.ticketapplication.Services;

import com.sinemturkcu.ticketapplication.Entities.Route;
import com.sinemturkcu.ticketapplication.Entities.Ticket;
import com.sinemturkcu.ticketapplication.dto.BuyTicketDto;
import com.sinemturkcu.ticketapplication.dto.TicketDelayDto;
import com.sinemturkcu.ticketapplication.dto.UserEmailDto;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface TicketService {
    void save(long vehicleId);
    void deleteTicket(Long id);
    List<Ticket> getAll();
    String buyTicket(BuyTicketDto buyTicketVM);
    List<Ticket> getTicketsByVehicleId(final long busId);
    List<Ticket> getTicketByUserEmail(final String email);
    String cancelTicket(final String ticketId);
    String delayTicket(final TicketDelayDto ticketDelay);
    List<Ticket> getTicketByUserIdAndFromDirections(final UserEmailDto userEmail);
    List<Ticket> getAllByUserIsNotNull();
}
