package com.aleksandrov.battleShips.models.dtos;

import com.aleksandrov.battleShips.models.Ship;
import lombok.Getter;

@Getter
public class ShipDto {

    private long id;

    private String name;

    private long health;
    private long power;

    public ShipDto(Ship ship) {
        this.id = ship.getId();
        this.name = ship.getName();
        this.health = ship.getHealth();
        this.power = ship.getPower();
    }
}
