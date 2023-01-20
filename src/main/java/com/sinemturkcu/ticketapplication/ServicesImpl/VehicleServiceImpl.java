package com.sinemturkcu.ticketapplication.ServicesImpl;

import com.sinemturkcu.ticketapplication.Entities.Enums.ErrorCode;
import com.sinemturkcu.ticketapplication.Entities.Vehicle;
import com.sinemturkcu.ticketapplication.Repositories.VehicleRepository;
import com.sinemturkcu.ticketapplication.Services.VehicleService;
import com.sinemturkcu.ticketapplication.exception.GenericException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VehicleServiceImpl implements VehicleService {

    VehicleRepository vehicleRepository;

    @Autowired
    public VehicleServiceImpl(VehicleRepository vehicleRepository) {
        this.vehicleRepository = vehicleRepository;
    }


    @Override
    public Vehicle saveVehicle(Vehicle vehicle){
        return vehicleRepository.save(vehicle);
    }

    @Override
    public void deleteVehicle(Long id) {
        Vehicle vehicle=vehicleRepository.getById(id);
        vehicleRepository.delete(vehicle);

    }

    @Override
    public List<Vehicle> getAll() {
        return vehicleRepository.findAll();
    }
}
