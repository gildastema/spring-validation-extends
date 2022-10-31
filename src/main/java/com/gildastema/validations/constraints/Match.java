package com.gildastema.validations.constraints;


import com.gildastema.validations.validators.MatchValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = {MatchValidator.class})
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface Match {

    String message() default "The fields not match";

    public Class<?>[] groups() default {};
    public Class<? extends Payload>[] payload() default {};
    String field();

    String confirmation();
}
