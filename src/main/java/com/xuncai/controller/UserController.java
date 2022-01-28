package com.xuncai.controller;

import com.github.pagehelper.PageInfo;
import com.xuncai.entity.User;
import com.xuncai.service.UserService;
import com.xuncai.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

  @Autowired
    private UserService userService;
     //新增
    @PostMapping("create")
    public Result create(@RequestBody User user){
      int row =   userService.create(user);
      if(row>0){
        return Result.ok();
      }else{
        return Result.error();
      }

    }
    //修改
    @PostMapping("update")
    public Result update(@RequestBody User user){
      int row =   userService.updateSelective(user);
      if(row>0){
        return Result.ok();
      }else{
        return Result.error();
      }

    }
    //删除
  @GetMapping("delete")
  public Result delete(Integer id){
    int row =   userService.delete(id);
    if(row>0){
      return Result.ok();
    }else{
      return Result.error();
    }

  }
  @GetMapping("detail")
  public Result detail(Integer id){
    User user =   userService.detail(id);
    return Result.ok(user);

  }
  @PostMapping("query")
  public Result query(@RequestBody User user){
    PageInfo<User> pageInfo = userService.query(user);
    return  Result.ok(pageInfo);

  }

}
