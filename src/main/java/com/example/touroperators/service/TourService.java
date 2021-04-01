package com.example.touroperators.service;

import com.example.touroperators.dto.TourDto;
import com.example.touroperators.dto.UserDto;
import com.example.touroperators.model.Company;
import com.example.touroperators.model.Tour;
import com.example.touroperators.model.User;
import com.example.touroperators.model.enums.TourType;
import com.example.touroperators.repository.CompanyRepository;
import com.example.touroperators.repository.TourRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;

@Service
@Slf4j
@RequiredArgsConstructor
public class TourService {

    private final TourRepository tourRepository;
    private final CompanyRepository companyRepository;
    private final MapperService mapperService;

    @Transactional
    public TourDto saveTour(TourDto tourDto) {
        final Tour tour = mapperService.mapTourDtoToTour(tourDto);
        Company company = tour.getCompany();
        log.info(company.getCompanyName());
        Optional<Company> optionalCompany = companyRepository.findByCompanyName(company.getCompanyName());
        optionalCompany.ifPresentOrElse(tour::setCompany, () -> tour.setCompany(companyRepository.save(company)));
        return mapperService.mapTourToTourDto(tourRepository.save(tour));
    }

    public TourDto getTour(Long id) {
        Tour tour = tourRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Unable to find tour with this id!"));
        return getTourDto(tour);
    }

    private TourDto getTourDto(Tour tour) {
        List<User> participants = tour.getParticipants();
        TourDto tourDto = mapperService.mapTourToTourDto(tour);
        List<UserDto> usersDtos = mapperService.mapUsersToUserDtos(participants);
        tourDto.setParticipants(usersDtos);
        return tourDto;
    }

    public void deleteTour(Long id) {
        tourRepository.deleteById(id);
    }

    public List<TourDto> findAll() {
        List<Tour> tours = tourRepository.findAll();
        return mapperService.mapToursToTourDtos(tours);
    }

    public List<TourDto> findByType(TourType type) {
        List<Tour> tours = tourRepository.findAllByTourType(type);
        return mapperService.mapToursToTourDtos(tours);
    }
}

