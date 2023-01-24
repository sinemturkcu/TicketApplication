package com.sinemturkcu.ticketapplication.ServicesImpl;

import com.sinemturkcu.ticketapplication.Entities.Booking;
import com.sinemturkcu.ticketapplication.Entities.Enums.TicketStatus;
import com.sinemturkcu.ticketapplication.Entities.Ticket;
import com.sinemturkcu.ticketapplication.Entities.User;
import com.sinemturkcu.ticketapplication.Repositories.BookingRepository;
import com.sinemturkcu.ticketapplication.Repositories.UserRepository;
import com.sinemturkcu.ticketapplication.Services.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.awt.print.Book;
import java.util.List;

@Service
public class BookingServiceImpl implements BookingService {

    BookingRepository bookingRepository;
    UserRepository userRepository;

    @Autowired
    public BookingServiceImpl(BookingRepository bookingRepository, UserRepository userRepository) {
        this.bookingRepository = bookingRepository;
        this.userRepository = userRepository;
    }

    @Override
    public List<Booking> getAll() {
        return bookingRepository.findAll();
    }

    @Override
    public String buyTicket(Booking booking) {

       booking.setTicketStatus(TicketStatus.TICKET_STATUS_PURCHASED);
       bookingRepository.save(booking);
       return "Ticket bought";
    }
}
