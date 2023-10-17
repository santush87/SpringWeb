package com.plannerapp.model.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Future;
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
    @Future
    private LocalDate dueDate;

    @ManyToOne
    @NotNull
    private PriorityEntity priority;

    @ManyToOne
    private UserEntity assignee;


}
