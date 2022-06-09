package com.weedprj.springserver.entity;

import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public abstract class BaseEntity {
  @Column(name = "upload_date")
  @CreatedDate
  private LocalDateTime uploadDate;

  @Column(name = "update_date")
  @LastModifiedDate
  private LocalDateTime updateDate;

  @Column(name = "delete_date")
  private LocalDateTime deleteDate;

  public LocalDateTime getUploadDate() {
    return uploadDate;
  }

  public LocalDateTime getUpdateDate() {
    return updateDate;
  }

  public LocalDateTime getDeleteDate() {
    return deleteDate;
  }

  public void setDeleteDate(LocalDateTime deleteDate) {
    this.deleteDate = deleteDate;
  }
}
