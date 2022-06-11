package com.weedprj.springserver.domain.file.controller;

import com.weedprj.springserver.domain.file.port.FileServicePort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("api/v1/file")
public class FileController {
  @Autowired private FileServicePort service;

  @PostMapping
  public void upload(@RequestParam("file") MultipartFile multipartFile) {
    service.upload(multipartFile);
  }
}
