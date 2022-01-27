package com.xuncai.service;

import com.xuncai.entity.User;
import com.xuncai.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserMapper userMapper;

    //增加用户
    public int create(User user){
     return userMapper.create(user);
    };
    //删除用户
    public int delete(Integer id){
        return userMapper.delete(id);
    };
    //修改用户
    public int update(User user){
        return userMapper.update(user);
    };
    //有选择性的更新
    public int updateSelective(User user){
        return userMapper.updateSelective(user);
    };
    //查询用户
    public List<User> query(User user){
        return userMapper.query(user);
    };
    //查询信息详情
    public User detail(Integer id){
        return userMapper.detail(id);
    };
}
