package com.sinemturkcu.ticketapplication.Controllers;

import com.sinemturkcu.ticketapplication.Entities.Route;
import com.sinemturkcu.ticketapplication.Entities.Ticket;
import com.sinemturkcu.ticketapplication.Services.TicketService;
import com.sinemturkcu.ticketapplication.dto.BuyTicketDto;
import com.sinemturkcu.ticketapplication.dto.TicketDelayDto;
import com.sinemturkcu.ticketapplication.dto.UserEmailDto;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins="*")
@RequestMapping("/api/ticket")
@RequiredArgsConstructor
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
    public void save(@RequestParam long id){
         ticketService.save(id);
    }

    @PostMapping("/buy")
    public ResponseEntity<String> buyTicket(@RequestBody BuyTicketDto buyTicketVM) {
        return ResponseEntity.ok(ticketService.buyTicket(buyTicketVM));
    }
    @PostMapping("/cancel")
    public ResponseEntity<String> cancelTicket(@RequestParam String ticketId) {
        return ResponseEntity.ok(ticketService.cancelTicket(ticketId));
    }

    @PostMapping("/delay")
    public ResponseEntity<String> delayTicket(@RequestBody TicketDelayDto ticketDelay) {
        return ResponseEntity.ok(ticketService.delayTicket(ticketDelay));
    }
    @PostMapping("/useridandfromdirections")
    public ResponseEntity<List<Ticket>> getTicketByUserIdAndFromDirections(@RequestBody UserEmailDto userEmail) {
        return ResponseEntity.ok(ticketService.getTicketByUserIdAndFromDirections(userEmail));
    }

    @GetMapping("/getByEmail")
    public ResponseEntity<List<Ticket>> getTicketByUserEmail(@RequestParam String email){
        return ResponseEntity.ok(ticketService.getTicketByUserEmail(email));
    }
    @GetMapping("/getNotNullTickets")
    public ResponseEntity<List<Ticket>> getAllByUserIsNotNull() {
        return ResponseEntity.ok(ticketService.getTicketsByUserNotNull());
    }

    @GetMapping("/filterByStatus")
    public List<Ticket> filterByDate(@RequestParam  String requestDate) {
        return ticketService.filterByDate(requestDate);
    }

    /*
     @GetMapping("/getByFilter")
    public List<Ticket> findTicketsByDepartureCityAndDestinationCity(@RequestParam String departureCity, @RequestParam String destinationCity) {
        return ticketService.findTicketsByDepartureCityAndDestinationCity(departureCity, destinationCity);
    }
     */

}
