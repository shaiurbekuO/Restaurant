package restaurant.restaurant.validation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import jakarta.validation.constraints.Email;

import java.lang.annotation.*;


@Documented
@Constraint(
        validatedBy = PhoneNumberValidator.class
)
@Target({ElementType.METHOD, ElementType.FIELD, ElementType.ANNOTATION_TYPE, ElementType.CONSTRUCTOR, ElementType.PARAMETER, ElementType.TYPE_USE})
@Retention(RetentionPolicy.RUNTIME)
public @interface PhoneNumberValidation {
    String message() default "{Phone number starts with '+996' and contains 9 digits}";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

}
