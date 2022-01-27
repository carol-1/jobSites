package com.xuncai.controller;

import com.xuncai.entity.User;
import com.xuncai.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {

  @Autowired
    private UserService userService;
    @GetMapping("create")
    public void create(User user){
        userService.create(user);

    }
    @PostMapping("create2")
    public void create2(@RequestBody User user){
        userService.create(user);

    }
    @GetMapping("get")
    public User get(Integer id){
      return   userService.detail(id);

    }


}
