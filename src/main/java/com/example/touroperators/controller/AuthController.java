package com.example.touroperators.controller;


import com.example.touroperators.api.AuthApi;
import com.example.touroperators.dto.UserDto;
import com.example.touroperators.model.enums.Role;
import com.example.touroperators.service.AuthService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
public class AuthController implements AuthApi {

  private final AuthService authService;

  @Override
  public UserDto signIn(UserDto inUserDto) {
    return authService.signIn(inUserDto);
  }

  @Override
  public UserDto signUp(UserDto inUserDto) {
    return authService.signUp(inUserDto, Role.TRAVELER);
  }

  @Override
  public ResponseEntity<Void> logOut() {
    authService.signOut();
    return ResponseEntity.noContent().build();
  }

}
