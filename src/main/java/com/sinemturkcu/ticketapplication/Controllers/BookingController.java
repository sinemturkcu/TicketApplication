package com.sinemturkcu.ticketapplication.Controllers;

import com.sinemturkcu.ticketapplication.Entities.Booking;
import com.sinemturkcu.ticketapplication.Entities.Ticket;
import com.sinemturkcu.ticketapplication.Services.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.awt.print.Book;
import java.util.List;

@RestController
@CrossOrigin(origins="*")
@RequestMapping("/api/booking")
public class BookingController {
    BookingService bookingService;

    @Autowired
    public BookingController(BookingService bookingService) {
        this.bookingService = bookingService;
    }

    @GetMapping("/getAll")
    public List<Booking> getAll(){
       return bookingService.getAll();
    }

    @PostMapping("/buyTicket")
    public String buyTicket(@RequestBody Booking booking){
        return bookingService.buyTicket(booking);
    }

    @PostMapping("/reservation")
    public String reservation(@RequestBody Booking booking){
        return bookingService.reservation(booking);
    }
}
