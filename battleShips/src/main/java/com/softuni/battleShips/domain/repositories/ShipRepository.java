package com.softuni.battleShips.domain.repositories;

import com.softuni.battleShips.domain.entities.Ship;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ShipRepository extends JpaRepository<Ship, String> {

    Optional<Ship> findByName(String name);

    Optional<List<Ship>> findAllByUserId(String id);
}
