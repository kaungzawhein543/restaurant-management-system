
package com.mm.restaurant.application.dtos.custom_validations;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;


public class PasswordValidator implements ConstraintValidator<ValidPassword, String> {

    @Override
    public boolean isValid(String password, ConstraintValidatorContext constraintValidatorContext) {
        if (password == null || password.length() < 8) return false;

        int count = 0;

        if (password.matches(".*[A-Z].*")) count++;
        if (password.matches(".*[a-z].*")) count++;
        if (password.matches(".*\\d.*")) count++;
        if (password.matches(".*[^a-zA-Z0-9].*")) count++;

        return count >= 3;
    }
}
