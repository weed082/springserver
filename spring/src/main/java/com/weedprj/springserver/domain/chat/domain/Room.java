package com.weedprj.springserver.domain.chat.domain;

import com.weedprj.springserver.global.common.converter.JsonArrayConverter;
import com.weedprj.springserver.global.common.domain.BaseEntity;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import lombok.Getter;

@Getter
@Entity
@Table(name = "room")
@SequenceGenerator(
    name = "room_seq",
    sequenceName = "room_seq",
    initialValue = 1,
    allocationSize = 1)
public class Room extends BaseEntity {
  @Id
  @GeneratedValue(generator = "room_seq", strategy = GenerationType.SEQUENCE)
  private long idx;

  @Column(name = "name")
  private String name;

  @Column(name = "participants", columnDefinition = "json")
  @Convert(converter = ParticipantsConverter.class)
  private List<Long> participants;
}

class ParticipantsConverter extends JsonArrayConverter<Long> {}
