package com.resellerapp.service;

import com.resellerapp.model.dtos.*;
import com.resellerapp.model.entity.ConditionEntity;
import com.resellerapp.model.entity.OfferEntity;
import com.resellerapp.model.entity.UserEntity;
import com.resellerapp.repository.ConditionRepository;
import com.resellerapp.repository.OfferRepository;
import com.resellerapp.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class OfferService {

    private final OfferRepository offerRepository;
    private final ConditionRepository conditionRepository;
    private final UserRepository userRepository;
    private final LoggedUser loggedUser;

    public OfferService(OfferRepository offerRepository, ConditionRepository conditionRepository, UserRepository userRepository, LoggedUser loggedUser) {
        this.offerRepository = offerRepository;
        this.conditionRepository = conditionRepository;
        this.userRepository = userRepository;
        this.loggedUser = loggedUser;
    }

    public OfferHomeDto getOffersForHomePage() {
        List<OfferEntity> offers = this.offerRepository.findAll();

        List<MyOfferDto> myOffers = new ArrayList<>();
        List<BoughtOffersDto> boughtOffers = new ArrayList<>();
        List<OtherOffersDto> otherOffers = new ArrayList<>();

        String loggedUsername = this.loggedUser.getUsername();

        for (OfferEntity offer : offers) {
            if (offer.getBoughtBy() == null &&
                    offer.getCreatedBy().getUsername()
                    .equals(loggedUsername)) {
                myOffers.add(new MyOfferDto(offer));

            } else if (offer.getBoughtBy() != null &&
                    offer.getBoughtBy().getUsername().equals(loggedUsername)) {
                boughtOffers.add(new BoughtOffersDto(offer));
            } else if (offer.getBoughtBy() == null){
                otherOffers.add(new OtherOffersDto(offer));
            }
        }

        return new OfferHomeDto(myOffers, boughtOffers, otherOffers);
    }

    public boolean create(OfferCreateDto offerCreateDto) {
        ConditionEntity condition =
                this.conditionRepository.findByName(offerCreateDto.getCondition());
        Optional<UserEntity> user =
                this.userRepository.findByUsername(this.loggedUser.getUsername());

        if (condition != null && user != null) {
            OfferEntity offer = new OfferEntity(offerCreateDto, condition, user.get());

            this.offerRepository.save(offer);
            return true;
        }
        return false;
    }

    public void buy(UUID id) {
        Optional<OfferEntity> optOffer = this.offerRepository.findById(id);

        if (optOffer.isPresent()) {
            Optional<UserEntity> user =
                    this.userRepository.findByUsername(this.loggedUser.getUsername());

            OfferEntity offer = optOffer.get();
            offer.setBoughtBy(user.get());

            this.offerRepository.save(offer);
        }
    }
}
