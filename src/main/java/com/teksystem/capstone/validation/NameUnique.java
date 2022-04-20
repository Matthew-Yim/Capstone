package com.teksystem.capstone.validation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = NameUniqueImpl.class)
@Target({ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface NameUnique {
    String message() default "{ProductNameUnique}";

    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
