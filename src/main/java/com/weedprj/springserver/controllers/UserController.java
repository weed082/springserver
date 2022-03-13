package com.weedprj.springserver.controllers;

import java.util.List;

import com.weedprj.springserver.models.User;
import com.weedprj.springserver.ports.service.UserServicePort;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
  @Autowired
  private UserServicePort service;

  @GetMapping(path = "api/user/save")
  public String saveUser() {
    service.saveUser();
    return "yes";
  }

  @GetMapping(path = "api/user")
  public User getUser() {
    return service.getUser();
  }

  @GetMapping(path = "api/users")
  public List<User> getUsers() {
    return service.getUsers();
  }

}
