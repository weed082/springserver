package com.weedprj.springserver.domain.user.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
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
    private long idx;
    private String email;
    private String name;
    private String imgUrl;
    private String firebaseToken;
  }

  @Getter
  public static class RegisterReq {
    @Email private String email;
    @NotEmpty private String password;
    @NotEmpty private String firebaseToken;
  }

  @Getter
  public static class RegisterRes {
    private long idx;
  }

  @Getter
  public static class LoginReq {
    @Email private String email;
    @NotEmpty private String password;
  }

  @Getter
  public static class ProfileReq {
    private long idx;
    private String name;
    private String imgUrl;
  }
}
