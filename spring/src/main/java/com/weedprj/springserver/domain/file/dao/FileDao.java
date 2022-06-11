package com.weedprj.springserver.domain.file.dao;

import com.weedprj.springserver.domain.file.domain.File;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FileDao extends JpaRepository<File, String> {}
