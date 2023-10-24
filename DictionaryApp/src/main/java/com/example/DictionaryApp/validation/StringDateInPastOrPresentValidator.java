package com.example.DictionaryApp.validation;

import com.example.DictionaryApp.annotation.StringDateInPastOrPresent;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.time.LocalDate;

public class StringDateInPastOrPresentValidator implements ConstraintValidator<StringDateInPastOrPresent, String> {
    @Override
    public void initialize(StringDateInPastOrPresent constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if (value != null && !value.isBlank()) {
            LocalDate parse = LocalDate.parse(value);
            return parse.isBefore(LocalDate.now().plusDays(1));
        }
        return false;
    }
}
