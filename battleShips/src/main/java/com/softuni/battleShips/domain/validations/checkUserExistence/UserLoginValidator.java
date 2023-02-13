package com.softuni.battleShips.domain.validations.checkUserExistence;

import com.softuni.battleShips.domain.models.UserModel;
import com.softuni.battleShips.domain.models.binding.UserLoginModel;
import com.softuni.battleShips.domain.services.UserService;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class UserLoginValidator implements ConstraintValidator<ValidateLoginForm, UserLoginModel> {

    private final UserService userService;

    public UserLoginValidator(UserService userService) {
        this.userService = userService;
    }

    @Override
    public void initialize(ValidateLoginForm constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(UserLoginModel userLoginModel, ConstraintValidatorContext context) {
        UserModel user = this.userService.findByUsername(userLoginModel.getUsername());
        return  user.getId() != null
                && user.getPassword().equals(userLoginModel.getPassword());
    }
}
