package com.weedprj.springserver.global.error;

import java.time.ZonedDateTime;
import org.springframework.http.HttpStatus;

public class ApiErrorResponse {
  private final HttpStatus httpStatus;
  private final String msg;
  private final ZonedDateTime timestamp;

  public ApiErrorResponse(HttpStatus httpStatus, String msg, ZonedDateTime timestamp) {
    this.httpStatus = httpStatus;
    this.msg = msg;
    this.timestamp = timestamp;
  }

  public String getMsg() {
    return msg;
  }

  public HttpStatus getHttpStatus() {
    return httpStatus;
  }

  public ZonedDateTime getTimestamp() {
    return timestamp;
  }
}
