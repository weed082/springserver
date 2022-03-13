package com.weedprj.springserver.controllers;

import java.util.List;
import java.util.Map;

import com.weedprj.springserver.models.User;
import com.weedprj.springserver.ports.service.UserServicePort;

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
  @Autowired
  private UserServicePort service;

  @PostMapping(path = "user")
  public String saveUser(@RequestBody User user) {
    service.saveUser(user);
    return "SUCCESS";
  }

  @GetMapping(path = "user/{idx}")
  @ResponseBody
  public User getUser(@PathVariable int idx) {
    return service.getUser(idx);
  }

  @GetMapping(path = "users")
  @ResponseBody
  public List<User> getUsers() {
    return service.getUsers();
  }

  @DeleteMapping(path = "user")
  public String deleteUser(@RequestBody Map<String, Integer> req) {
    int userIdx = req.get("idx");
    service.deleteUser(userIdx);
    return "SUCCESS";
  }

}
