package com.yanzhen.controller;

import com.github.pagehelper.PageInfo;
import com.yanzhen.entity.Type;
import com.yanzhen.service.TypeService;
import com.yanzhen.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/type")
public class TypeController {

    @Autowired
    private TypeService typeService;

    @PostMapping("create")
    public Result create(@RequestBody Type type){
        int flag = typeService.create(type);
        if(flag>0){
            return Result.ok();
        }else{
            return Result.fail();
        }
    }

    @GetMapping("delete")
    public Result delete(String ids){
        int flag = typeService.delete(ids);
        if(flag>0){
            return Result.ok();
        }else{
            return Result.fail();
        }
    }

    @PostMapping("update")
    public Result update(@RequestBody Type type){
        int flag = typeService.update(type);
        if(flag>0){
            return Result.ok();
        }else{
            return Result.fail();
        }
    }

    @GetMapping("detail")
    public Result detail(Integer id){
        return  Result.ok(typeService.detail(id));
    }

    @PostMapping("query")
    public Map<String,Object> query(@RequestBody  Type type){
        PageInfo<Type> pageInfo = typeService.query(type);
        return Result.ok(pageInfo);
    }

}
