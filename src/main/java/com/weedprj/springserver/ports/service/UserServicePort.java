package com.weedprj.springserver.ports.service;

import com.weedprj.springserver.models.User;
import java.util.List;

public interface UserServicePort {
  void register(User user);

  void deleteUser(int idx);

  User getUser(int idx);

  List<User> getUsers();
}
