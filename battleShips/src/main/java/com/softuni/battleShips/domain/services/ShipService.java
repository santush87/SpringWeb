package com.softuni.battleShips.domain.services;

import com.softuni.battleShips.domain.repositories.ShipRepository;
import org.springframework.stereotype.Service;

@Service
public class ShipService {
    private final ShipRepository shipRepository;

    public ShipService(ShipRepository shipRepository) {
        this.shipRepository = shipRepository;
    }

    public boolean isThereShip(String shipName){
        return this.shipRepository.findByName(shipName).isPresent();
    }
}
