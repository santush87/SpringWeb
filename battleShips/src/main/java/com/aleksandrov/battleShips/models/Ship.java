package com.aleksandrov.battleShips.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.Positive;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Table(name = "ships")
@NoArgsConstructor
@Getter
@Setter
public class Ship {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false, unique = true)
    private String name;

    @Column(nullable = false)
    @Positive
    private long health;

    @Positive
    @Column(nullable = false)
    private long power;

    private LocalDate created;

    @ManyToOne //many ships to one user
    private User user;

    @ManyToOne //many ships to one category
    private Category category;


}
