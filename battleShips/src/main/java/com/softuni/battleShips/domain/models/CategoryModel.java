package com.softuni.battleShips.domain.models;

import com.softuni.battleShips.domain.enums.CategoryEnum;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CategoryModel {

    private String id;
    private CategoryEnum name;

    private String description;
}
