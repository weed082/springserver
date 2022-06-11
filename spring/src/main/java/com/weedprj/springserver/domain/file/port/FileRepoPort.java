package com.weedprj.springserver.domain.file.port;

import com.weedprj.springserver.domain.file.domain.File;
import java.util.Optional;

public interface FileRepoPort {
  File upload(File file);

  Optional<File> get(String idx);
}
