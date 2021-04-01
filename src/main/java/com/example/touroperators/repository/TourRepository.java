package com.example.touroperators.repository;

import com.example.touroperators.model.Tour;
import com.example.touroperators.model.enums.TourType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TourRepository extends JpaRepository<Tour, Long> {
    List<Tour> findAllByTourType(TourType type);
}
