package com.weedprj.springserver.controllers;

import com.weedprj.springserver.models.User;
import com.weedprj.springserver.ports.service.UserServicePort;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
  @Autowired private UserServicePort service;

  // 사용자 저장
  @PostMapping(path = "user")
  public String register(@RequestBody User user) {
    service.register(user);
    System.out.printf(
        "%s, %s, %s, %s %n", user.getIdx(), user.getName(), user.getEmail(), user.getPhone());
    return "SUCCESS";
  }

  // 사용자 프로필 정보 저장
  @PostMapping(path = "user/profile")
  public String uploadProfile(@RequestBody User user) {
    service.register(user);
    return "SUCCESS";
  }

  // 단일 사용자 정보 가져오기
  @GetMapping(path = "user/{idx}")
  @ResponseBody
  public User getUser(@PathVariable int idx) {
    return service.getUser(idx);
  }

  // 사용자 리스트 정보 가져오기
  @GetMapping(path = "users")
  @ResponseBody
  public List<User> getUsers() {
    return service.getUsers();
  }

  // 사용자 삭제
  @DeleteMapping(path = "user")
  public String deleteUser(@RequestBody Map<String, Integer> req) {
    int userIdx = req.get("idx");
    service.deleteUser(userIdx);
    return "SUCCESS";
  }
}
