package com.weedprj.springserver.util.exception;

import org.springframework.http.HttpStatus;

public class ApiException extends RuntimeException {

  private final HttpStatus status;

  public ApiException(HttpStatus status, String msg) {
    super(msg);
    this.status = status;
  }

  public ApiException(HttpStatus status, String msg, Throwable e) {
    super(msg, e);
    this.status = status;
  }

  public HttpStatus getStatus() {
    return status;
  }
}
