package com.softuni.battleShips.domain.entities;

import com.softuni.battleShips.domain.enums.CategoryEnum;
import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "categories")
public class Category extends BaseEntity{
    @Enumerated(EnumType.STRING)
    @Column(unique = true, nullable = false)
    private CategoryEnum name;

    @Column(columnDefinition = "TEXT")
    private String description;
}
