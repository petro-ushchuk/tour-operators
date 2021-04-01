package com.example.touroperators.configuration;

import com.example.touroperators.dto.UserDto;
import com.example.touroperators.model.enums.Role;
import com.example.touroperators.service.AuthService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@Slf4j
public class DemoRunConfig {

    @Bean
    public CommandLineRunner demoCompany(AuthService authService,
                                         @Value("${app.auth.password}") String password,
                                         @Value("${app.auth.username}") String username) {
        log.info("Login with next credentials: " + password + " " + username);
        return args -> {
            UserDto userDto = new UserDto();
            userDto.setUsername(username);
            userDto.setPassword(password);
            log.info(userDto.toString());
            authService.signUp(userDto, Role.ADMIN);
        };
    }
}
