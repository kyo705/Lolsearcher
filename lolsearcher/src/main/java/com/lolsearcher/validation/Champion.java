package com.lolsearcher.validation;

import javax.validation.Constraint;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = ChampionValidator.class)
public @interface Champion {
    String message() default "championId is invalid";
    Class[] groups() default {};
    Class[] payload() default {};
}
