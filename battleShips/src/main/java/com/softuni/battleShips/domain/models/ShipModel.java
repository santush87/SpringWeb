package com.softuni.battleShips.domain.models;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Positive;
import lombok.*;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ShipModel {

    private String name;

    @NotNull
    @Positive
    private Long health;

    @NotNull
    @Positive
    private Long power;

    private Date created;

    @NotNull
    private CategoryModel category;
    private UserModel user;
}
