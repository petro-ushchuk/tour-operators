package com.example.touroperators.dto.validation;

import com.example.touroperators.dto.validation.UniqueUsername.UniqueUsernameValidator;
import com.example.touroperators.service.UserService;
import lombok.RequiredArgsConstructor;

import javax.validation.Constraint;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = UniqueUsernameValidator.class)
public @interface UniqueUsername {

  String message() default "{username.not.unique}";

  Class<?>[] groups() default {};

  Class<? extends Payload>[] payload() default {};

  @RequiredArgsConstructor
  class UniqueUsernameValidator implements ConstraintValidator<UniqueUsername, String> {

    private final UserService userService;

    @Override
    public boolean isValid(String username, ConstraintValidatorContext constraintValidatorContext) {
      return !userService.isUserExists(username);
    }
  }

}
