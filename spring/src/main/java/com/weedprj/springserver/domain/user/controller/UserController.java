package com.weedprj.springserver.domain.user.controller;

import com.weedprj.springserver.domain.user.dto.UserDto;
import com.weedprj.springserver.domain.user.port.UserServicePort;
import java.util.List;
import javax.transaction.Transactional;
import javax.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1")
public class UserController {
  @Autowired private UserServicePort service;
  private final Logger log = LoggerFactory.getLogger(UserController.class);

  // 사용자 저장
  @PostMapping("/user")
  @ResponseBody
  public UserDto.RegisterRes register(@RequestBody @Valid final UserDto.RegisterReq req) {
    log.info("yes");
    return service.register(req);
  }

  // 사용자 프로필 정보 저장
  @PutMapping("/user/profile")
  public void uploadProfile(@RequestBody @Valid final UserDto.ProfileReq req) {
    service.updateProfile(req);
  }

  @PostMapping(path = "/user/login")
  @ResponseBody
  public UserDto.Info login(@RequestBody @Valid UserDto.LoginReq req) {
    return service.login(req);
  }

  // 단일 사용자 정보 가져오기
  @GetMapping("/user/{idx}")
  @ResponseBody
  public UserDto.Info getUser(@PathVariable(required = true) long idx) {
    return service.getUser(idx);
  }

  @GetMapping("/user/email/{email}")
  @ResponseBody
  public UserDto.Info findUserByEmail(@PathVariable String email) {
    return service.findUserByEmail(email);
  }

  // 사용자 삭제
  @DeleteMapping("/user/{idx}")
  public void deleteUser(@PathVariable long idx) {
    service.deleteUser(idx);
  }

  // ------------------------ 친구 -------------------------------
  @Transactional
  @PostMapping("/friend/{friendIdx}/user/{userIdx}")
  public void addFriednds(@PathVariable long friendIdx, @PathVariable long userIdx) {
    service.addFriend(userIdx, friendIdx);
  }

  @GetMapping("/friends/user/{userIdx}/page/{page}")
  @ResponseBody
  public List<UserDto.Info> getUsers(
      @PathVariable(required = true) long userIdx,
      @PathVariable(required = true) int page,
      @RequestParam(required = false, defaultValue = "8") int limit) {
    return service.getFriends(userIdx, page, limit);
  }
}
