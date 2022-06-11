package com.weedprj.springserver.domain.file.repository;

import com.weedprj.springserver.domain.file.dao.FileDao;
import com.weedprj.springserver.domain.file.port.FileRepoPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class FileRepository implements FileRepoPort {
  @Autowired private final FileDao fileDao;
}
