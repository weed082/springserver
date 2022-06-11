package com.weedprj.springserver.domain.file.port;

import com.weedprj.springserver.domain.file.dto.FileDto;
import java.io.IOException;
import org.springframework.web.multipart.MultipartFile;

public interface FileServicePort {
  FileDto.Info upload(MultipartFile file) throws IOException;

  FileDto.Resource get(String idx);
}
