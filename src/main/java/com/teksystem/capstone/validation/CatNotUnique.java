package com.teksystem.capstone.validation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = CatNotUniqueImpl.class)
@Target({ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface CatNotUnique {
    String message() default "{ProductGroupMatch}";

    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
