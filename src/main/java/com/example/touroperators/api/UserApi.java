package com.example.touroperators.api;

import com.example.touroperators.dto.UserDto;
import com.example.touroperators.dto.validation.group.OnUpdate;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

@Api(tags = "User management REST API")
@ApiResponses({
    @ApiResponse(code = 404, message = "Not found"),
    @ApiResponse(code = 500, message = "Internal Server Error")
})
@RequestMapping("/user")
public interface UserApi {

  @ApiOperation("Get user")
  @ApiResponse(code = 200, message = "OK", response = UserDto.class)
  @GetMapping("{id}")
  @ResponseStatus(HttpStatus.OK)
  UserDto getUser(@PathVariable Long id);

  @ApiOperation("Update user")
  @ApiResponse(code = 200, message = "OK", response = UserDto.class)
  @PutMapping("/put/")
  @ResponseStatus(HttpStatus.OK)
  UserDto updateUser(@RequestBody @Validated(OnUpdate.class) UserDto userDto);

  @ApiOperation("Delete user")
  @ApiResponse(code = 204, message = "No content")
  @DeleteMapping("/delete/{id}")
  ResponseEntity<Void> deleteUser(@PathVariable Long id);

}
