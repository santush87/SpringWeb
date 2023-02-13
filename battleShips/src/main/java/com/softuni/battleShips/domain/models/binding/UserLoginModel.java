package com.softuni.battleShips.domain.models.binding;

import com.softuni.battleShips.domain.validations.checkUserExistence.ValidateLoginForm;
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
