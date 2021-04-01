package com.example.touroperators.model.error;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
public class Error {
  private String message;
  private ErrorCode errorCode;
  private ErrorType errorType;
  private LocalDateTime dateTime;
}
