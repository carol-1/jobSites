package com.xuncai.controller;

import com.github.pagehelper.PageInfo;
import com.xuncai.entity.Resume;
import com.xuncai.framework.redis.RedisUtil;
import com.xuncai.service.ResumeService;
import com.xuncai.utils.Result;
import com.xuncai.utils.UserThreadLocal;
import com.xuncai.vo.UserData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/resume")
public class ResumeController {

    @Autowired
    private ResumeService resumeService;
    @Autowired
    private RedisUtil redisUtil;

    @PostMapping("create")
    public Result create(@RequestBody Resume resume){

        String token = UserThreadLocal.get();
        UserData userData = (UserData) redisUtil.get(token);
        resume.setStudentId(userData.getId());
        int flag = resumeService.create(resume);
        if(flag>0){
            return Result.ok();
        }else{
            return Result.fail();
        }
    }

    @GetMapping("delete")
    public Result delete(String ids){
        int flag = resumeService.delete(ids);
        if(flag>0){
            return Result.ok();
        }else{
            return Result.fail();
        }
    }

    @PostMapping("update")
    public Result update(@RequestBody Resume resume){
        int flag = resumeService.update(resume);
        if(flag>0){
            return Result.ok();
        }else{
            return Result.fail();
        }
    }

    @GetMapping("detail")
    public Result detail(Integer id){
        return  Result.ok(resumeService.detail(id));
    }

    @PostMapping("query")
    public Map<String,Object> query(@RequestBody  Resume resume){

        String token = UserThreadLocal.get();
        UserData userData = (UserData) redisUtil.get(token);
        resume.setStudentId(userData.getId());
        PageInfo<Resume> pageInfo = resumeService.query(resume);
        return Result.ok(pageInfo);
    }

}
