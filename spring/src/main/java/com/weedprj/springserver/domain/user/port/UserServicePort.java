package com.weedprj.springserver.domain.user.port;

import com.weedprj.springserver.domain.user.dto.UserDto;
import com.weedprj.springserver.domain.user.dto.UserDto.ProfileReq;
import com.weedprj.springserver.domain.user.dto.UserDto.RegisterReq;
import com.weedprj.springserver.domain.user.dto.UserDto.RegisterRes;
import com.weedprj.springserver.domain.user.dto.UserDto.UserInfo;
import java.util.List;

public interface UserServicePort {
  /** --------------------- User --------------------- */
  RegisterRes register(RegisterReq req);

  UserInfo getUser(long idx);

  UserInfo findUserByEmail(String email);

  UserInfo login(UserDto.LoginReq req);

  void deleteUser(long idx); // 사용자 삭제

  void updateProfile(ProfileReq req); // 사용자 프로필 업데이트

  /** --------------------- Friend --------------------- */
  void addFriend(long userIdx, long friendIdx);

  List<UserInfo> getFriends(long userIdx, int page, int limit);
}
