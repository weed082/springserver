package com.weedprj.springserver.domain.file.service;

import com.weedprj.springserver.domain.file.domain.File;
import com.weedprj.springserver.domain.file.dto.FileDto;
import com.weedprj.springserver.domain.file.port.FileServicePort;
import com.weedprj.springserver.domain.file.repository.FileRepository;
import com.weedprj.springserver.global.error.ApiException;
import java.io.IOException;
import java.util.Optional;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@Service
public class FileService implements FileServicePort {
  @Autowired private FileRepository repo;
  @Autowired private ModelMapper mapper;

  @Override
  public FileDto.Info upload(MultipartFile multipartFile) throws IOException {
    File file =
        repo.upload(
            File.builder()
                .name(multipartFile.getOriginalFilename())
                .type(multipartFile.getContentType())
                .size(multipartFile.getSize())
                .data(multipartFile.getBytes())
                .build());
    String fileUrl =
        ServletUriComponentsBuilder.fromCurrentContextPath()
            .path("/api/v1/file/")
            .path(file.getIdx())
            .toUriString();
    return FileDto.Info.builder().name(file.getName()).type(file.getType()).url(fileUrl).build();
  }

  @Override
  public FileDto.Resource get(String idx) {
    Optional<File> fileOpt = repo.get(idx);
    if (fileOpt.isEmpty()) throw new ApiException(HttpStatus.NOT_FOUND, "file not found");
    return mapper.map(fileOpt.get(), FileDto.Resource.class);
  }
}
