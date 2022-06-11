package com.weedprj.springserver.domain.file.repository;

import com.weedprj.springserver.domain.file.dao.FileDao;
import com.weedprj.springserver.domain.file.domain.File;
import com.weedprj.springserver.domain.file.port.FileRepoPort;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class FileRepository implements FileRepoPort {
  @Autowired private FileDao fileDao;

  public File upload(File file) {
    return fileDao.save(file);
  }

  @Override
  public Optional<File> get(String idx) {
    return fileDao.findById(idx);
  }
}
