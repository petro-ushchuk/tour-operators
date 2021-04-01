package com.example.touroperators.api;

import com.example.touroperators.dto.TourDto;
import com.example.touroperators.dto.validation.group.OnCreate;
import com.example.touroperators.dto.validation.group.OnUpdate;
import com.example.touroperators.model.enums.TourType;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.List;

@Api(tags = "Tour management REST API")
@ApiResponses({
        @ApiResponse(code = 404, message = "Not found"),
        @ApiResponse(code = 500, message = "Internal Server Error")
})
@RequestMapping("/tour")
public interface TourApi {

    @ApiOperation("Get list of all tours")
    @ApiResponse(code = 200, message = "OK", response = List.class)
    @GetMapping("/get/all")
    @ResponseStatus(HttpStatus.OK)
    List<TourDto> getAllTours();

    @ApiOperation("Create tour")
    @ApiResponse(code = 200, message = "OK", response = TourDto.class)
    @PostMapping("/post")
    @ResponseStatus(HttpStatus.OK)
    TourDto createTour(@RequestBody @Validated(OnCreate.class) TourDto tourDto);

    @ApiOperation("Get tour")
    @ApiResponse(code = 200, message = "OK", response = TourDto.class)
    @GetMapping("/get/{id}")
    @ResponseStatus(HttpStatus.OK)
    TourDto getTour(@PathVariable Long id);

    @ApiOperation("Get tours by type")
    @ApiResponse(code = 200, message = "OK", response = List.class)
    @GetMapping("/get")
    @ResponseStatus(HttpStatus.OK)
    List<TourDto> getToursByType(@RequestParam TourType type);

    @ApiOperation("Update tour")
    @ApiResponse(code = 200, message = "OK", response = TourDto.class)
    @PutMapping("/put")
    @ResponseStatus(HttpStatus.OK)
    TourDto updateTour(@RequestBody @Validated(OnUpdate.class) TourDto tourDto);

    @ApiOperation("Delete tour")
    @ApiResponse(code = 204, message = "No content")
    @DeleteMapping("/delete/{id}")
    ResponseEntity<Void> deleteTour(@PathVariable Long id);
}
