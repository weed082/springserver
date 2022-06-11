package com.weedprj.springserver.domain.user.service;

import com.weedprj.springserver.domain.user.dto.UserDto;
import com.weedprj.springserver.domain.user.entity.User;
import com.weedprj.springserver.domain.user.port.UserRepoPort;
import com.weedprj.springserver.domain.user.port.UserServicePort;
import com.weedprj.springserver.global.error.ApiException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
public class UserService implements UserServicePort {
  @Autowired private UserRepoPort repo;
  @Autowired private ModelMapper mapper;

  @Override
  public UserDto.RegisterRes register(UserDto.RegisterReq req) {
    return mapper.map(repo.register(req), UserDto.RegisterRes.class);
  }

  @Override
  public UserDto.Info getUser(long idx) {
    Optional<User> userOpt = repo.getUser(idx);
    if (userOpt.isEmpty()) throw new ApiException(HttpStatus.NOT_FOUND, "no match user idx");
    return mapper.map(repo.getUser(idx), UserDto.Info.class);
  }

  @Override
  public boolean existsUserByEmail(String email) {
    return repo.existsUserByEmail(email);
  }

  @Override
  public List<UserDto.Info> getUsers() {
    return repo.getUsers().stream()
        .map(user -> mapper.map(user, UserDto.Info.class))
        .collect(Collectors.toList());
  }

  @Override
  public void deleteUser(long idx) {
    repo.deleteUser(idx);
  }

  @Override
  public UserDto.Info login(UserDto.LoginReq req) {
    Optional<User> userOpt = repo.login(req);
    if (userOpt.isEmpty()) throw new ApiException(HttpStatus.NOT_FOUND, "no match user");
    return mapper.map(userOpt.get(), UserDto.Info.class);
  }

  @Override
  public void updateProfile(UserDto.ProfileReq req) {
    repo.updateProfile(req);
  }
}
