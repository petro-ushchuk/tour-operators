package com.example.touroperators.service;

import com.example.touroperators.dto.CompanyDto;
import com.example.touroperators.dto.TourDto;
import com.example.touroperators.model.Company;
import com.example.touroperators.model.Tour;
import com.example.touroperators.model.User;
import com.example.touroperators.model.enums.Role;
import com.example.touroperators.repository.CompanyRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.HttpClientErrorException;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class CompanyService {

    private final CompanyRepository companyRepository;
    private final MapperService mapperService;


    public CompanyDto saveCompany(CompanyDto companyDto) {
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        Company company = mapperService.mapCompanyDtoToCompany(companyDto);
        company.setOwner(user);
        company = companyRepository.save(company);
        return mapperService.mapCompanyToCompanyDto(company);
    }

    public CompanyDto getCompany(Long id) {
        Company company = companyRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Unable to find company with this id!"));
        List<Tour> tours = company.getTours();
        tours.forEach((e)-> e.setCompany(null));
        CompanyDto companyDto = mapperService.mapCompanyToCompanyDto(company);
        List<TourDto> tourDtos = mapperService.mapToursToTourDtos(tours);
        companyDto.setTours(tourDtos);
        return companyDto;
    }
    @Transactional
    public void deleteCompany(Long id) {
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if(!user.getRole().equals(Role.ADMIN)) {
            Company company = companyRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Unable to find company with this id!"));
            if (!company.getOwner().getId().equals(user.getId()))
                throw new HttpClientErrorException(HttpStatus.FORBIDDEN);
        }
        companyRepository.deleteById(id);
    }

    public List<CompanyDto> findAll() {
        List<Company> companies = companyRepository.findAll();
        return mapperService.mapCompaniesToCompanyDtos(companies);
    }
}

