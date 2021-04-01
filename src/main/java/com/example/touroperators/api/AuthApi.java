package com.example.touroperators.api;

import com.example.touroperators.dto.UserDto;
import com.example.touroperators.dto.validation.group.OnRegister;
import com.example.touroperators.dto.validation.group.OnSignIn;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

@Api(tags = "Auth management REST API")
@ApiResponses({
    @ApiResponse(code = 404, message = "Not found"),
    @ApiResponse(code = 500, message = "Internal Server Error")
})
@RequestMapping("/auth/")
public interface AuthApi {

  @ApiOperation("Sign in user to the system")
  @ApiResponse(code = 200, message = "OK", response = UserDto.class)
  @PostMapping("/signin")
  @ResponseStatus(HttpStatus.OK)
  UserDto signIn(@RequestBody @Validated(OnSignIn.class) UserDto userDto);

  @ApiOperation("Sign up and automatically login user to the system")
  @ApiResponse(code = 201, message = "Created", response = UserDto.class)
  @PostMapping("/signup")
  @ResponseStatus(HttpStatus.CREATED)
  UserDto signUp(@RequestBody @Validated(OnRegister.class) UserDto userDto);

  @ApiOperation("Logout current user from the system")
  @ApiResponse(code = 204, message = "No content")
  @PostMapping("/logout")
  ResponseEntity<Void> logOut();

}
