package com.smarty.resource.facebook.validator;

import com.smarty.resource.facebook.utils.constants.FacebookConstants;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ ElementType.TYPE })
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = { FacebookPostsRequestDTOValidator.class, FacebookReactionsRequestValidator.class})
public @interface Validate
{

    /**
     * Validation message.
     *
     * @return message text
     */
    String message() default FacebookConstants.EMPTY;

    /**
     * Validation groups.
     *
     * @return validation groups
     */
    Class<?>[] groups() default {};

    /**
     * Validation payload.
     *
     * @return validation payload
     */
    Class<? extends Payload>[] payload() default {};
}