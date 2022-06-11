package com.weedprj.springserver.domain.user.port;

import com.weedprj.springserver.domain.user.dto.UserDto;
import com.weedprj.springserver.domain.user.entity.User;
import java.util.List;
import java.util.Optional;

public interface UserRepoPort {
  boolean existsUserByEmail(String email);

  User register(UserDto.RegisterReq req);

  Optional<User> getUser(long idx);

  List<User> getUsers();

  Optional<User> login(UserDto.LoginReq req);

  void deleteUser(long idx);

  void updateProfile(UserDto.ProfileReq req);
}
