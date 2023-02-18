package com.softuni.battleShips.domain.models.binding;

import com.softuni.battleShips.domain.enums.CategoryEnum;
import com.softuni.battleShips.domain.validations.checkShipExistence.ValidateExistenceOfShip;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.sql.Date;


@Getter
@Setter
@NoArgsConstructor
public class ShipAddModel {
    @NotNull
    @Size(min = 2, max = 10)
    @ValidateExistenceOfShip
    private String name;

    @NotNull
    @Positive
    private Long health;

    @NotNull
    @Positive
    private Long power;

    @NotNull
    @PastOrPresent
    private Date created;

    @NotNull
    private CategoryEnum category;

}

