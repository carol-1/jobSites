package com.xuncai.mapper;

import java.util.List;
import java.util.Map;

import com.xuncai.entity.UserMenu;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMenuMapper {

	public int create(UserMenu userMenu);

	public int delete(Integer id);

	public int update(UserMenu userMenu);

	public int updateSelective(UserMenu userMenu);

	public List<UserMenu> query(UserMenu userMenu);

	public UserMenu detail(Integer id);

	public int count(UserMenu userMenu);

}