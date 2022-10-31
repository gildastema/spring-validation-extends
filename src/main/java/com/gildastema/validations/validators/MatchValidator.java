package com.gildastema.validations.validators;


import com.gildastema.validations.constraints.Match;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.lang.reflect.Field;

public class MatchValidator implements ConstraintValidator<Match, Object> {

    private String value;
    private String valueToConfirm;

    @Override
    public void initialize(Match constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
        value = constraintAnnotation.field();
        valueToConfirm = constraintAnnotation.confirmation();
    }

    @Override
    public boolean isValid(Object confirmedClass, ConstraintValidatorContext constraintValidatorContext) {
        try {
            final Field valueField = confirmedClass.getClass().getDeclaredField(value);
            valueField.setAccessible(true);
            final Field valueToConfirmField = confirmedClass.getClass().getDeclaredField(valueToConfirm);
            valueToConfirmField.setAccessible(true);
           return valueField.get(confirmedClass).equals(valueToConfirmField.get(confirmedClass));
        } catch (NoSuchFieldException | IllegalAccessException e) {
            throw new RuntimeException(e);
        }

    }
}
