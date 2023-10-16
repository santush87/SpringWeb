package com.plannerapp.model.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDate;

@Entity
@Table(name = "tasks")
@Getter
@Setter
public class TaskEntity extends BaseEntity {
    @Column(nullable = false)
    @Size(min = 2, max = 50)
    private String description;

    @Column(nullable = false)
    @FutureOrPresent
    private LocalDate dueDate;

    @OneToOne
    @NotNull
    private PriorityEntity priority;

    @OneToOne
    private UserEntity user;


}
