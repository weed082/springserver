package com.weedprj.springserver.repositories;

import com.weedprj.springserver.domain.user.User;
import com.weedprj.springserver.ports.repository.UserRepoPort;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
interface UserJpa extends JpaRepository<User, Long> {
  boolean existsUserByEmail(@Param("email") String email);

  Optional<User> findByEmailAndPassword(String email, String password);
}

@Repository
public class UserRepository implements UserRepoPort {
  @Autowired private UserJpa userRepo;

  @Override
  public void register(User user) {
    userRepo.save(user);
  }

  @Override
  public Optional<User> getUser(long idx) {
    return userRepo.findById(idx);
  }

  @Override
  public boolean existsUserByEmail(String email) {
    return userRepo.existsUserByEmail(email);
  }

  @Override
  public List<User> getUsers() {
    return userRepo.findAll();
  }

  // 로그인
  @Override
  public Optional<User> login(String email, String password) {
    return userRepo.findByEmailAndPassword(email, password);
  }

  @Override
  public void delete(long idx) {
    userRepo.deleteById(idx);
  }

  @Override
  public void updateProfile(int idx, String img, String name) {
    // TODO Auto-generated method stub
  }
}
