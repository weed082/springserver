package com.weedprj.springserver.domain.user.repository;

import com.weedprj.springserver.domain.user.dao.UserDao;
import com.weedprj.springserver.domain.user.entity.User;
import com.weedprj.springserver.domain.user.port.UserRepoPort;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class UserRepository implements UserRepoPort {
  @Autowired private UserDao userDao;

  /** --------------------- User --------------------- */
  @Override
  public User register(User user) {
    return userDao.save(user);
  }

  @Override
  public Optional<User> getUser(long idx) {
    return userDao.findById(idx);
  }

  @Override
  public Optional<User> findUserByEmail(String email) {
    return userDao.findByEmail(email);
  }

  // 로그인
  @Override
  public Optional<User> login(String email, String password) {
    return userDao.findByEmailAndPassword(email, password);
  }

  @Override
  public void deleteUser(long idx) {
    userDao.deleteById(idx);
  }

  @Override
  public void updateProfile(long idx, String name, String imageIdx) {
    userDao.updateProfile(idx, name, imageIdx);
  }

  /** --------------------- Friend --------------------- */
  @Override
  public List<User> getFriends(long userIdx, int limit, int offset) {
    return userDao.getFriends(userIdx, limit, offset);
  }

  @Override
  public void addFriend(long userIdx, long friendIdx) {
    userDao.addFriend(userIdx, friendIdx);
  }
}
