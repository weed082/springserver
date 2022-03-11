package com.weedprj.springserver.ports.repository;

import com.weedprj.springserver.models.User;

public interface UserRepoPort {
  void saveUser();

  User getUser();

}
