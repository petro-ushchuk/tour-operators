package com.example.touroperators.api;

import com.example.touroperators.dto.CompanyDto;
import com.example.touroperators.dto.validation.group.OnCreate;
import com.example.touroperators.dto.validation.group.OnUpdate;
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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.List;

@Api(tags = "Company management REST API")
@ApiResponses({
        @ApiResponse(code = 404, message = "Not found"),
        @ApiResponse(code = 500, message = "Internal Server Error")
})
@RequestMapping("/company")
public interface CompanyApi {

    @ApiOperation("Get list of all companies")
    @ApiResponse(code = 200, message = "OK", response = List.class)
    @GetMapping("/get/all")
    @ResponseStatus(HttpStatus.OK)
    List<CompanyDto> getAllCompanies();

    @ApiOperation("Create company")
    @ApiResponse(code = 200, message = "OK", response = CompanyDto.class)
    @PostMapping("/post")
    @ResponseStatus(HttpStatus.OK)
    CompanyDto createCompany(@RequestBody @Validated(OnCreate.class) CompanyDto companyDto);

    @ApiOperation("Get company")
    @ApiResponse(code = 200, message = "OK", response = CompanyDto.class)
    @GetMapping("/get/{id}")
    @ResponseStatus(HttpStatus.OK)
    CompanyDto getCompany(@PathVariable Long id);

    @ApiOperation("Update company")
    @ApiResponse(code = 200, message = "OK", response = CompanyDto.class)
    @PutMapping("/put")
    @ResponseStatus(HttpStatus.OK)
    CompanyDto updateCompany(@RequestBody @Validated(OnUpdate.class) CompanyDto companyDto);

    @ApiOperation("Delete company")
    @ApiResponse(code = 204, message = "No content")
    @DeleteMapping("/delete/{id}")
    ResponseEntity<Void> deleteCompany(@PathVariable Long id);
}
