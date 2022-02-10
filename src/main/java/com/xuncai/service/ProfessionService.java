package com.xuncai.service;

import com.xuncai.mapper.ProfessionMapper;
import com.xuncai.entity.Profession;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;

@Service
public class ProfessionService {

    @Autowired
    private ProfessionMapper professionMapper;

    public int create(Profession profession) {
        return professionMapper.create(profession);
    }

    public int delete(String ids) {
        String[] arr = ids.split(",");
        int row = 0;
        for (String s : arr) {
            if(!StringUtils.isEmpty(s)){
                professionMapper.delete(Integer.parseInt(s));
            row++;
            }
        }
        return row;
    }

    public int delete(Integer id) {
        return professionMapper.delete(id);
    }

    public int update(Profession profession) {
        return professionMapper.update(profession);
    }

    public int updateSelective(Profession profession) {
        return professionMapper.updateSelective(profession);
    }

    public PageInfo<Profession> query(Profession profession) {
        if(profession != null && profession.getPage() != null){
            PageHelper.startPage(profession.getPage(),profession.getLimit());
        }
        return new PageInfo<Profession>(professionMapper.query(profession));
    }

    public List<Profession> tree() {
        return professionMapper.query(null);
    }

    public Profession detail(Integer id) {
        return professionMapper.detail(id);
    }

    public int count(Profession profession) {
        return professionMapper.count(profession);
    }

}
