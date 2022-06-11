package com.weedprj.springserver.domain.user.controller;

import com.weedprj.springserver.domain.user.dto.UserDto;
import com.weedprj.springserver.domain.user.port.UserServicePort;
import java.util.List;
import javax.transaction.Transactional;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1")
public class UserController {
  @Autowired private UserServicePort service;

  // 중복된 이메일 확인
  @GetMapping(path = "/user/email/{email}")
  public ResponseEntity<Void> exitsUserByEmail(@PathVariable(required = true) final String email) {

    return service.existsUserByEmail(email)
        ? ResponseEntity.ok().build()
        : ResponseEntity.notFound().build();
  }

  // 사용자 저장
  @PostMapping("/user")
  @ResponseBody
  public UserDto.RegisterRes register(@RequestBody @Valid final UserDto.RegisterReq req) {
    return service.register(req);
  }

  // 사용자 프로필 정보 저장
  @Transactional
  @PutMapping(path = "/user/profile")
  public void uploadProfile(@RequestBody @Valid final UserDto.ProfileReq req) {
    service.updateProfile(req);
  }

  @PostMapping(path = "/user/login")
  @ResponseBody
  public UserDto.Info login(@RequestBody @Valid UserDto.LoginReq req) {
    return service.login(req);
  }

  // 단일 사용자 정보 가져오기
  @GetMapping(path = "/user/{idx}")
  @ResponseBody
  public UserDto.Info getUser(@PathVariable(required = true) long idx) {
    return service.getUser(idx);
  }

  // 사용자 삭제
  @DeleteMapping(path = "/user/{idx}")
  @Transactional
  public void deleteUser(@PathVariable long idx) {
    service.deleteUser(idx);
  }

  @GetMapping(path = "/users")
  @ResponseBody
  public List<UserDto.Info> getUsers() {
    return service.getUsers();
  }
}
