package com.plannerapp.annotation;

import com.plannerapp.vallidation.StringDateInFutureValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Target(FIELD)
@Retention(RUNTIME)
@Constraint(validatedBy = StringDateInFutureValidator.class)
public @interface StringDateInFuture {
    String message() default "Date is not in the future!";

    Class<?>[] groups() default { };

    Class<? extends Payload>[] payload() default { };
}
