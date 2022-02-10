package com.xuncai.controller;

import com.github.pagehelper.PageInfo;
import com.xuncai.entity.Certificate;
import com.xuncai.entity.Resume;
import com.xuncai.service.CertificateService;
import com.xuncai.service.ResumeService;
import com.xuncai.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/certificate")
public class CertificateController {

    @Autowired
    private CertificateService certificateService;

    @Autowired
    private ResumeService resumeService;

    @PostMapping("create")
    public Result create(@RequestBody Certificate certificate){
        int flag = certificateService.create(certificate);
        if(flag>0){
            return Result.ok();
        }else{
            return Result.fail();
        }
    }

    @GetMapping("delete")
    public Result delete(String ids){
        int flag = certificateService.delete(ids);
        if(flag>0){
            return Result.ok();
        }else{
            return Result.fail();
        }
    }

    @PostMapping("update")
    public Result update(@RequestBody Certificate certificate){
        int flag = certificateService.update(certificate);
        if(flag>0){
            return Result.ok();
        }else{
            return Result.fail();
        }
    }

    @GetMapping("detail")
    public Result detail(Integer id){
        return  Result.ok(certificateService.detail(id));
    }

    @PostMapping("query")
    public Map<String,Object> query(@RequestBody  Certificate certificate){
        PageInfo<Certificate> pageInfo = certificateService.query(certificate);
        pageInfo.getList().forEach(item->{
            Resume detail = resumeService.detail(item.getResumeId());
            item.setResume(detail);
        });
        return Result.ok(pageInfo);
    }

}
