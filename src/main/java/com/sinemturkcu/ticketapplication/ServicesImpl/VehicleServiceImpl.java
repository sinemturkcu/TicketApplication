package com.sinemturkcu.ticketapplication.ServicesImpl;

import com.sinemturkcu.ticketapplication.Entities.Vehicle;
import com.sinemturkcu.ticketapplication.Repositories.TicketRepository;
import com.sinemturkcu.ticketapplication.Repositories.VehicleRepository;
import com.sinemturkcu.ticketapplication.Services.VehicleService;
import com.sinemturkcu.ticketapplication.dto.VehicleDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VehicleServiceImpl implements VehicleService {

    VehicleRepository vehicleRepository;
     TicketRepository ticketRepository;
    @Autowired
    public VehicleServiceImpl(VehicleRepository vehicleRepository, TicketRepository ticketRepository) {
        this.vehicleRepository = vehicleRepository;
        this.ticketRepository = ticketRepository;
    }


    @Override
    public Vehicle saveVehicle(Vehicle vehicle){
        return vehicleRepository.save(vehicle);
    }

    @Override
    public String deleteVehicle(Long id) {
        Vehicle vehicle=vehicleRepository.getById(id);
        vehicleRepository.delete(vehicle);
        return "Bus deleted successfully";

    }

    @Override
    public List<Vehicle> getAll() {
        return vehicleRepository.findAll();
    }

    @Override
    public String updateVehicle(Vehicle vehicle,Long id) {
        Vehicle vehicle1 = vehicleRepository.findById(id).orElse(null);
        if (vehicle1 != null) {
            ticketRepository.deleteAllByVehicleId(id);
            vehicle1.setDepartureTime(vehicle.getDepartureTime());
            vehicle1.setDepartureCity(vehicle.getDepartureCity());
            vehicle1.setDestinationCity(vehicle.getDestinationCity());
            vehicleRepository.save(vehicle1);
            return "Vehicle updated successfully";
        }
        return "Vehicle not found";
    }

    @Override
    public Vehicle getById(Long id) {
        return vehicleRepository.findById(id).orElse(null);
    }

    @Override
    public List<Vehicle> getByDirectionsAndDepartureTime(String departureCity, String destinationCity) {
        return vehicleRepository.findVehicleByDepartureCityAndDestinationCity(departureCity,destinationCity);
    }

}
