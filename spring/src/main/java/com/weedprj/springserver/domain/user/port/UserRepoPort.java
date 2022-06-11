package com.weedprj.springserver.domain.user.port;

import com.weedprj.springserver.domain.user.entity.User;
import java.util.List;
import java.util.Optional;

public interface UserRepoPort {

  /** --------------------- User --------------------- */
  User register(User user);

  Optional<User> getUser(long idx);

  Optional<User> findUserByEmail(String email);

  Optional<User> login(String email, String password);

  void deleteUser(long idx);

  void updateProfile(long idx, String name, String iamgeIdx);

  /** --------------------- Friend --------------------- */
  void addFriend(long userIdx, long friendIdx);

  List<User> getFriends(long userIdx, int limit, int offset);
}
