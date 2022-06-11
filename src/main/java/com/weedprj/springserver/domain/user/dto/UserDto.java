package com.weedprj.springserver.domain.user.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

public class UserDto {
  @Data
  @Getter
  @Setter
  public static class Info {
    private long idx;
    private String email;
    private String name;
    private String imgUrl;
    private String firebaseToken;
  }

  // user register request
  @Getter
  public static class RegisterReq {
    @Email private String email;
    @NotEmpty private String password;

    @JsonProperty("firebase_token")
    @NotEmpty
    private String firebaseToken;
  }

  // user register response
  @Setter
  @Getter
  public static class RegisterRes {
    private long idx;
  }

  // user login request
  @Getter
  public static class LoginReq {
    @Email private String email;
    @NotEmpty private String password;
  }

  // user profile change request
  @Getter
  public static class ProfileReq {
    @NotNull private long idx;
    @NotEmpty private String name;

    @NotEmpty
    @JsonProperty("image_idx")
    private String imageIdx;
  }
}
