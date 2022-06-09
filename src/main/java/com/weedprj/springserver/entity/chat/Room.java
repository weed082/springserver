package com.weedprj.springserver.entity.chat;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.weedprj.springserver.entity.BaseEntity;
import java.util.Arrays;
import java.util.List;
import javax.persistence.AttributeConverter;
import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Converter;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

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
  @Convert(converter = JsonArrayConverter.class)
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

@Converter
@Component
class JsonArrayConverter implements AttributeConverter<List<Long>, String> {
  @Autowired public static ObjectMapper mapper;

  @Override
  public String convertToDatabaseColumn(List<Long> attribute) {
    try {
      return mapper.writeValueAsString(attribute);
    } catch (JsonProcessingException e) {
      e.printStackTrace();
      return null;
    }
  }

  @Override
  public List<Long> convertToEntityAttribute(String dbData) {
    try {
      return Arrays.asList(mapper.readValue(dbData, Long[].class));
    } catch (JsonProcessingException e) {
      e.printStackTrace();
      return null;
    }
  }
}
