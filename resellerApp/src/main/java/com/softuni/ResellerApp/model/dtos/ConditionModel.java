package com.softuni.ResellerApp.model.dtos;

import com.softuni.ResellerApp.model.enums.ConditonType;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ConditionModel {
    private ConditonType name;

    private String description;
}
