package com.resellerapp.model.dtos;

import com.resellerapp.model.enums.ConditionNameEnum;

import java.math.BigDecimal;

public class OfferCreateDto {

    private String description;
    private BigDecimal price;
    private ConditionNameEnum condition;

    public String getDescription() {
        return description;
    }

    public OfferCreateDto setDescription(String description) {
        this.description = description;
        return this;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public OfferCreateDto setPrice(BigDecimal price) {
        this.price = price;
        return this;
    }

    public ConditionNameEnum getCondition() {
        return condition;
    }

    public OfferCreateDto setCondition(ConditionNameEnum condition) {
        this.condition = condition;
        return this;
    }
}
