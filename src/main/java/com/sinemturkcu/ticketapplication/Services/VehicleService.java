package com.sinemturkcu.ticketapplication.Services;
import com.sinemturkcu.ticketapplication.Entities.Vehicle;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface VehicleService  {

    Vehicle saveVehicle(Vehicle vehicle);
    void deleteVehicle(Long id);
    List<Vehicle> getAll();
}
