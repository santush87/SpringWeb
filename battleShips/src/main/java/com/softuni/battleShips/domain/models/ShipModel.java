package com.softuni.battleShips.domain.models;

import com.softuni.battleShips.domain.entities.Category;
import com.softuni.battleShips.domain.entities.User;
import com.softuni.battleShips.domain.models.CategoryModel;
import com.softuni.battleShips.domain.models.UserModel;
import com.softuni.battleShips.domain.validations.checkShipExistence.ValidateExistenceOfShip;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor

public class ShipModel {
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
    private CategoryModel category;

}

