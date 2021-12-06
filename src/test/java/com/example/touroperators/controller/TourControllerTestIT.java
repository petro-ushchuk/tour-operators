package com.example.touroperators.controller;

import com.example.touroperators.dto.TourDto;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.jeasy.random.EasyRandom;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@AutoConfigureMockMvc
@SpringBootTest
class TourControllerTestIT {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private EasyRandom generator;

    @Autowired
    private ObjectMapper objectMapper;

    private TourDto newTour;

    @BeforeEach
    void setUp(){
        newTour = generator.nextObject(TourDto.class);
        newTour.setId(null);
        newTour.setParticipants(null);
        newTour.getCompany().setTours(null);
        newTour.getCompany().getOwner().setTours(null);
    }

    @Test
    void createTour() throws Exception {
        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.post("/tour/create")
                        .content(objectMapper.writeValueAsString(newTour))
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andReturn();
        TourDto createdTour = objectMapper.readValue(result.getResponse().getContentAsString(), TourDto.class);
        assertNotNull(createdTour);
        assertEquals(newTour.getName(), createdTour.getName());
        assertEquals(newTour.getTourType(), createdTour.getTourType());
    }
}