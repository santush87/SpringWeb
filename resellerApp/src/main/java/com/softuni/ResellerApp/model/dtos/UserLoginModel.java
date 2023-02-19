package com.softuni.ResellerApp.model.dtos;

import com.softuni.ResellerApp.vallidation.checkOfferExistence.ValidateLoginForm;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@ValidateLoginForm
public class UserLoginModel {
    private String username;
    private String password;
}
