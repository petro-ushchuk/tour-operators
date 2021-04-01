package com.example.touroperators.controller;

import com.example.touroperators.model.error.ErrorCode;
import com.example.touroperators.model.error.ErrorType;
import com.example.touroperators.model.error.Error;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.HandlerMethod;

import javax.persistence.EntityNotFoundException;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@RestControllerAdvice
public class ErrorHandlingController {

  @ExceptionHandler(MethodArgumentNotValidException.class)
  @ResponseStatus(HttpStatus.BAD_REQUEST)
  public List<Error> handleMethodArgumentNotValidException(MethodArgumentNotValidException ex) {
    log.error("handleMethodArgumentNotValidException: exception {}", ex.getMessage(), ex);
    return ex.getBindingResult().getAllErrors().stream()
        .map(err -> new Error(err.getDefaultMessage(), ErrorCode.VALIDATION_ERROR_CODE,
            ErrorType.PROCESSING_ERROR_TYPE, LocalDateTime.now()))
        .collect(Collectors.toList());
  }

  @ExceptionHandler(EntityNotFoundException.class)
  @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
  public Error handleAbstractException(EntityNotFoundException ex, HandlerMethod hm) {
    log.error("handleAbstractException: exception {}, method {}",
        ex.getMessage(), hm.getMethod().getName(), ex);
    return new Error(ex.getMessage(), ErrorCode.APPLICATION_ERROR_CODE,
            ErrorType.PROCESSING_ERROR_TYPE, LocalDateTime.now());
  }

  @ExceptionHandler(Exception.class)
  @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
  public Error handleAllException(Exception ex, HandlerMethod hm) {
    log.error("handleAllException: exception {}, method {}",
        ex.getMessage(), hm.getMethod().getName(), ex);
    return new Error(ex.getMessage(), ErrorCode.APPLICATION_ERROR_CODE, ErrorType.FATAL_ERROR_TYPE,
        LocalDateTime.now());
  }

}
