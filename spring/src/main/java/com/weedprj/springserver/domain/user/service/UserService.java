package com.weedprj.springserver.domain.user.service;

import com.weedprj.springserver.domain.user.dto.UserDto;
import com.weedprj.springserver.domain.user.dto.UserDto.LoginReq;
import com.weedprj.springserver.domain.user.dto.UserDto.RegisterReq;
import com.weedprj.springserver.domain.user.dto.UserDto.RegisterRes;
import com.weedprj.springserver.domain.user.dto.UserDto.UserInfo;
import com.weedprj.springserver.domain.user.entity.User;
import com.weedprj.springserver.domain.user.port.UserRepoPort;
import com.weedprj.springserver.domain.user.port.UserServicePort;
import com.weedprj.springserver.global.error.ApiException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
public class UserService implements UserServicePort {
  @Autowired private UserRepoPort repo;
  @Autowired private ModelMapper mapper;

  private Logger log = LoggerFactory.getLogger(UserService.class);

  /** --------------------- User --------------------- */
  @Override
  public RegisterRes register(RegisterReq req) {
    User user = mapper.map(req, User.class);
    return mapper.map(repo.register(user), RegisterRes.class);
  }

  @Override
  public UserInfo getUser(long idx) {
    Optional<User> userOpt = repo.getUser(idx);
    if (userOpt.isEmpty()) throw new ApiException(HttpStatus.NOT_FOUND, "no match user idx");
    return mapper.map(userOpt.get(), UserInfo.class);
  }

  @Override
  public UserInfo findUserByEmail(String email) {
    Optional<User> userOpt = repo.findUserByEmail(email);
    if (userOpt.isEmpty()) throw new ApiException(HttpStatus.NOT_FOUND, "no match user");
    return mapper.map(userOpt.get(), UserInfo.class);
  }

  @Override
  public void deleteUser(long idx) {
    repo.deleteUser(idx);
  }

  @Override
  public UserInfo login(LoginReq req) {
    Optional<User> userOpt = repo.login(req.getEmail(), req.getPassword());
    if (userOpt.isEmpty()) throw new ApiException(HttpStatus.NOT_FOUND, "no match user");
    return mapper.map(userOpt.get(), UserInfo.class);
  }

  @Override
  public void updateProfile(UserDto.ProfileReq req) {
    repo.updateProfile(req.getIdx(), req.getName(), req.getImageIdx());
  }

  /** --------------------- Friend --------------------- */
  @Override
  public void addFriend(long userIdx, long friendIdx) {
    Optional<User> friendOpt = repo.getUser(friendIdx);
    if (friendOpt.isEmpty()) throw new ApiException(HttpStatus.NOT_FOUND, "no match user");
    repo.addFriend(userIdx, friendIdx);
  }

  @Override
  public List<UserInfo> getFriends(long userIdx, int page, int limit) {
    int offset = (page - 1) * limit;
    return repo.getFriends(userIdx, limit, offset).stream()
        .map(user -> mapper.map(user, UserInfo.class))
        .collect(Collectors.toList());
  }
}
