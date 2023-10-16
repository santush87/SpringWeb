package com.resellerapp.model.dtos;

import com.resellerapp.model.entity.OfferEntity;

public class OtherOffersDto extends MyOfferDto{

    private String sellerUsername;

    public OtherOffersDto() {
    }
    public OtherOffersDto(OfferEntity offer) {
        super(offer);
        this.sellerUsername = offer.getCreatedBy().getUsername();
    }

    public String getSellerUsername() {
        return sellerUsername;
    }

    public OtherOffersDto setSellerUsername(String sellerUsername) {
        this.sellerUsername = sellerUsername;
        return this;
    }
}
