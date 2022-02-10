package com.xuncai.service;

import com.xuncai.mapper.ProjectMapper;
import com.xuncai.entity.Project;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

@Service
public class ProjectService {

    @Autowired
    private ProjectMapper projectMapper;

    public int create(Project project) {
        return projectMapper.create(project);
    }

    public int delete(String ids) {
        String[] arr = ids.split(",");
        int row = 0;
        for (String s : arr) {
            if(!StringUtils.isEmpty(s)){
                projectMapper.delete(Integer.parseInt(s));
            row++;
            }
        }
        return row;
    }

    public int delete(Integer id) {
        return projectMapper.delete(id);
    }

    public int update(Project project) {
        return projectMapper.update(project);
    }

    public int updateSelective(Project project) {
        return projectMapper.updateSelective(project);
    }

    public PageInfo<Project> query(Project project) {
        if(project != null && project.getPage() != null){
            PageHelper.startPage(project.getPage(),project.getLimit());
        }
        return new PageInfo<Project>(projectMapper.query(project));
    }

    public Project detail(Integer id) {
        return projectMapper.detail(id);
    }

    public int count(Project project) {
        return projectMapper.count(project);
    }
}
