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
  public void saveUser(User user) {
    repo.saveUser(user);
  }

  @Override
  public User getUser(int idx) {
    return repo.getUser(idx);
  }

  @Override
  public List<User> getUsers() {
    return repo.getUsers();
  }

  @Override
  public void deleteUser(int idx) {
    repo.deleteUser(idx);
  }

}
