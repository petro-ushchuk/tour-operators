package com.example.touroperators.service;

import com.example.touroperators.dto.CompanyDto;
import com.example.touroperators.dto.TourDto;
import com.example.touroperators.dto.UserDto;
import com.example.touroperators.model.Company;
import com.example.touroperators.model.Tour;
import com.example.touroperators.model.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface MapperService {

    Company mapCompanyDtoToCompany(CompanyDto companyDto);

    @Mapping(target = "tours", ignore = true)
    CompanyDto mapCompanyToCompanyDto(Company company);

    Tour mapTourDtoToTour(TourDto tourDto);

    @Mapping(target = "participants", ignore = true)
    TourDto mapTourToTourDto(Tour tour);

    @Mapping(target = "participants", ignore = true)
    List<TourDto> mapToursToTourDtos(List<Tour> tour);

    @Mapping(target = "authorities", ignore = true)
    User mapUserDtoToUser(UserDto userDto);

    @Mapping(target = "tours", ignore = true)
    @Mapping(target = "repeatPassword", ignore = true)
    UserDto mapUserToUserDto(User user);

    @Mapping(target = "tours", ignore = true)
    @Mapping(target = "repeatPassword", ignore = true)
    List<UserDto> mapUsersToUserDtos(List<User> participants);

    @Mapping(target = "tours", ignore = true)
    List<CompanyDto> mapCompaniesToCompanyDtos(List<Company> companies);
}
