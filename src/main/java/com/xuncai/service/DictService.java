package com.xuncai.service;

import com.xuncai.mapper.DictMapper;
import com.xuncai.entity.Dict;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

@Service
public class DictService {

    @Autowired
    private DictMapper dictMapper;

    public int create(Dict dict) {
        return dictMapper.create(dict);
    }

    public int delete(String ids) {
        String[] arr = ids.split(",");
        int row = 0;
        for (String s : arr) {
            if(!StringUtils.isEmpty(s)){
                dictMapper.delete(Integer.parseInt(s));
            row++;
            }
        }
        return row;
    }

    public int delete(Integer id) {
        return dictMapper.delete(id);
    }

    public int update(Dict dict) {
        return dictMapper.update(dict);
    }

    public int updateSelective(Dict dict) {
        return dictMapper.updateSelective(dict);
    }

    public PageInfo<Dict> query(Dict dict) {
        if(dict != null && dict.getPage() != null){
            PageHelper.startPage(dict.getPage(),dict.getLimit());
        }
        return new PageInfo<Dict>(dictMapper.query(dict));
    }

    public Dict detail(Integer id) {
        return dictMapper.detail(id);
    }

    public int count(Dict dict) {
        return dictMapper.count(dict);
    }
}
