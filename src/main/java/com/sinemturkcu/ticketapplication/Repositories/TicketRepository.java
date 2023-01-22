package com.sinemturkcu.ticketapplication.Repositories;

import com.sinemturkcu.ticketapplication.Entities.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TicketRepository extends JpaRepository<Ticket,Long> {

    @Query(value = "SELECT fm from Ticket fm " +
            " where ((:requestDepartureCity IS NULL OR fm.route.departureCity =: requestDepartureCity) and (:requestDestinationCity IS NULL OR fm.route.destinationCity =: requestDestinationCity)) "
    )
    List<Ticket> findTicketsByDepartureCityAndDestinationCity(String requestDepartureCity, String requestDestinationCity);
}
