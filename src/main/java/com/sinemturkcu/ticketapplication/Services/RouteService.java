package com.sinemturkcu.ticketapplication.Services;

import com.sinemturkcu.ticketapplication.Entities.Route;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface RouteService {
    Route saveRoute(Route route);
    void deleteRoute(Long id);
    Route updateRoute(Route route, Long id);
    List<Route> getAll();
}
