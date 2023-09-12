package com.aleksandrov.battleShips.models;

import com.aleksandrov.battleShips.enums.ShipType;
import jakarta.persistence.*;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "categories")
@NoArgsConstructor
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Enumerated(EnumType.ORDINAL)
    @Column(unique = true, nullable = false)
    private ShipType name;

    @Column(columnDefinition = "text")
    private String description;

    public Category(ShipType name) {
        this.name = name;
    }
}

