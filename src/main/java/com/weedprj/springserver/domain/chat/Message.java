package com.weedprj.springserver.domain.chat;

import com.weedprj.springserver.domain.BaseEntity;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "message")
@SequenceGenerator(
    name = "message_seq",
    sequenceName = "message_seq",
    initialValue = 1,
    allocationSize = 1)
public class Message extends BaseEntity {
  @Id
  @GeneratedValue(generator = "message_seq", strategy = GenerationType.SEQUENCE)
  private long idx;

  @Column(name = "user_idx")
  private long userIdx;

  @Column(name = "room_idx")
  private long roomIdx;

  @Column(name = "message")
  private String message;
}
