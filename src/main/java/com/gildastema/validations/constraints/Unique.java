package com.gildastema.validations.constraints;


import com.gildastema.validations.validators.UniqueValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = UniqueValidator.class)
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface Unique {

    public String message() default "The field already exist in database";

    public Class<?>[] groups() default {};
    public Class<? extends Payload>[] payload() default {};

    String field();

    String table();
}
