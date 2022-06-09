package com.weedprj.springserver.services;

import com.weedprj.springserver.entity.user.User;
import com.weedprj.springserver.ports.repository.UserRepoPort;
import com.weedprj.springserver.ports.service.UserServicePort;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService implements UserServicePort {
  @Autowired private UserRepoPort repo;

  @Override
  public User register(User user) {
    return repo.register(user);
  }

  @Override
  public Optional<User> getUser(long idx) {
    return repo.getUser(idx);
  }

  @Override
  public boolean existsUserByEmail(String email) {
    return repo.existsUserByEmail(email);
  }

  @Override
  public List<User> getUsers() {
    return repo.getUsers();
  }

  @Override
  public void deleteUser(long idx) {
    repo.delete(idx);
  }

  @Override
  public Optional<User> login(String email, String password) {
    return repo.login(email, password);
  }

  @Override
  public void uploadProfile(long idx, String name, String img, String firebase_token) {
    repo.updateProfile(idx, name, img);
  }
}
