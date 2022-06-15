package com.weedprj.springserver.domain.chat.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

public class MessageDto {

  @Getter
  public static class ChatMsgDto {
    private long idx;

    @JsonProperty("user_idx")
    private long userIdx;

    private String message;
  }
}
