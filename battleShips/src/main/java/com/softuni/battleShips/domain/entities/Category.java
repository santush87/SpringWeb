package com.softuni.battleShips.domain.entities;

import com.softuni.battleShips.domain.enums.CategoryEnum;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "categories")
public class Category extends BaseEntity{
    @Enumerated(EnumType.STRING)
    @Column
    private CategoryEnum name;

    @Column(columnDefinition = "TEXT")
    private String description;
}
