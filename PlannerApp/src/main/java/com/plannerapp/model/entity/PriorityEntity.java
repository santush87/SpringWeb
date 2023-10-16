package com.plannerapp.model.entity;

import com.plannerapp.model.enums.PriorityName;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "priorities")
@NoArgsConstructor
@Getter
@Setter
public class PriorityEntity extends BaseEntity {

    @Column(unique = true, nullable = false)
    private PriorityName name;

    @Column(nullable = false)
    private String description;

    @OneToMany
    private List<TaskEntity> tasks;

    public PriorityEntity(PriorityName name) {
        this.name = name;
        setDescription(name);
        this.tasks = new ArrayList<>();
    }


    public PriorityEntity setDescription(PriorityName priorityName) {
        String currentDesc = "";

        switch (name){
            case LOW -> currentDesc = "Should be fixed if time permits but can be postponed.";
            case URGENT -> currentDesc = "An urgent problem that blocks the system use until the issue is resolved.";
            case IMPORTANT -> currentDesc = "A core functionality that your product is explicitly supposed to perform is compromised.";
        }
        this.description = currentDesc;
        return this;
    }
}
