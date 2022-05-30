package com.weedprj.springserver.services;

import com.weedprj.springserver.models.User;
import com.weedprj.springserver.ports.repository.UserRepoPort;
import com.weedprj.springserver.ports.service.UserServicePort;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService implements UserServicePort {
  @Autowired private UserRepoPort repo;

  @Override
  public void register(User user) {
    repo.register(user);
  }

  @Override
  public User getUser(int idx) {
    System.out.println("id " + idx);
    return repo.getUser(idx);
  }

  @Override
  public List<User> getUsers() {
    return repo.getUsers();
  }

  @Override
  public void deleteUser(int idx) {
    repo.delete(idx);
  }
}
