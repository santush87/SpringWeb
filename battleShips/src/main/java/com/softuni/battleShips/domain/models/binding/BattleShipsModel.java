package com.softuni.battleShips.domain.models.binding;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class BattleShipsModel {

    private Long loggedUserWithShips;
    private Long notLoggedUserWithShips;
}
