package com.softuni.Pathfinder.domain.entities;

import com.softuni.Pathfinder.domain.enums.CategoryTypeEnum;
import jakarta.persistence.*;

@Entity
@Table(name = "categories")
public class Category extends BaseEntity{

    @Enumerated(EnumType.STRING)
    private CategoryTypeEnum name;

    @Column(columnDefinition = "TEXT")
    private String description;

    public Category() {
    }

    public CategoryTypeEnum getName() {
        return name;
    }

    public Category setName(CategoryTypeEnum name) {
        this.name = name;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public Category setDescription(String description) {
        this.description = description;
        return this;
    }
}
