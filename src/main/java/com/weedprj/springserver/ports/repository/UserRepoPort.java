package com.weedprj.springserver.ports.repository;

import com.weedprj.springserver.models.User;
import java.util.List;

public interface UserRepoPort {
  void register(User user);

  void delete(int idx);

  User getUser(int idx);

  List<User> getUsers();

  boolean checkEmail(String email); // check duplicate email

  void updateProfile(int idx, String img, String name);
}
