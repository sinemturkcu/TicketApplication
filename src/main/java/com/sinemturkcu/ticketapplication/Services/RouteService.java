package com.sinemturkcu.ticketapplication.Services;

import com.sinemturkcu.ticketapplication.Entities.Route;
import org.springframework.stereotype.Component;

@Component
public interface RouteService {
    Route saveRoute(Route route);
    void deleteRoute(Long id);

}
