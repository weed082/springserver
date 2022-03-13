package com.weedprj.springserver.ports.service;

import java.util.List;

import com.weedprj.springserver.models.User;

public interface UserServicePort {
  void saveUser(User user);

  void deleteUser(int idx);

  User getUser(int idx);

  List<User> getUsers();
}
