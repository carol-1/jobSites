package com.xuncai.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.mysql.cj.util.StringUtils;
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
    public int  delete(Integer id){
        return userMapper.delete(id);
    };
    //删除用户
    public int  delete(String ids){
        int row = 0;
        String[] arr = ids.split(",");
        for(String s:arr){
            if(!StringUtils.isEmptyOrWhitespaceOnly(s)){
               userMapper.delete(Integer.parseInt((s)));
               row++;
            }
        }
        return row;
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
    public PageInfo<User> query(User user){
        if(user!=null) {
        PageHelper.startPage(user.getPage(), user.getLimit());
      }
        List<User> list = userMapper.query(user);
        PageInfo pageInfo = new PageInfo(list);
        return pageInfo;
    };
    //查询信息详情
    public User detail(Integer id){
        return userMapper.detail(id);
    };
    //登录
    public User login(String userName,String password){
        User param = new User();
        param.setUserName(userName);
        param.setPassword(password);
        List<User> list = userMapper.query(param);
        if(list!=null && list.size()>0){
            return list.get(0);
        }else {
            return null;
        }
    }
}
