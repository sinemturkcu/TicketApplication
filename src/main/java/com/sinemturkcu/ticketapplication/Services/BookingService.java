package com.sinemturkcu.ticketapplication.Services;

import com.sinemturkcu.ticketapplication.Entities.Booking;
import com.sinemturkcu.ticketapplication.Entities.Ticket;
import org.springframework.stereotype.Component;
import java.util.List;

@Component
public interface BookingService {
    List<Booking> getAll();
    String buyTicket(Booking booking);
    String reservation(Booking booking);
}
