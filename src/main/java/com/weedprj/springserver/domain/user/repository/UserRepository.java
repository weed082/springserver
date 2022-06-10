package com.weedprj.springserver.domain.user.repository;

import com.weedprj.springserver.domain.user.dao.UserDao;
import com.weedprj.springserver.domain.user.dto.UserDto;
import com.weedprj.springserver.domain.user.entity.User;
import com.weedprj.springserver.domain.user.port.UserRepoPort;
import java.util.List;
import java.util.Optional;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class UserRepository implements UserRepoPort {
  @Autowired private UserDao jpa;
  @Autowired private ModelMapper mapper;
  private final Logger log = LoggerFactory.getLogger(UserRepoPort.class);

  @Override
  public User register(UserDto.RegisterReq req) {
    return jpa.save(mapper.map(req, User.class));
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
  public Optional<User> login(UserDto.LoginReq req) {
    return jpa.findByEmailAndPassword(req.getEmail(), req.getPassword());
  }

  @Override
  public void delete(long idx) {
    jpa.deleteById(idx);
  }

  @Override
  public void updateProfile(UserDto.ProfileReq req) {
    // jpa.updateProfile(req.getIdx(), req.getName(), req.getImgUrl());
  }
}
