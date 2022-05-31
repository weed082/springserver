package com.weedprj.springserver.util.exception;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ApiExceptionHandler {

  private final Logger log = LoggerFactory.getLogger("ApiExceptionHandler");

  @ExceptionHandler(ApiException.class)
  public ResponseEntity<ApiErrorResponse> handleApiRequestException(ApiException e) {
    log.info("working");
    return ResponseEntity.status(e.getStatus())
        .body(
            new ApiErrorResponse(
                e.getStatus(), e.getMessage(), ZonedDateTime.now(ZoneId.of("Asia/Seoul"))));
  }
}

class Test {
  private final String msg;

  Test(String msg) {
    this.msg = msg;
  }
}
