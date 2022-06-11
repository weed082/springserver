package com.weedprj.springserver.domain.file.domain;

import com.weedprj.springserver.global.common.domain.BaseEntity;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "file")
@Getter
@Setter
@Builder
public class File extends BaseEntity {
  @Id
  // TODO: find annotaion def
  @GeneratedValue(generator = "uuid")
  @GenericGenerator(name = "uuid", strategy = "uuid")
  private String idx;

  @Column(name = "name")
  private String name;

  @Column(name = "org_name")
  private String orgName;

  @Column(name = "size")
  private String size;
}
