package com.sinemturkcu.ticketapplication.Controllers;

import com.sinemturkcu.ticketapplication.Entities.Route;
import com.sinemturkcu.ticketapplication.Entities.Ticket;
import com.sinemturkcu.ticketapplication.Services.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins="*")
@RequestMapping("/api/ticket")
public class TicketController {
    TicketService ticketService;

    @Autowired
    public TicketController(TicketService ticketService) {
        this.ticketService = ticketService;
    }

    @GetMapping("/getAll")
    public List<Ticket> getAll(){
        return ticketService.getAll();
    }

    @DeleteMapping("/delete")
    public void delete(@RequestParam Long id){
        ticketService.deleteTicket(id);
    }

    @PostMapping("/save")
    public Ticket save(@RequestBody Ticket ticket){
        return ticketService.saveTicket(ticket);
    }
}
