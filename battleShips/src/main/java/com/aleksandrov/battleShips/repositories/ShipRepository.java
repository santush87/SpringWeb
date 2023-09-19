package com.aleksandrov.battleShips.repositories;

import com.aleksandrov.battleShips.models.Ship;
import com.aleksandrov.battleShips.models.dtos.ShipDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ShipRepository extends JpaRepository<Ship, Long> {
    Optional<Ship> findByName(String name);

    List<Ship> findByUserId(Long ownerId);
    List<Ship> findByUserIdNot(Long ownerId);

    List<Ship> findAllByOrderByNameAscHealthAscPowerAsc ();


}
