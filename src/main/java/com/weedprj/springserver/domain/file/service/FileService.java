package com.weedprj.springserver.domain.file.service;

import com.weedprj.springserver.domain.file.port.FileServicePort;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class FileService implements FileServicePort {

  @Override
  public void upload(MultipartFile file) {
    // TODO Auto-generated method stub
  }
}
