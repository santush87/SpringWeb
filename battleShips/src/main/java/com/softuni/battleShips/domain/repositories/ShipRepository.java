package com.softuni.battleShips.domain.repositories;

import com.softuni.battleShips.domain.entities.Ship;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShipRepository extends JpaRepository<Ship, String> {
}
