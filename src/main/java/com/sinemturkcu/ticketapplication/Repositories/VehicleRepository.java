package com.sinemturkcu.ticketapplication.Repositories;

import com.sinemturkcu.ticketapplication.Entities.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Repository
public interface VehicleRepository extends JpaRepository<Vehicle,Long> {
}
