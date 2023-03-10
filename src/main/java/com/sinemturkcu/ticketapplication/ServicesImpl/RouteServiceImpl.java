package com.sinemturkcu.ticketapplication.ServicesImpl;

import com.sinemturkcu.ticketapplication.Entities.Route;
import com.sinemturkcu.ticketapplication.Repositories.RouteRepository;
import com.sinemturkcu.ticketapplication.Services.RouteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RouteServiceImpl implements RouteService {

    RouteRepository routeRepository;

    @Autowired
    public RouteServiceImpl(RouteRepository routeRepository) {
        this.routeRepository = routeRepository;
    }

    @Override
    public Route saveRoute(Route route) {
        return routeRepository.save(route);
    }

    @Override
    public void deleteRoute(Long id) {
        Route route=routeRepository.getById(id);
        routeRepository.delete(route);
    }

    @Override
    public Route updateRoute(Route route, Long id) {
        Route route1=routeRepository.getById(id);
        return routeRepository.save(route1);
    }

    @Override
    public List<Route> getAll() {
        return routeRepository.findAll();
    }
}
