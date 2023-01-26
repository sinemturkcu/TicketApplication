package com.sinemturkcu.ticketapplication.Repositories;

import com.sinemturkcu.ticketapplication.Entities.Ticket;
import com.sinemturkcu.ticketapplication.Entities.User;
import com.sinemturkcu.ticketapplication.dto.BuyTicketDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TicketRepository extends JpaRepository<Ticket,String> ,JpaSpecificationExecutor<Ticket> {
    List<Ticket> getAllByVehicleIdOrderByTicketSeat(Long busId);
    List<Ticket> findByUser(User user);
    List<Ticket> findByUserAndFromDirection(User user, String fromDirection);
    void deleteAllByVehicleId(Long busId);
    List<Ticket> getTicketsByUserNotNull();
    List<Ticket> getTicketsByUserNull();




}
