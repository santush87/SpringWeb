package com.softuni.battleShips.domain.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.*;

import java.sql.Date;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "ships")
public class Ship extends BaseEntity{
    @Column(unique = true, nullable = false)
    private String name;
    @Column(nullable = false)
    private Long health;
    @Column(nullable = false)
    private Long power;
    @Column(nullable = false)
    private Date created;
    @ManyToOne
    private Category category;
    @ManyToOne
    private User user;

    @Override
    public String toString() {
        String text = "| $s    | $s    | $s    |";

        return String.format(text, name, health, power);
    }
}
