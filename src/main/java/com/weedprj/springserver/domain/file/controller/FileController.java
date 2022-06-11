package com.weedprj.springserver.domain.file.controller;

import com.weedprj.springserver.domain.file.dto.FileDto;
import com.weedprj.springserver.domain.file.port.FileServicePort;
import java.io.IOException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("api/v1")
public class FileController {
  @Autowired private FileServicePort service;

  @PostMapping("/file/db")
  @ResponseBody
  public FileDto.Info uploadToDb(@RequestParam("file") MultipartFile multipartFile)
      throws IOException {
    return service.upload(multipartFile);
  }

  @GetMapping("file/{idx}")
  @ResponseBody
  public ResponseEntity<byte[]> get(@PathVariable String idx) {
    FileDto.Resource resource = service.get(idx);
    return ResponseEntity.ok()
        .contentType(MediaType.parseMediaType(resource.getType()))
        .body(resource.getData());
  }

  @GetMapping("file/download/{idx}")
  public ResponseEntity<Resource> download(@PathVariable String idx) {
    FileDto.Resource resource = service.get(idx);
    return ResponseEntity.ok()
        .contentType(MediaType.parseMediaType(resource.getType()))
        .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=" + resource.getName())
        .body(new ByteArrayResource(resource.getData()));
  }
}
