package com.weedprj.springserver.repositories;

import com.weedprj.springserver.models.User;
import com.weedprj.springserver.ports.repository.UserRepoPort;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
interface UserJpa extends JpaRepository<User, Integer> {}

@Repository
public class UserRepository implements UserRepoPort {
  @Autowired private UserJpa userRepo;

  @Override
  public void register(User user) {
    userRepo.save(user);
  }

  @Override
  public User getUser(int idx) {
    return userRepo.getById(idx);
  }

  @Override
  public List<User> getUsers() {
    return userRepo.findAll();
  }

  @Override
  public void delete(int idx) {
    userRepo.deleteById(idx);
  }

  @Override
  public boolean checkEmail(String email) {
    return true;
  }

  @Override
  public void updateProfile(int idx, String img, String name) {
    // TODO Auto-generated method stub

  }
}
