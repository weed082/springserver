package com.weedprj.springserver.domain.user;

import com.weedprj.springserver.domain.BaseEntity;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "user")
@SequenceGenerator(
    name = "user_seq",
    sequenceName = "user_seq",
    initialValue = 1,
    allocationSize = 1)
public class User extends BaseEntity {

  @Id
  @GeneratedValue(generator = "user_seq", strategy = GenerationType.SEQUENCE)
  private long idx;

  @Column(nullable = false)
  private String email;

  @Column(nullable = false)
  private String password;

  @Column private String name;

  @Column(name = "img_url")
  private String imgUrl;

  public long getIdx() {
    return idx;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }
}
