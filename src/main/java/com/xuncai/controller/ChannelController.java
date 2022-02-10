package com.xuncai.controller;

import com.github.pagehelper.PageInfo;
import com.xuncai.entity.Channel;
import com.xuncai.framework.redis.RedisUtil;
import com.xuncai.service.ChannelService;
import com.xuncai.utils.Result;
import com.xuncai.utils.UserThreadLocal;
import com.xuncai.vo.UserData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/channel")
public class ChannelController {

    @Autowired
    private ChannelService channelService;
    @Autowired
    private RedisUtil redisUtil;

    @PostMapping("create")
    public Result create(@RequestBody Channel channel){
        String token = UserThreadLocal.get();
        UserData userData = (UserData) redisUtil.get(token);
        channel.setCreateDate(new Date());
        channel.setCreateUser(userData.getId());
        if(channel.getParentId() == null){
            channel.setParentId(0);
        }
        int flag = channelService.create(channel);
        if(flag>0){
            return Result.ok();
        }else{
            return Result.fail();
        }
    }

    @GetMapping("delete")
    public Result delete(String ids){
        int flag = channelService.delete(ids);
        if(flag>0){
            return Result.ok();
        }else{
            return Result.fail();
        }
    }

    @PostMapping("update")
    public Result update(@RequestBody Channel channel){
        int flag = channelService.update(channel);
        if(flag>0){
            return Result.ok();
        }else{
            return Result.fail();
        }
    }

    @GetMapping("detail")
    public Result detail(Integer id){
        return  Result.ok(channelService.detail(id));
    }

    @PostMapping("query")
    public Map<String,Object> query(@RequestBody  Channel channel){
        PageInfo<Channel> pageInfo = channelService.query(channel);
        return Result.ok(pageInfo);
    }

    @GetMapping("tree")
    public Result tree(){
        List<Channel> list = channelService.tree(null);
        List<Map<String,Object>> mapList = new ArrayList<>();
        list.forEach(channel -> {
            if(channel.getParentId() == 0){
                Map map = new HashMap();
                map.put("id",channel.getId());
                map.put("label",channel.getName());
                if(isChildren(channel.getId(),list)){
                    map.put("children",children(channel.getId(),list));
                }
                mapList.add(map);
            }
        });
        return Result.ok(mapList);
    }


    //如何支持多级：递归【自己调用自己、出口】
    public List<Map<String,Object>> children(int id,List<Channel> list){
        List<Map<String,Object>> children = new ArrayList<>();
        for (Channel channel : list) {
            if(channel.getParentId() == id){
                Map map = new HashMap();
                map.put("id",channel.getId());
                map.put("label",channel.getName());
                if(isChildren(channel.getId(),list)){//出口
                    map.put("children",children(channel.getId(),list));
                }
                children.add(map);
            }
        }
        return children;
    }

    public boolean isChildren(int id,List<Channel> list){
        boolean flag = false;
        for (Channel channel : list) {
            if(channel.getParentId() == id){
                flag = true;
            }
        }
        return flag;
    }




}
