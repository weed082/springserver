package com.weedprj.springserver.domain.user.entity;

import com.weedprj.springserver.global.common.converter.JsonArrayConverter;
import com.weedprj.springserver.global.common.domain.BaseEntity;
import java.util.ArrayList;
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
import lombok.Setter;

@Entity
@Table(name = "user")
@SequenceGenerator(
    name = "user_seq",
    sequenceName = "user_seq",
    initialValue = 1,
    allocationSize = 1)
@Getter
@Setter
public class User extends BaseEntity {
  @Id
  @GeneratedValue(generator = "user_seq", strategy = GenerationType.SEQUENCE)
  private long idx;

  @Column(nullable = false, unique = true)
  private String email;

  @Column(nullable = false)
  private String password;

  @Column(length = 100)
  private String name;

  @Column(name = "image_idx")
  private String imageIdx;

  @Column(name = "firebase_token")
  private String firebaseToken;

  @Column(columnDefinition = "json")
  @Convert(converter = FriendsConverter.class)
  private List<Long> friends = new ArrayList<>();
}

class FriendsConverter extends JsonArrayConverter<Long> {}
