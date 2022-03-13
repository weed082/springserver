package com.weedprj.springserver.controllers;

import java.util.List;

import com.weedprj.springserver.models.User;
import com.weedprj.springserver.ports.service.UserServicePort;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
  @Autowired
  private UserServicePort service;

  @PostMapping(path = "user")
  public String saveUser() {
    service.saveUser();
    return "SUCCESS";
  }

  @DeleteMapping(path = "user")
  public String deleteUser(@RequestParam(value = "idx")  int idx) {
    service.deleteUser(idx);
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

}
