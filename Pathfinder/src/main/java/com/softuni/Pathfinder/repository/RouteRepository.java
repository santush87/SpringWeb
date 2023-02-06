package com.softuni.Pathfinder.repository;

import com.softuni.Pathfinder.domain.entities.Route;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface RouteRepository extends JpaRepository<Route, Long> {

    @Query("SELECT r FROM Route AS r ORDER BY SIZE(r.comments) DESC")
    Optional<List<Route>> findMostCommented();
}
