package com.weedprj.springserver.domain.user.controller;

import com.weedprj.springserver.domain.user.dto.UserDto;
import com.weedprj.springserver.domain.user.port.UserServicePort;
import com.weedprj.springserver.global.error.ApiException;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;
import javax.transaction.Transactional;
import javax.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("api/v1/user")
public class UserController {
  @Autowired private UserServicePort service;
  private final Logger log = LoggerFactory.getLogger(UserController.class);

  // 중복된 이메일 확인
  @GetMapping(path = "/email/{email}")
  public ResponseEntity<Void> exitsUserByEmail(@PathVariable(required = true) final String email) {

    return service.existsUserByEmail(email)
        ? ResponseEntity.ok().build()
        : ResponseEntity.notFound().build();
  }

  // 사용자 저장
  @PostMapping
  @ResponseBody
  public UserDto.RegisterRes register(@RequestBody @Valid final UserDto.RegisterReq req) {
    return service.register(req);
  }

  // 사용자 프로필 정보 저장
  @Transactional
  @PutMapping(path = "/profile")
  public void uploadProfile(
      @RequestPart(name = "request") @Valid final UserDto.ProfileReq req,
      @RequestPart(name = "image") final MultipartFile imgFile)
      throws IOException {

    File file = new File(UUID.randomUUID() + imgFile.getOriginalFilename());
    imgFile.transferTo(file);
    // service.uploadProfile(name, img, firebase_token);
  }

  @PostMapping(path = "/login")
  @ResponseBody
  public UserDto.Info login(@RequestBody @Valid UserDto.LoginReq req) throws ApiException {
    return service.login(req);
  }

  // 단일 사용자 정보 가져오기
  @GetMapping(path = "/{idx}")
  @ResponseBody
  public UserDto.Info getUser(@PathVariable(required = true) long idx) throws Exception {
    return service.getUser(idx);
  }

  // 사용자 삭제
  @DeleteMapping(path = "/{idx}")
  @Transactional
  public void deleteUser(@PathVariable long idx) {
    service.deleteUser(idx);
  }

  @GetMapping(path = "/s")
  @ResponseBody
  public List<UserDto.Info> getUsers() {
    return service.getUsers();
  }
}
