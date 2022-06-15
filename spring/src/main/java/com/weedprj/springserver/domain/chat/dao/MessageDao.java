package com.weedprj.springserver.domain.chat.dao;

import com.weedprj.springserver.domain.chat.domain.Message;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MessageDao extends JpaRepository<Message, String> {}
