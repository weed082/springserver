package com.weedprj.springserver.ports.service;

import com.weedprj.springserver.domain.user.User;
import java.util.List;
import java.util.Optional;

public interface UserServicePort {
  User register(User user);

  void deleteUser(long idx);

  Optional<User> getUser(long idx);

  Optional<User> login(String email, String password);

  boolean existsUserByEmail(String email);

  List<User> getUsers();
}
