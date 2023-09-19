package com.aleksandrov.battleShips.models.dtos;

import jakarta.validation.constraints.Positive;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class StartBattleDto {

    @Positive
    private int attackerId;

    @Positive
    private int defenderId;
}
