package com.resellerapp.model.entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;
import java.math.BigDecimal;

@Entity
@Table(name = "offers")
public class OfferEntity extends BaseEntity {

    @Column(nullable = false)
    @Size(min = 2, max = 50)
    private String description;

    @Column(nullable = false)
    @Positive
    private BigDecimal price;

    @ManyToOne
    @NotNull
    private ConditionEntity condition;

    @ManyToOne
    @NotNull
    private UserEntity createdBy;

    @ManyToOne
    private UserEntity boughtBy;

    public String getDescription() {
        return description;
    }

    public OfferEntity setDescription(String description) {
        this.description = description;
        return this;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public OfferEntity setPrice(BigDecimal price) {
        this.price = price;
        return this;
    }

    public ConditionEntity getCondition() {
        return condition;
    }

    public OfferEntity setCondition(ConditionEntity condition) {
        this.condition = condition;
        return this;
    }

    public UserEntity getCreatedBy() {
        return createdBy;
    }

    public OfferEntity setCreatedBy(UserEntity createdBy) {
        this.createdBy = createdBy;
        return this;
    }

    public UserEntity getBoughtBy() {
        return boughtBy;
    }

    public OfferEntity setBoughtBy(UserEntity boughtBy) {
        this.boughtBy = boughtBy;
        return this;
    }
}
