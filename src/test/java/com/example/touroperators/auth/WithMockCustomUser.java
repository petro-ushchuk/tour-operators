package com.example.touroperators.auth;

import com.example.touroperators.model.enums.Role;
import org.springframework.security.test.context.support.WithSecurityContext;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
@WithSecurityContext(factory = WithMockCustomUserSecurityContextFactory.class)
public @interface WithMockCustomUser {

    String username() default "bobby@bobby.bobby";
    String password() default "password";
    Role role() default Role.COMPANY_HEAD;
}