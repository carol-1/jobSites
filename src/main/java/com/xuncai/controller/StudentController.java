package com.xuncai.controller;

import com.github.pagehelper.PageInfo;
import com.xuncai.entity.Student;
import com.xuncai.framework.redis.RedisUtil;
import com.xuncai.framework.role.RequiresRoles;
import com.xuncai.framework.role.Role;
import com.xuncai.service.StudentService;
import com.xuncai.utils.Result;
import com.xuncai.utils.UserThreadLocal;
import com.xuncai.vo.UserData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @Autowired
    private RedisUtil redisUtil;

    @PostMapping("create")
    public Result create(@RequestBody Student student){
        int flag = studentService.create(student);
        if(flag>0){
            return Result.ok();
        }else{
            return Result.fail();
        }
    }

    @GetMapping("delete")
    public Result delete(String ids){
        int flag = studentService.delete(ids);
        if(flag>0){
            return Result.ok();
        }else{
            return Result.fail();
        }
    }

    @PostMapping("update")
    public Result update(@RequestBody Student student){
        int flag = studentService.update(student);
        if(flag>0){
            return Result.ok();
        }else{
            return Result.fail();
        }
    }

    @GetMapping("detail")
    public Result detail(Integer id){
        return  Result.ok(studentService.detail(id));
    }

    @GetMapping("info")
    @RequiresRoles(type = Role.STUDENT)
    public Result info(){
        String token = UserThreadLocal.get();
        UserData userData = (UserData) redisUtil.get(token);
        return  Result.ok(studentService.detail(userData.getId()));
    }

    @PostMapping("query")
    public Map<String,Object> query(@RequestBody  Student student){
        PageInfo<Student> pageInfo = studentService.query(student);
        return Result.ok(pageInfo);
    }



}
