package com.xuncai.mapper;

import com.xuncai.entity.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
@Mapper
public interface UserMapper {
    //增加用户
    public int create(User user);
    //删除用户
    public int delete(Integer id);
    //修改用户
    public int update(User user);
    //有选择性的更新
    public int updateSelective(User user);
    //查询用户
    public List<User> query(User user);
    //查询信息详情
    public User detail(Integer id);

}
