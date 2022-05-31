package com.weedprj.springserver.controllers;

import com.weedprj.springserver.domain.user.User;
import com.weedprj.springserver.ports.service.UserServicePort;
import com.weedprj.springserver.util.exception.ApiException;
import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/user")
public class UserController {
  private final Logger log = LoggerFactory.getLogger("UserController");
  @Autowired private UserServicePort service;

  // 중복된 이메일 확인
  @GetMapping(path = "/email/{email}")
  public ResponseEntity<Void> exitsUserByEmail(@PathVariable String email) {
    if (email.isEmpty()) throw new ApiException(HttpStatus.BAD_REQUEST, "empty email");

    return service.existsUserByEmail(email)
        ? ResponseEntity.ok().build()
        : ResponseEntity.notFound().build();
  }

  // 사용자 저장
  @PostMapping
  public ResponseEntity<Long> register(@RequestBody User user) {
    return ResponseEntity.ok(service.register(user).getIdx());
  }

  // 사용자 프로필 정보 저장
  @PostMapping(path = "/profile")
  public ResponseEntity<Void> uploadProfile(@RequestBody User user) {
    return ResponseEntity.accepted().build();
  }

  @PostMapping(path = "/login")
  public ResponseEntity<User> login(@RequestBody User user) {
    log.info("login came");
    if (user.getEmail().isEmpty()) throw new ApiException(HttpStatus.BAD_REQUEST, "email empty");
    if (user.getPassword().isEmpty())
      throw new ApiException(HttpStatus.BAD_REQUEST, "password empty");

    Optional<User> userOpt = service.login(user.getEmail(), user.getPassword());
    return userOpt.isPresent()
        ? ResponseEntity.ok(userOpt.get())
        : ResponseEntity.notFound().build();
  }

  // 단일 사용자 정보 가져오기
  @GetMapping(path = "/{idx}")
  @ResponseBody
  public ResponseEntity<User> getUser(@PathVariable long idx) {
    Optional<User> userOpt = service.getUser(idx);
    if (userOpt.isEmpty()) throw new ApiException(HttpStatus.NOT_FOUND, "no match user idx");
    return ResponseEntity.ok(userOpt.get());
  }

  // 사용자 삭제
  @DeleteMapping(path = "/{idx}")
  public void deleteUser(@PathVariable long userIdx) {
    service.deleteUser(userIdx);
  }
}
