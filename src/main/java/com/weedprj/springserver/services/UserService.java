package com.weedprj.springserver.services;

import java.util.List;

import com.weedprj.springserver.models.User;
import com.weedprj.springserver.ports.repository.UserRepoPort;
import com.weedprj.springserver.ports.service.UserServicePort;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService implements UserServicePort {
  @Autowired
  private UserRepoPort repo;

  @Override
  public void saveUser() {
    repo.saveUser();
  }

  @Override
  public User getUser() {
    return repo.getUser();
  }

  @Override
  public List<User> getUsers() {
    return List.of(
        new User("name", "email@google.com", "00000000000"),
        new User("name2", "email2@google.com", "10000000000"));
  }

}
