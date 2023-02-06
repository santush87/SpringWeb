package com.softuni.Pathfinder.service;

import com.softuni.Pathfinder.repository.RouteRepository;
import org.springframework.stereotype.Service;

@Service
public class RouteService {
    private final RouteRepository routeRepository;

    public RouteService(RouteRepository routeRepository) {
        this.routeRepository = routeRepository;
    }


}
