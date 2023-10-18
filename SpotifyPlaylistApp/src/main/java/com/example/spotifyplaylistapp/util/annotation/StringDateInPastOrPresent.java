package com.example.spotifyplaylistapp.util.annotation;

import com.example.spotifyplaylistapp.util.StringDateInPastOrPresentValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Target(FIELD)
@Retention(RUNTIME)
@Constraint(validatedBy = StringDateInPastOrPresentValidator.class)
public @interface StringDateInPastOrPresent {
    String message() default "Date is not now or past!";

    Class<?>[] groups() default { };

    Class<? extends Payload>[] payload() default { };
}
