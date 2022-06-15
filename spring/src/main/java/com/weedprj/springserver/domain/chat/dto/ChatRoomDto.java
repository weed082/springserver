package com.weedprj.springserver.domain.chat.dto;

import java.util.List;
import lombok.Getter;

public class ChatRoomDto {
  @Getter
  public static class ChatRoomInfo {
    private long idx;
    private String name;
    private List<Participant> participants;
  }

  @Getter
  public static class Participant {
    private long idx;
    private String imageIdx;
    private String name;
  }
}
