/***************************************************************
 * Author       :	 
 * Created Date :	
 * Version      : 	
 * History  :	
 * *************************************************************/
package com.mm.zwel.application.data_transfer_objects.custom_validations;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

/**
 * UsernameValidator Class.
 * <p>
 * </p>
 *
 * @author Zwel Naing Oo
 */

public class UsernameValidator implements ConstraintValidator<ValidUsername, String> {

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if (value == null || value.isEmpty()) {
            return true; // Let @NotBlank or @NotNull handle it
        }

        boolean startsWithNumber = value.matches("^\\d.*");
        boolean hasInvalidChars = !value.matches("^[A-Za-z][A-Za-z\\d]*$");

        if (startsWithNumber || hasInvalidChars) {
            context.disableDefaultConstraintViolation();

            if (startsWithNumber) {
                context
                        .buildConstraintViolationWithTemplate("Username must not start with a number")
                        .addConstraintViolation();
            }

            if (hasInvalidChars) {
                context
                        .buildConstraintViolationWithTemplate("Username can only contain letters and digits")
                        .addConstraintViolation();
            }

            return false;
        }

        return true;
    }
}
