package com.weedprj.springserver.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "user")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class User {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private int idx;

  private String password;
  private String name;
  private String email;
  private String phone;
  private String imgUrl;

  public User() {}

  public User(String email, String password) {
    this.email = email;
    this.password = password;
  }

  public int getIdx() {
    return idx;
  }

  public String getPassword() {
    return password;
  }

  public String getName() {
    return name;
  }

  public String getEmail() {
    return email;
  }

  public String getPhone() {
    return phone;
  }

  public String getImgUrl() {
    return imgUrl;
  }
}
