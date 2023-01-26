package com.sinemturkcu.ticketapplication.Controllers;

import com.sinemturkcu.ticketapplication.Entities.User;
import com.sinemturkcu.ticketapplication.Entities.Vehicle;
import com.sinemturkcu.ticketapplication.Services.VehicleService;
import com.sinemturkcu.ticketapplication.dto.VehicleDto;
import com.sinemturkcu.ticketapplication.responses.GenericResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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

    @PostMapping("/saveVehicle")
    public GenericResponse saveVehicle(@RequestBody Vehicle vehicle){
        vehicleService.saveVehicle(vehicle);
        return new GenericResponse("Vehicle created successfully");
    }

    @GetMapping("/getAll")
    public List<Vehicle> getAll(){
        return vehicleService.getAll();
    }

    @DeleteMapping("/delete/")
    public ResponseEntity<String> deleteVehicle(@RequestParam Long id){
        return ResponseEntity.ok(vehicleService.deleteVehicle(id));
    }

    @PostMapping("/update")
    public ResponseEntity<String> updateVehicle(@RequestBody Vehicle vehicle, @RequestParam Long id) {
        return ResponseEntity.ok(vehicleService.updateVehicle(vehicle, id));
    }

    @GetMapping("/getVehicle/")
    public ResponseEntity<List<Vehicle>> getByDepartureAndDirections(@RequestParam String departureCity, @RequestParam String destinationCity) {
        return ResponseEntity.ok(vehicleService.getByDirectionsAndDepartureTime(departureCity,destinationCity));
    }

}
