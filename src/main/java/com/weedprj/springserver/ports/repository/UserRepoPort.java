package com.weedprj.springserver.ports.repository;

import java.util.List;

import com.weedprj.springserver.models.User;

public interface UserRepoPort {
  void saveUser();

  User getUser();

  List<User> getUsers();

}
