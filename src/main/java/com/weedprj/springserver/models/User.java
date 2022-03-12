package com.weedprj.springserver.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "user")
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class User {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private int idx;
  private String name;
  private String email;
  private String phone;

  public User() {
  }

  public User(String name, String email, String phone) {
    this.name = name;
    this.email = email;
    this.phone = phone;
  }

  public int getIdx() {
    return idx;
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
}
