package com.example.touroperators.controller;

import com.example.touroperators.api.TourApi;
import com.example.touroperators.dto.TourDto;
import com.example.touroperators.model.enums.TourType;
import com.example.touroperators.service.TourService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class TourController implements TourApi {

    private final TourService tourService;

    @Override
    public List<TourDto> getAllTours() {
        return tourService.findAll();
    }

    @Override
    public TourDto createTour(TourDto tourDto) {
        return tourService.saveTour(tourDto);
    }

    @Override
    public TourDto getTour(Long id) {
        return tourService.getTour(id);
    }

    @Override
    public List<TourDto> getToursByType(TourType type) {
        return tourService.findByType(type);
    }

    @Override
    public TourDto updateTour(TourDto tourDto) {
        return tourService.saveTour(tourDto);
    }

    @Override
    public ResponseEntity<Void> deleteTour(Long id) {
        tourService.deleteTour(id);
        return ResponseEntity.noContent().build();
    }
}
