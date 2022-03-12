package com.weedprj.springserver.repositories;

import com.weedprj.springserver.models.User;
import com.weedprj.springserver.ports.repository.UserRepoPort;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
interface UserJpa extends JpaRepository<User, Integer> {
}

@Repository
public class UserRepository implements UserRepoPort {
  @Autowired
  private UserJpa userRepo;

  @Override
  public void saveUser() {
    userRepo.save(new User("name", "email", "phone"));
  }

  @Override
  public User getUser() {
    return userRepo.getById(1);
  }

}
