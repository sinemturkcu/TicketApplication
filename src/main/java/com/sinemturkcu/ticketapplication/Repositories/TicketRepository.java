package com.sinemturkcu.ticketapplication.Repositories;

import com.sinemturkcu.ticketapplication.Entities.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TicketRepository extends JpaRepository<Ticket,Long> {
}
