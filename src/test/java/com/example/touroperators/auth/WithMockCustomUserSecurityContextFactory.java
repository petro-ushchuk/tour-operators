package com.example.touroperators.auth;

import com.example.touroperators.model.User;
import com.example.touroperators.repository.UserRepository;
import com.example.touroperators.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.test.context.support.WithSecurityContextFactory;

@Configuration
public class WithMockCustomUserSecurityContextFactory
        implements WithSecurityContextFactory<WithMockCustomUser> {

    @Override
    public SecurityContext createSecurityContext(WithMockCustomUser customUser) {
        SecurityContext context = SecurityContextHolder.createEmptyContext();
        User principal = new User();
        principal.setUsername(customUser.username());
        principal.setRole(customUser.role());
        principal.setPassword(customUser.password());
        Authentication auth = new UsernamePasswordAuthenticationToken(principal, customUser.password(), principal.getAuthorities());
        context.setAuthentication(auth);
        return context;
    }
}
