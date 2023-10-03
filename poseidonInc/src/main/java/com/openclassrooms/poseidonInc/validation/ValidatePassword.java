package com.openclassrooms.poseidonInc.validation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

@Target({ElementType.FIELD,ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = PasswordValidator.class)
public @interface ValidatePassword {
	
	public String message() default "Invalid password: minimum 8 characters, must have 1 digit, 1 special character and 1 uppercase letter";
	
	Class<?>[] groups() default { };

	Class<? extends Payload>[] payload() default { };
}
