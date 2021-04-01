package com.example.touroperators.controller;

import com.example.touroperators.api.UserApi;
import com.example.touroperators.dto.UserDto;
import com.example.touroperators.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class UserController implements UserApi {

  private final UserService userService;

  @Override
  public UserDto getUser(Long id) {
    return userService.findById(id);
  }

  @Override
  public UserDto updateUser(UserDto userDto) {
    return userService.saveUser(userDto);
  }

  @Override
  public ResponseEntity<Void> deleteUser(Long id) {
    userService.deleteUser(id);
    return ResponseEntity.noContent().build();
  }

}
