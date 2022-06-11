package com.weedprj.springserver.global.common.converter;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.weedprj.springserver.global.error.ApiException;
import java.util.List;
import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

@Converter
@Component
public class JsonArrayConverter<T> implements AttributeConverter<List<T>, String> {
  @Autowired private ObjectMapper mapper;
  private final Logger log = LoggerFactory.getLogger(JsonArrayConverter.class);

  @Override
  public String convertToDatabaseColumn(List<T> attribute) {
    try {
      return mapper.writeValueAsString(attribute);
    } catch (JsonProcessingException e) {
      throw new ApiException(HttpStatus.INTERNAL_SERVER_ERROR, "json mapping 실패");
    }
  }

  @Override
  public List<T> convertToEntityAttribute(String dbData) {
    try {
      List<T> list = mapper.readValue(dbData, new TypeReference<List<T>>() {});
      log.info("{}", list);
      return list;
    } catch (JsonProcessingException e) {
      throw new ApiException(HttpStatus.INTERNAL_SERVER_ERROR, "json mapping 실패");
    }
  }
}
