package com.weedprj.springserver.global.error;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ApiExceptionHandler {

  private final Logger log = LoggerFactory.getLogger("ApiExceptionHandler");

  @ExceptionHandler(ApiException.class)
  public ResponseEntity<ApiErrorResponse> handleApiRequestException(ApiException e) {
    log.warn("ApiException : " + e.getMessage());
    return ResponseEntity.status(e.getStatus())
        .body(
            new ApiErrorResponse(
                e.getStatus(), e.getMessage(), ZonedDateTime.now(ZoneId.of("Asia/Seoul"))));
  }

  @ExceptionHandler(Exception.class)
  public ResponseEntity<ApiErrorResponse> handleException(Exception e) {
    log.warn("Exception : Internal Server Error");
    HttpStatus status = HttpStatus.INTERNAL_SERVER_ERROR;
    return ResponseEntity.status(status)
        .body(
            new ApiErrorResponse(
                status, e.getMessage(), ZonedDateTime.now(ZoneId.of("Asia/Seoul"))));
  }
}
