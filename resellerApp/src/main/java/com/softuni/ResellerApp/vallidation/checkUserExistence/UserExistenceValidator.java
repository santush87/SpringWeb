package com.softuni.ResellerApp.vallidation.checkUserExistence;

import com.softuni.ResellerApp.service.UserService;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class UserExistenceValidator implements ConstraintValidator<ValidateExistenceOfShip, String> {
    private final UserService userService;

    public UserExistenceValidator(UserService userService) {
        this.userService = userService;
    }

    @Override
    public void initialize(ValidateExistenceOfShip constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(String shipName, ConstraintValidatorContext context) {
        return false;
//        return this.userService.isThereShip(shipName);
    }
}
