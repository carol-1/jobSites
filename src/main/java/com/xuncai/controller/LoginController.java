package com.xuncai.controller;

import com.xuncai.entity.Company;
import com.xuncai.entity.Student;
import com.xuncai.entity.User;
import com.xuncai.framework.redis.RedisUtil;
import com.xuncai.framework.role.Role;
import com.xuncai.service.CompanyService;
import com.xuncai.service.StudentService;
import com.xuncai.service.UserService;
import com.xuncai.utils.Result;
import com.xuncai.vo.UserData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;
import java.util.UUID;

@RestController
public class LoginController {

    @Autowired
    private UserService userService;
    @Autowired
    private CompanyService companyService;
    @Autowired
    private StudentService studentService;

    @Autowired
    private RedisUtil redisUtil;

    @PostMapping("/login")
    public Result login(@RequestBody Map<String,String> map){

        String account = map.get("account");//获取用户名
        String password = map.get("password");//获取密码
        String type = map.get("type");//获取类型

        boolean flag = false;//判断查询是否成功
        UserData userData = new UserData();
        if(String.valueOf(Role.ADMIN.getCode()).equals(type)){ //管理员登录
            User login = userService.login(account, password);
            if(login != null){
                //赋值操作
                userData.setId(login.getId());
                userData.setAccount(login.getUserName());
                userData.setName(login.getName());
                userData.setType(Role.ADMIN.getCode());
                flag = true;
            }
        }

        if(String.valueOf(Role.COMPANY.getCode()).equals(type)){ //企业登录
            Company login = companyService.login(account, password);
            if(login != null){
                userData.setId(login.getId());
                userData.setAccount(login.getAccount());
                userData.setName(login.getName());
                userData.setType(Role.COMPANY.getCode());
                flag = true;
            }
        }

        if(String.valueOf(Role.STUDENT.getCode()).equals(type)){ //学生登录
            Student login = studentService.login(account, password);
            if(login != null){
                userData.setId(login.getId());
                userData.setAccount(login.getAccount());
                userData.setName(login.getName());
                userData.setType(Role.STUDENT.getCode());
                flag = true;
            }
        }
        if(flag){
            //登录成功的情况
            String token = UUID.randomUUID().toString();//先生成uuid
            userData.setToken(token);
            redisUtil.set(token,userData,RedisUtil.EXPR);
            return Result.ok(userData);
        }else{
            return Result.fail("用户或密码错误");
        }
    }

}
