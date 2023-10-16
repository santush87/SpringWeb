package com.resellerapp.model.dtos;

import com.resellerapp.model.entity.OfferEntity;

import java.math.BigDecimal;

public class BoughtOffersDto {

    private String description;
    private BigDecimal price;


    public BoughtOffersDto() {
    }

    public BoughtOffersDto(OfferEntity offer) {
        this.description = offer.getDescription();
        this.price = offer.getPrice();
    }

    public String getDescription() {
        return description;
    }

    public BoughtOffersDto setDescription(String description) {
        this.description = description;
        return this;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public BoughtOffersDto setPrice(BigDecimal price) {
        this.price = price;
        return this;
    }
}
