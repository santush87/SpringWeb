package com.softuni.battleShips.domain.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "ships")
public class Ship extends BaseEntity{
    @Column
    private String name;
    @Column
    private Long health;
    @Column
    private Long power;
    @Column
    private Date created;
    @ManyToOne
    private Category category;
    @ManyToOne
    private User user;
}
