package com.resellerapp.model.entity;

import com.resellerapp.model.enums.ConditionNameEnum;

import javax.persistence.*;

@Entity
@Table(name = "conditons")
public class ConditionEntity extends BaseEntity {

    @Column(unique = true, nullable = false)
    @Enumerated(EnumType.STRING)
    private ConditionNameEnum name;

    @Column(nullable = false)
    private String description;

    public ConditionNameEnum getName() {
        return name;
    }

    public ConditionEntity setName(ConditionNameEnum name) {
        this.name = name;
        this.setDescription(name);
        return this;
    }

    public String getDescription() {
        return description;
    }

    public ConditionEntity setDescription(String description) {
        this.description = description;
        return this;
    }

    public ConditionEntity setDescription(ConditionNameEnum name) {
        String currDescr = "";

        switch (name) {
            case GOOD -> currDescr = "Some signs of wear and tear or minor defects";
            case EXCELLENT -> currDescr = "In perfect condition";
            case ACCEPTABLE -> currDescr = "The item is fairly worn but continues to function properly";
        }

        this.description = currDescr;
        return this;
    }
}
