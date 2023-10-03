package com.openclassrooms.poseidonInc.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class PasswordValidator implements ConstraintValidator<ValidatePassword, String>{

	@Override
	public boolean isValid(String password, ConstraintValidatorContext context) {
		return (password.length()>=8 && password.matches(".*[0-9]{1,}.*") && password.matches(".*[A-Z]{1,}.*") && password.matches(".*[.,:;'!@#$%^&*_+=|(){}?].*"));
	}
}
