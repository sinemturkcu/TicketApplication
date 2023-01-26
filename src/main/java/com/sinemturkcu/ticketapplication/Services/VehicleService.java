package com.sinemturkcu.ticketapplication.Services;
import com.sinemturkcu.ticketapplication.Entities.Vehicle;
import com.sinemturkcu.ticketapplication.dto.VehicleDto;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface VehicleService {

    Vehicle saveVehicle(Vehicle vehicle);

    String deleteVehicle(Long id);

    List<Vehicle> getAll();

    String updateVehicle(Vehicle vehicle, Long id);

    Vehicle getById(Long id);

    List<Vehicle> getByDirectionsAndDepartureTime(String departureCity, String destinationCity);
}
