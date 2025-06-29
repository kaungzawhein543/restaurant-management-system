package com.mm.restaurant.application.dtos.custom_validations;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Documented
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = PasswordValidator.class)
public @interface ValidPassword {
    String message() default "Password must contains at least 8 characters and must be match at least 3 policies.\n 1. At least one symbol.\n At least one uppercase latter.\n At least one lowercase latter.\n At least one number.";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
