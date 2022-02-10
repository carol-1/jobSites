package com.xuncai.controller;

import com.github.pagehelper.PageInfo;
import com.xuncai.entity.Post;
import com.xuncai.framework.redis.RedisUtil;
import com.xuncai.service.PostService;
import com.xuncai.service.UserDataService;
import com.xuncai.utils.Result;
import com.xuncai.utils.UserThreadLocal;
import com.xuncai.vo.UserData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/post")
public class PostController {

    @Autowired
    private PostService postService;
    @Autowired
    private RedisUtil redisUtil;
    @Autowired
    UserDataService userDataService;

    @PostMapping("create")
    public Result create(@RequestBody Post post){

        String token = UserThreadLocal.get();
        UserData userData = (UserData) redisUtil.get(token);
        post.setCompanyId(userData.getId());
        int flag = postService.create(post);
        if(flag>0){
            return Result.ok();
        }else{
            return Result.fail();
        }
    }

    @GetMapping("delete")
    public Result delete(String ids){
        int flag = postService.delete(ids);
        if(flag>0){
            return Result.ok();
        }else{
            return Result.fail();
        }
    }

    @PostMapping("update")
    public Result update(@RequestBody Post post){
        int flag = postService.update(post);
        if(flag>0){
            return Result.ok();
        }else{
            return Result.fail();
        }
    }

    @GetMapping("detail")
    public Result detail(Integer id){
        return  Result.ok(postService.detail(id));
    }

    @PostMapping("query")
    public Map<String,Object> query(@RequestBody  Post post){
        UserData userData = userDataService.getUserData();
        post.setCompanyId(userData.getId());
        PageInfo<Post> pageInfo = postService.query(post);
        return Result.ok(pageInfo);
    }

}
