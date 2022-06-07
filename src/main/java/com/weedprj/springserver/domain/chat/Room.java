package com.weedprj.springserver.domain.chat;

import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "room")
@SequenceGenerator(
    name = "room_seq",
    sequenceName = "room_seq",
    initialValue = 1,
    allocationSize = 1)
public class Room {
  @Id
  @GeneratedValue(generator = "room_seq", strategy = GenerationType.SEQUENCE)
  private long idx;

  private String name;
  private List<Integer> participants;

  public long getIdx() {
    return idx;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public List<Integer> getParticipants() {
    return participants;
  }

  public void setParticipants(List<Integer> participants) {
    this.participants = participants;
  }
}
