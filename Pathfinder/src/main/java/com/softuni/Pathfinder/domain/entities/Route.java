package com.softuni.Pathfinder.domain.entities;

import com.softuni.Pathfinder.domain.enums.Level;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "routes")
public class Route extends BaseEntity{

    @Column(columnDefinition = "TEXT")
    private String gpxCoordinates;

    @Column
    private Level level;

    @Column
    private String name;

    @ManyToOne
    private User author;

    @Column
    private String videoUrl;
}
