package com.xuncai.controller;

import com.github.pagehelper.PageInfo;
import com.xuncai.entity.Resume;
import com.xuncai.entity.Send;
import com.xuncai.framework.redis.RedisUtil;
import com.xuncai.framework.role.RequiresRoles;
import com.xuncai.framework.role.Role;
import com.xuncai.service.*;
import com.xuncai.utils.Result;
import com.xuncai.utils.UserThreadLocal;
import com.xuncai.vo.UserData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/send")
public class SendController {

    @Autowired
    private RedisUtil redisUtil;
    @Autowired
    private UserDataService userDataService;
    @Autowired
    private SendService sendService;
    @Autowired
    private ResumeService resumeService;

    @Autowired
    private CompanyService companyService;
    @Autowired
    private PostService postService;

    @Autowired
    private StudentService studentService;

    @PostMapping("create")
    public Result create(@RequestBody Map<String,Integer> map){
        UserData userData = userDataService.getUserData();
        //1、判断用户是否登录
        if(userData == null){
            return Result.ok("未登录不能操作");
        }
        Integer postId = map.get("postId");
        Integer companyId = map.get("companyId");

        //2、判断是否重复投递简历
        Send sendParam = new Send();
        sendParam.setStudentId(userData.getId());
        sendParam.setPostId(postId);
        sendParam.setCompanyId(companyId);
        PageInfo<Send> sendPageInfo = sendService.query(sendParam);
        if(sendPageInfo.getList() != null && sendPageInfo.getList().size()>0){
            return Result.fail("请勿重复投递简历");
        }

        Send send = new Send();
        send.setPostId(postId);
        send.setCompanyId(companyId);
        send.setSendDate(new Date());
        send.setStatus(0);
        send.setStudentId(userData.getId());

        //3、判断简历是否开放
        Resume param = new Resume();
        param.setStudentId(userData.getId());
        param.setStatus(1);
        PageInfo<Resume> pageInfo = resumeService.query(param);
        if(pageInfo.getList() != null && pageInfo.getList().size()>0){
            Resume entity = pageInfo.getList().get(0);
            send.setResumeId(entity.getId());
        }else{
            return Result.fail("请完善简历");
        }
        //4、投递
        int row = sendService.create(send);
        if(row>0){
            return Result.ok();
        }else{
            return Result.fail();
        }
    }

    @GetMapping("delete")
    public Result delete(String ids){
        int flag = sendService.delete(ids);
        if(flag>0){
            return Result.ok();
        }else{
            return Result.fail();
        }
    }

    @PostMapping("update")
    public Result update(@RequestBody Send send){
        int flag = sendService.update(send);
        if(flag>0){
            return Result.ok();
        }else{
            return Result.fail();
        }
    }

    @GetMapping("detail")
    public Result detail(Integer id){
        return  Result.ok(sendService.detail(id));
    }

    @RequiresRoles(type = Role.COMPANY)
    @PostMapping("query")
    public Map<String,Object> query(@RequestBody  Send send){
        String token = UserThreadLocal.get();
        UserData userData = (UserData) redisUtil.get(token);
        send.setCompanyId(userData.getId());
        PageInfo<Send> pageInfo = sendService.query(send);

        pageInfo.getList().forEach(item->{
            item.setCompany(companyService.detail(item.getCompanyId()));
            item.setResume(resumeService.detail(item.getResumeId()));
            item.setStudent(studentService.detail(item.getStudentId()));
            item.setPost(postService.detail(item.getPostId()));
        });

        return Result.ok(pageInfo);
    }

    @RequiresRoles(type = Role.STUDENT)
    @PostMapping("student_send")
    public Map<String,Object> student_send(@RequestBody  Send send){
        String token = UserThreadLocal.get();
        UserData userData = (UserData) redisUtil.get(token);
        send.setStudentId(userData.getId());
        PageInfo<Send> pageInfo = sendService.query(send);

        pageInfo.getList().forEach(item->{
            item.setCompany(companyService.detail(item.getCompanyId()));
            item.setResume(resumeService.detail(item.getResumeId()));
            item.setPost(postService.detail(item.getPostId()));
        });

        return Result.ok(pageInfo);
    }

}
