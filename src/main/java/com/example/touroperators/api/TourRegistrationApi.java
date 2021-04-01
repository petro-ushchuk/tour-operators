package com.example.touroperators.api;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

@Api(tags = "Tour registration management REST API")
@ApiResponses({
        @ApiResponse(code = 404, message = "Not found"),
        @ApiResponse(code = 500, message = "Internal Server Error")
})
@RequestMapping("/tour-registration")
public interface TourRegistrationApi {

    @ApiOperation("Join to tour")
    @ApiResponse(code = 204, message = "No content")
    @PostMapping("/{tourId}/join")
    @ResponseStatus(HttpStatus.OK)
    ResponseEntity<Void> joinTour(@PathVariable Long tourId);

    @ApiOperation("Undo joining to tour")
    @ApiResponse(code = 204, message = "No content")
    @PostMapping("/{tourId}/undo")
    @ResponseStatus(HttpStatus.OK)
    ResponseEntity<Void> undoTour(@PathVariable Long tourId);
}
