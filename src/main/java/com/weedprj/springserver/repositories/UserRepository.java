package com.weedprj.springserver.repositories;

import com.weedprj.springserver.domain.user.User;
import com.weedprj.springserver.ports.repository.UserRepoPort;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
interface UserJpa extends JpaRepository<User, Long> {
  boolean existsUserByEmail(String email);

  Optional<User> findByEmailAndPassword(String email, String password);

  @Query("UPDATE user SET name=:name, img_url=:imgUrl WHERE idx=:idx")
  void updateProfile(
      @Param(value = "idx") long idx,
      @Param(value = "name") String name,
      @Param(value = "imgUrl") String imgUrl);
}

@Repository
public class UserRepository implements UserRepoPort {
  @Autowired private UserJpa jpa;

  @Override
  public User register(User user) {
    return jpa.save(user);
  }

  @Override
  public Optional<User> getUser(long idx) {
    return jpa.findById(idx);
  }

  @Override
  public boolean existsUserByEmail(String email) {
    return jpa.existsUserByEmail(email);
  }

  @Override
  public List<User> getUsers() {
    return jpa.findAll();
  }

  // 로그인
  @Override
  public Optional<User> login(String email, String password) {
    return jpa.findByEmailAndPassword(email, password);
  }

  @Override
  public void delete(long idx) {
    jpa.deleteById(idx);
  }

  @Override
  public void updateProfile(long idx, String name, String imgUrl) {
    jpa.updateProfile(idx, name, imgUrl);
  }
}
