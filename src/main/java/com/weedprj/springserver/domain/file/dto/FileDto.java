package com.weedprj.springserver.domain.file.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

public class FileDto {
  @Getter
  @Setter
  @Builder
  public static class Info {
    private String name;
    private String type;
    private String url;
  }

  @Getter
  @Setter
  public static class Resource {
    private String name;
    private String type;
    private byte[] data;
  }
}
