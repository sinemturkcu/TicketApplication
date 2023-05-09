package com.sinemturkcu.ticketapplication.Controllers;

import com.sinemturkcu.ticketapplication.Entities.Route;
import com.sinemturkcu.ticketapplication.Services.RouteService;
import io.swagger.annotations.ApiModel;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins="*")
@RequestMapping("/api/route")
@ApiModel(value = "Ticket api documentation", description = "Model")
public class RouteController {
    RouteService routeService;

    @Autowired
    public RouteController(RouteService routeService) {
        this.routeService = routeService;
    }

    @PostMapping("/save")
    public Route save(@RequestBody Route route){
        return routeService.saveRoute(route);
    }

    @DeleteMapping("/delete")
    public void delete(@RequestParam Long id){
        routeService.deleteRoute((id));
    }
    @PutMapping("/update/{id}")
    public Route update(@RequestBody Route route, @PathVariable Long id){
        return routeService.updateRoute(route,id);
    }
    @GetMapping("/getAll")
    public List<Route> getAll(){
        return routeService.getAll();
    }
}
