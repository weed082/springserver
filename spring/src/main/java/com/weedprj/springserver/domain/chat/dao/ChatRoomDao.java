package com.weedprj.springserver.domain.chat.dao;

import com.weedprj.springserver.domain.chat.domain.ChatRoom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ChatRoomDao extends JpaRepository<ChatRoom, String> {}
