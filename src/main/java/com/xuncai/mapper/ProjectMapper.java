package com.xuncai.mapper;

import java.util.List;
import java.util.Map;

import com.xuncai.entity.Project;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ProjectMapper {

	public int create(Project project);

	public int delete(Integer id);

	public int update(Project project);

	public int updateSelective(Project project);

	public List<Project> query(Project project);

	public Project detail(Integer id);

	public int count(Project project);

}