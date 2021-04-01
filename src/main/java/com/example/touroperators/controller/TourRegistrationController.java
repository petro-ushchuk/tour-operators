package com.example.touroperators.controller;

import com.example.touroperators.api.TourRegistrationApi;
import com.example.touroperators.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class TourRegistrationController implements TourRegistrationApi {

    private final UserService userService;

    @Override
    public ResponseEntity<Void> joinTour(Long tourId) {
        userService.addToTourList(tourId);
        return ResponseEntity.noContent().build();
    }

    @Override
    public ResponseEntity<Void> undoTour(Long tourId) {
       userService.deleteFromTourList(tourId);
        return ResponseEntity.noContent().build();
    }
}
