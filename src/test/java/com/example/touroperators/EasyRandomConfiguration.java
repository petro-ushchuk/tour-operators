package com.example.touroperators;

import org.jeasy.random.EasyRandom;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class EasyRandomConfiguration {

    @Bean
    public EasyRandom getEasyRandom() {
        return new EasyRandom();
    }
}
