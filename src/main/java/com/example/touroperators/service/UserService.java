package com.example.touroperators.service;

import com.example.touroperators.dto.TourDto;
import com.example.touroperators.dto.UserDto;
import com.example.touroperators.model.Tour;
import com.example.touroperators.model.User;
import com.example.touroperators.repository.TourRepository;
import com.example.touroperators.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;

@Service
@Slf4j
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final TourRepository tourRepository;
    private final MapperService mapperService;


    public UserDto saveUser(UserDto userDto) {
        User user = mapperService.mapUserDtoToUser(userDto);
        user = userRepository.save(user);
        return mapperService.mapUserToUserDto(user);
    }

    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }

    public boolean isUserExists(String username) {
        Optional<User> user = userRepository.findByUsername(username);
        return user.isPresent();
    }

    public UserDto findById(Long id) {
        User user = userRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Unable to find user with this id!"));
        UserDto userDto = mapperService.mapUserToUserDto(user);
        List<Tour> tours = user.getTours();
        List<TourDto> tourDtos = mapperService.mapToursToTourDtos(tours);
        userDto.setTours(tourDtos);
        return userDto;
    }

    @Transactional
    public void addToTourList(Long tourId) {
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        user = userRepository.findByUsername(user.getUsername())
                .orElseThrow(() -> new EntityNotFoundException("Unable to find user with this id!"));
        Tour tour = tourRepository.findById(tourId)
                .orElseThrow(() -> new EntityNotFoundException("Unable to find tour with this id!"));
        user.getTours().add(tour);
        userRepository.save(user);
    }

    @Transactional
    public void deleteFromTourList(Long tourId) {
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        user = userRepository.findByUsername(user.getUsername())
                .orElseThrow(() -> new EntityNotFoundException("Unable to find user with this id!"));
        Tour tour = tourRepository.findById(tourId)
                .orElseThrow(() -> new EntityNotFoundException("Unable to find tour with this id!"));
        user.getTours().remove(tour);
        userRepository.save(user);
    }
}

