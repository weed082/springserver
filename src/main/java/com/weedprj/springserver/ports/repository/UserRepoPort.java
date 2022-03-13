package com.weedprj.springserver.ports.repository;

import java.util.List;

import com.weedprj.springserver.models.User;

public interface UserRepoPort {
  void saveUser();

  void deleteUser(int idx);

  User getUser(int idx);

  List<User> getUsers();

}
