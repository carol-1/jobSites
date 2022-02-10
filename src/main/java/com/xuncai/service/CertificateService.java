package com.xuncai.service;

import com.xuncai.mapper.CertificateMapper;
import com.xuncai.entity.Certificate;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

@Service
public class CertificateService {

    @Autowired
    private CertificateMapper certificateMapper;

    public int create(Certificate certificate) {
        return certificateMapper.create(certificate);
    }

    public int delete(String ids) {
        String[] arr = ids.split(",");
        int row = 0;
        for (String s : arr) {
            if(!StringUtils.isEmpty(s)){
                certificateMapper.delete(Integer.parseInt(s));
            row++;
            }
        }
        return row;
    }

    public int delete(Integer id) {
        return certificateMapper.delete(id);
    }

    public int update(Certificate certificate) {
        return certificateMapper.update(certificate);
    }

    public int updateSelective(Certificate certificate) {
        return certificateMapper.updateSelective(certificate);
    }

    public PageInfo<Certificate> query(Certificate certificate) {
        if(certificate != null && certificate.getPage() != null){
            PageHelper.startPage(certificate.getPage(),certificate.getLimit());
        }
        return new PageInfo<Certificate>(certificateMapper.query(certificate));
    }

    public Certificate detail(Integer id) {
        return certificateMapper.detail(id);
    }

    public int count(Certificate certificate) {
        return certificateMapper.count(certificate);
    }
}
