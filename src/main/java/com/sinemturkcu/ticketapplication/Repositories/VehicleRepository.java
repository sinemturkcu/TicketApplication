package com.sinemturkcu.ticketapplication.Repositories;

import com.sinemturkcu.ticketapplication.Entities.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VehicleRepository extends JpaRepository<Vehicle,Long> {
    List<Vehicle> findVehicleByDepartureCityAndDestinationCityAndDepartureTime(String departureCity, String destinationCity, String departureTime);
}
