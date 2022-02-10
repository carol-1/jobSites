package com.xuncai.controller;

import com.github.pagehelper.PageInfo;
import com.xuncai.entity.Dict;
import com.xuncai.framework.redis.RedisUtil;
import com.xuncai.service.DictService;
import com.xuncai.utils.Result;
import com.xuncai.utils.UserThreadLocal;
import com.xuncai.vo.UserData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/dict")
public class DictController {

    @Autowired
    private DictService dictService;

    @PostMapping("create")
    public Result create(@RequestBody Dict dict){

        int flag = dictService.create(dict);
        if(flag>0){
            return Result.ok();
        }else{
            return Result.fail();
        }
    }

    @GetMapping("delete")
    public Result delete(String ids){
        int flag = dictService.delete(ids);
        if(flag>0){
            return Result.ok();
        }else{
            return Result.fail();
        }
    }

    @PostMapping("update")
    public Result update(@RequestBody Dict dict){
        int flag = dictService.update(dict);
        if(flag>0){
            return Result.ok();
        }else{
            return Result.fail();
        }
    }

    @GetMapping("detail")
    public Result detail(Integer id){
        return  Result.ok(dictService.detail(id));
    }

    @PostMapping("query")
    public Map<String,Object> query(@RequestBody  Dict dict){
        PageInfo<Dict> pageInfo = dictService.query(dict);
        return Result.ok(pageInfo);
    }

}
