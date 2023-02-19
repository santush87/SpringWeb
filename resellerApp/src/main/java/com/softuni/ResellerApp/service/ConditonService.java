package com.softuni.ResellerApp.service;

import com.softuni.ResellerApp.model.dtos.ConditionModel;
import com.softuni.ResellerApp.model.entity.Condition;
import com.softuni.ResellerApp.model.enums.ConditonType;
import com.softuni.ResellerApp.repository.ConditonRepository;
import jakarta.annotation.PostConstruct;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;


@Service
public class ConditonService {

    private final ConditonRepository conditonRepository;
    private final ModelMapper modelMapper;

    public ConditonService(ConditonRepository conditonRepository, ModelMapper modelMapper) {
        this.conditonRepository = conditonRepository;
        this.modelMapper = modelMapper;
    }

    @PostConstruct
    private void postConstruct() {
        if (this.conditonRepository.count() == 0) {
            for (ConditonType type : ConditonType.values()) {
                switch (type) {
                    case GOOD -> this.conditonRepository.saveAndFlush(
                            this.modelMapper.map(ConditionModel.builder()
                                    .name(type)
                                    .description("Some signs of wear and tear or minor defects")
                                    .build(), Condition.class));
                    case EXCELLENT -> this.conditonRepository.saveAndFlush(
                            this.modelMapper.map(ConditionModel.builder()
                                    .name(type)
                                    .description("In perfect condition")
                                    .build(), Condition.class));
                    case ACCEPTABLE -> this.conditonRepository.saveAndFlush(
                            this.modelMapper.map(ConditionModel.builder()
                                    .name(type)
                                    .description("The item is fairly worn but continues to function properly")
                                    .build(), Condition.class));
                }
            }
        }
    }
}
