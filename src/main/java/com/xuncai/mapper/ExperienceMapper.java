package com.xuncai.mapper;

import java.util.List;
import java.util.Map;

import com.xuncai.entity.Experience;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ExperienceMapper {

	public int create(Experience experience);

	public int delete(Integer id);

	public int update(Experience experience);

	public int updateSelective(Experience experience);

	public List<Experience> query(Experience experience);

	public Experience detail(Integer id);

	public int count(Experience experience);

}