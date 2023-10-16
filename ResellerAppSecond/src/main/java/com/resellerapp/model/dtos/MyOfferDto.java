package com.resellerapp.model.dtos;

import com.resellerapp.model.entity.OfferEntity;
import com.resellerapp.model.enums.ConditionNameEnum;

import java.util.UUID;

public class MyOfferDto extends BoughtOffersDto{

    private ConditionNameEnum condition;
    private UUID id;

    public MyOfferDto() {
    }

    public MyOfferDto(OfferEntity offer) {
        super(offer);
        this.id = offer.getId();
        this.condition = offer.getCondition().getName();
    }

    public ConditionNameEnum getCondition() {
        return condition;
    }

    public MyOfferDto setCondition(ConditionNameEnum condition) {
        this.condition = condition;
        return this;
    }

    public UUID getId() {
        return id;
    }

    public MyOfferDto setId(UUID id) {
        this.id = id;
        return this;
    }
}
