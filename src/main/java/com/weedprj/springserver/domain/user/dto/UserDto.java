package com.weedprj.springserver.domain.user.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

public class UserDto {
  @Data
  @AllArgsConstructor
  @NoArgsConstructor
  @Builder
  @Getter
  public static class Info {
    private String email;
    private String name;
    private String imgUrl;
    private String firebaseToken;
  }

  @Getter
  public static class RegisterReq {
    private String email;
    private String password;
    private String firebaseToken;
  }

  @Getter
  public static class LoginReq {
    private String email;
    private String password;
  }

  @Getter
  public static class ProfileReq {
    private long idx;
    private String name;
    private String imgUrl;
  }
}
