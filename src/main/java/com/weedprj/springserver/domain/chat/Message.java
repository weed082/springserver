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

  @Column(name = "user_idx", updatable = false)
  private long userIdx;

  @Column(name = "room_idx", updatable = false)
  private long roomIdx;

  @Column(name = "message")
  private String message;

  public long getIdx() {
    return idx;
  }

  public long getUserIdx() {
    return userIdx;
  }

  public void setUserIdx(long userIdx) {
    this.userIdx = userIdx;
  }

  public long getRoomIdx() {
    return roomIdx;
  }

  public void setRoomIdx(long roomIdx) {
    this.roomIdx = roomIdx;
  }

  public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message = message;
  }
}
