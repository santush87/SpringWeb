package com.resellerapp.service;

import com.resellerapp.model.dtos.BoughtOffersDto;
import com.resellerapp.model.dtos.MyOfferDto;
import com.resellerapp.model.dtos.OfferHomeDto;
import com.resellerapp.model.dtos.OtherOffersDto;
import com.resellerapp.model.entity.OfferEntity;
import com.resellerapp.repository.OfferRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class OfferService {

    private final OfferRepository offerRepository;
    private final LoggedUser loggedUser;

    public OfferService(OfferRepository offerRepository, LoggedUser loggedUser) {
        this.offerRepository = offerRepository;
        this.loggedUser = loggedUser;
    }

    public OfferHomeDto getOffersForHomePage() {
        List<OfferEntity> offers = this.offerRepository.findAll();

        List<MyOfferDto> myOffers = new ArrayList<>();
        List<BoughtOffersDto> boughtOffers = new ArrayList<>();
        List<OtherOffersDto> otherOffers = new ArrayList<>();

        String loggedUsername = this.loggedUser.getUsername();

        for (OfferEntity offer : offers) {
            if (offer.getCreatedBy().getUsername()
                    .equals(loggedUsername)) {
                myOffers.add(new MyOfferDto(offer));

            } else if (offer.getBoughtBy().getUsername()
                    .equals(loggedUsername)) {
                boughtOffers.add(new BoughtOffersDto(offer));
            } else {
                otherOffers.add(new OtherOffersDto(offer));
            }
        }

        return new OfferHomeDto(myOffers, boughtOffers, otherOffers);
    }

}
