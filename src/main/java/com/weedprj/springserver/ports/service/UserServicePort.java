package com.weedprj.springserver.ports.service;

import java.util.List;

import com.weedprj.springserver.models.User;

public interface UserServicePort {
  void saveUser();

  User getUser();

  List<User> getUsers();
}
