package com.weedprj.springserver.domain.user.port;

import com.weedprj.springserver.domain.user.dto.UserDto;
import java.util.List;

public interface UserServicePort {
  /** --------------------- User --------------------- */
  UserDto.RegisterRes register(UserDto.RegisterReq req);

  UserDto.Info getUser(long idx);

  UserDto.Info findUserByEmail(String email);

  UserDto.Info login(UserDto.LoginReq req);

  void deleteUser(long idx); // 사용자 삭제

  void updateProfile(UserDto.ProfileReq req); // 사용자 프로필 업데이트

  /** --------------------- Friend --------------------- */
  void addFriend(long userIdx, long friendIdx);

  List<UserDto.Info> getFriends(long userIdx, int page, int limit);
}
