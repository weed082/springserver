package com.weedprj.springserver.ports.repository;

import com.weedprj.springserver.domain.user.User;
import java.util.List;
import java.util.Optional;

public interface UserRepoPort {
  boolean existsUserByEmail(String email);

  void register(User user);

  Optional<User> getUser(long idx);

  List<User> getUsers();

  Optional<User> login(String email, String password);

  void delete(long idx);

  void updateProfile(int idx, String img, String name);
}
