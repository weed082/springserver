package com.weedprj.springserver.domain.file.port;

import org.springframework.web.multipart.MultipartFile;

public interface FileServicePort {
  void upload(MultipartFile file);
}
