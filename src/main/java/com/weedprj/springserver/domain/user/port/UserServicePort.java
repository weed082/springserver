package com.weedprj.springserver.domain.user.port;

import com.weedprj.springserver.domain.user.domain.User;
import com.weedprj.springserver.domain.user.dto.UserDto;
import java.util.List;

public interface UserServicePort {
  void register(UserDto.RegisterReq req);

  void deleteUser(long idx);

  UserDto.Info getUser(long idx);

  UserDto.Info login(UserDto.LoginReq req);

  boolean existsUserByEmail(String email);

  void uploadProfile(UserDto.ProfileReq req);

  List<User> getUsers();
}
