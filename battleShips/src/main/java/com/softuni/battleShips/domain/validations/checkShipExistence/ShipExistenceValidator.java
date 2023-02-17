package com.softuni.battleShips.domain.validations.checkShipExistence;

import com.softuni.battleShips.domain.services.ShipService;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class ShipExistenceValidator implements ConstraintValidator<ValidateExistenceOfShip, String> {
    private final ShipService shipService;

    public ShipExistenceValidator(ShipService shipService) {
        this.shipService = shipService;
    }

    @Override
    public void initialize(ValidateExistenceOfShip constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(String shipName, ConstraintValidatorContext context) {
        return this.shipService.isThereShip(shipName);
    }
}
