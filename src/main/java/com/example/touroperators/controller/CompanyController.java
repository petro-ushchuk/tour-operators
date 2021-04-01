package com.example.touroperators.controller;

import com.example.touroperators.api.CompanyApi;
import com.example.touroperators.dto.CompanyDto;
import com.example.touroperators.service.CompanyService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class CompanyController implements CompanyApi {
    private final CompanyService companyService;

    @Override
    public List<CompanyDto> getAllCompanies() {
        return companyService.findAll();
    }

    @Override
    public CompanyDto createCompany(CompanyDto companyDto) {
        return companyService.saveCompany(companyDto);
    }

    @Override
    public CompanyDto getCompany(Long id) {
        return companyService.getCompany(id);
    }

    @Override
    public CompanyDto updateCompany(CompanyDto companyDto) {
        return companyService.saveCompany(companyDto);
    }

    @Override
    public ResponseEntity<Void> deleteCompany(Long id) {
        companyService.deleteCompany(id);
        return ResponseEntity.noContent().build();
    }
}
