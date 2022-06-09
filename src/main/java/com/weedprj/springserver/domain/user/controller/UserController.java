package com.weedprj.springserver.domain.user.controller;

import com.weedprj.springserver.domain.user.dto.UserDto;
import com.weedprj.springserver.domain.user.port.UserServicePort;
import com.weedprj.springserver.global.error.ApiException;
import java.util.Map;
import javax.transaction.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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
@RequestMapping("api/v1/user")
public class UserController {
  private final Logger log = LoggerFactory.getLogger(UserController.class);
  @Autowired private UserServicePort service;

  // 중복된 이메일 확인
  @GetMapping(path = "/email/{email}")
  public ResponseEntity<Void> exitsUserByEmail(@PathVariable String email) throws ApiException {
    if (email.isEmpty()) throw new ApiException(HttpStatus.BAD_REQUEST, "empty email");

    return service.existsUserByEmail(email)
        ? ResponseEntity.ok().build()
        : ResponseEntity.notFound().build();
  }

  // 사용자 저장
  @PostMapping
  public ResponseEntity<UserDto.Info> register(@RequestBody UserDto.RegisterReq req) {
    return ResponseEntity.ok().build();
  }

  // 사용자 프로필 정보 저장
  @Transactional
  @PutMapping(path = "/profile")
  public ResponseEntity<Long> uploadProfile(@RequestBody Map<String, Object> req) {

    // service.uploadProfile(name, img, firebase_token);
    return ResponseEntity.accepted().build();
  }

  @PostMapping(path = "/login")
  public ResponseEntity<UserDto.Info> login(@RequestBody UserDto.LoginReq req) throws ApiException {
    if (req.getEmail().isEmpty()) throw new ApiException(HttpStatus.BAD_REQUEST, "email empty");
    if (req.getPassword().isEmpty())
      throw new ApiException(HttpStatus.BAD_REQUEST, "password empty");

    return ResponseEntity.ok(service.login(req));
  }

  // 단일 사용자 정보 가져오기
  @GetMapping(path = "/{idx}")
  @ResponseBody
  public ResponseEntity<UserDto.Info> getUser(@PathVariable long idx) throws Exception {
    return ResponseEntity.ok(service.getUser(idx));
  }

  // 사용자 삭제
  @Transactional
  @DeleteMapping(path = "/{idx}")
  public void deleteUser(@PathVariable long idx) {
    service.deleteUser(idx);
  }

  @GetMapping(path = "/s")
  public void getUsers() {
    service.getUsers();
  }
}
