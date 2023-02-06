package com.softuni.Pathfinder.service;

import com.softuni.Pathfinder.domain.dtos.view.MostCommentedRouteViewDto;
import com.softuni.Pathfinder.repository.RouteRepository;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class RouteService {
    private final RouteRepository routeRepository;

    public RouteService(RouteRepository routeRepository) {
        this.routeRepository = routeRepository;
    }

    public MostCommentedRouteViewDto getMostCommented() {
        return MostCommentedRouteViewDto.fromRoute(this.routeRepository
                .findMostCommented()
                .orElseThrow(NoSuchElementException::new)
                .get(0));
    }
}
