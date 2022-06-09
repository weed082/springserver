package com.weedprj.springserver.ports.repository;

import com.weedprj.springserver.entity.user.User;
import java.util.List;
import java.util.Optional;

public interface UserRepoPort {
  boolean existsUserByEmail(String email);

  User register(User user);

  Optional<User> getUser(long idx);

  List<User> getUsers();

  Optional<User> login(String email, String password);

  void delete(long idx);

  void updateProfile(long idx, String name, String imgUrl);
}
