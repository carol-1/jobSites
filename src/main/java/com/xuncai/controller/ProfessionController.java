package com.xuncai.controller;

import com.github.pagehelper.PageInfo;
import com.xuncai.entity.Profession;
import com.xuncai.service.ProfessionService;
import com.xuncai.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/profession")
public class ProfessionController {

    @Autowired
    private ProfessionService professionService;

    @PostMapping("create")
    public Result create(@RequestBody Profession profession){
        if(profession.getParentId() == null){
            profession.setParentId(0);
        }
        int flag = professionService.create(profession);
        if(flag>0){
            return Result.ok();
        }else{
            return Result.fail();
        }
    }

    @GetMapping("delete")
    public Result delete(String ids){
        int flag = professionService.delete(ids);
        if(flag>0){
            return Result.ok();
        }else{
            return Result.fail();
        }
    }

    @PostMapping("update")
    public Result update(@RequestBody Profession profession){
        int flag = professionService.update(profession);
        if(flag>0){
            return Result.ok();
        }else{
            return Result.fail();
        }
    }

    @GetMapping("detail")
    public Result detail(Integer id){
        return  Result.ok(professionService.detail(id));
    }

    @PostMapping("query")
    public Map<String,Object> query(@RequestBody  Profession profession){
        PageInfo<Profession> pageInfo = professionService.query(profession);
        return Result.ok(pageInfo);
    }

    @GetMapping("tree")
    public Result tree(){
        List<Profession> list = professionService.tree();
        List<Map<String,Object>> mapList = new ArrayList<>();
        list.forEach(profession -> {
            if(profession.getParentId() == 0){
                Map<String,Object> map = new HashMap<>();
                map.put("id",profession.getId());
                map.put("label",profession.getName());
                map.put("parentId",profession.getParentId());
                //构建children
                map.put("children",children(profession.getId(),list));
                mapList.add(map);
            }
        });
        return Result.ok(mapList);
    }
    public List<Map<String,Object>> children(int id,List<Profession> list){
        List<Map<String,Object>> children = new ArrayList<>();
        for (Profession profession : list) {
            if(profession.getParentId() == id){
                Map<String,Object> map = new HashMap<>();
                map.put("id",profession.getId());
                map.put("label",profession.getName());
                map.put("parentId",profession.getParentId());
                children.add(map);
            }
        }
        return children;
    }

}
