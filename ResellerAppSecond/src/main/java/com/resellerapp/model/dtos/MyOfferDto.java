package com.resellerapp.model.dtos;

import com.resellerapp.model.entity.OfferEntity;
import com.resellerapp.model.enums.ConditionNameEnum;

public class MyOfferDto extends BoughtOffersDto{

    private ConditionNameEnum condition;

    public MyOfferDto() {
    }

    public MyOfferDto(OfferEntity offer) {
        super(offer);
        this.condition = offer.getCondition().getName();
    }

    public ConditionNameEnum getCondition() {
        return condition;
    }

    public MyOfferDto setCondition(ConditionNameEnum condition) {
        this.condition = condition;
        return this;
    }
}
