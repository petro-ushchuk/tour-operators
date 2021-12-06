package com.example.touroperators.service;

import com.example.touroperators.auth.WithMockCustomUser;
import com.example.touroperators.dto.CompanyDto;
import com.example.touroperators.model.User;
import com.example.touroperators.repository.UserRepository;
import org.aspectj.lang.annotation.Before;
import org.jeasy.random.EasyRandom;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.core.context.SecurityContextHolder;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

@SpringBootTest
@WithMockCustomUser
public class CompanyServiceTest {

    @Autowired
    private EasyRandom generator;

    private CompanyDto companyDto;

    @Autowired
    private CompanyService companyService;

    @BeforeEach
    void setUp(){
        companyDto = generator.nextObject(CompanyDto.class);
        companyDto.setTours(null);
        companyDto.setOwner(null);
    }

    @Test
    void createCompany() {
        CompanyDto savedCompany = companyService.saveCompany(companyDto);
        assertEquals(companyDto.getCompanyName(), savedCompany.getCompanyName());
    }

    @Test
    void updateCompany() {
        CompanyDto afterSave = companyService.saveCompany(this.companyDto);
        afterSave.setCompanyName(generator.nextObject(String.class));
        CompanyDto afterUpdate = companyService.saveCompany(afterSave);

        assertEquals(afterSave.getId(), afterUpdate.getId());
        assertEquals(afterSave.getCompanyName(), afterUpdate.getCompanyName());
        assertNotEquals(companyDto.getCompanyName(), afterUpdate.getCompanyName());
    }


}
