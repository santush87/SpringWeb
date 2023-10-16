package com.resellerapp.model.dtos;

import java.util.List;

public class OfferHomeDto {

    private List<MyOfferDto> myOffers;
    private List<BoughtOffersDto> boughtOffers;
    private List<OtherOffersDto> allOtherOffers;
    private long totalOtherOffers;

    public OfferHomeDto(List<MyOfferDto> myOffers, List<BoughtOffersDto> boughtOffers, List<OtherOffersDto> otherOffers) {
        this.myOffers = myOffers;
        this.boughtOffers = boughtOffers;
        this.allOtherOffers = otherOffers;
        this.totalOtherOffers = otherOffers.size();
    }

    public List<MyOfferDto> getMyOffers() {
        return myOffers;
    }

    public OfferHomeDto setMyOffers(List<MyOfferDto> myOffers) {
        this.myOffers = myOffers;
        return this;
    }

    public List<BoughtOffersDto> getBoughtOffers() {
        return boughtOffers;
    }

    public OfferHomeDto setBoughtOffers(List<BoughtOffersDto> boughtOffers) {
        this.boughtOffers = boughtOffers;
        return this;
    }

    public List<OtherOffersDto> getAllOtherOffers() {
        return allOtherOffers;
    }

    public OfferHomeDto setAllOtherOffers(List<OtherOffersDto> allOtherOffers) {
        this.allOtherOffers = allOtherOffers;
        return this;
    }

    public long getTotalOtherOffers() {
        return totalOtherOffers;
    }

    public OfferHomeDto setTotalOtherOffers(long totalOtherOffers) {
        this.totalOtherOffers = totalOtherOffers;
        return this;
    }
}
