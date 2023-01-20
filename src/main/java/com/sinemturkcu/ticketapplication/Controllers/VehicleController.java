package com.sinemturkcu.ticketapplication.Controllers;

import com.sinemturkcu.ticketapplication.Entities.Vehicle;
import com.sinemturkcu.ticketapplication.Services.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins="*")
@RequestMapping("/api/vehicle")
public class VehicleController {
    VehicleService vehicleService;

    @Autowired
    public VehicleController(VehicleService vehicleService) {
        this.vehicleService = vehicleService;
    }

    @PostMapping("/save")
    public Vehicle saveVehicle(@RequestBody Vehicle vehicle){
        return vehicleService.saveVehicle(vehicle);
    }

    @GetMapping("/getAll")
    public List<Vehicle> getAll(){
        return vehicleService.getAll();
    }

    @DeleteMapping("/delete")
    public void deleteVehicle(@RequestParam Long id){
        vehicleService.deleteVehicle(id);
    }

}
