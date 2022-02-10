package com.xuncai.service;

import com.xuncai.mapper.IntentionMapper;
import com.xuncai.entity.Intention;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

@Service
public class IntentionService {

    @Autowired
    private IntentionMapper intentionMapper;

    public int create(Intention intention) {
        return intentionMapper.create(intention);
    }

    public int delete(String ids) {
        String[] arr = ids.split(",");
        int row = 0;
        for (String s : arr) {
            if(!StringUtils.isEmpty(s)){
                intentionMapper.delete(Integer.parseInt(s));
            row++;
            }
        }
        return row;
    }

    public int delete(Integer id) {
        return intentionMapper.delete(id);
    }

    public int update(Intention intention) {
        return intentionMapper.update(intention);
    }

    public int updateSelective(Intention intention) {
        return intentionMapper.updateSelective(intention);
    }

    public PageInfo<Intention> query(Intention intention) {
        if(intention != null && intention.getPage() != null){
            PageHelper.startPage(intention.getPage(),intention.getLimit());
        }
        return new PageInfo<Intention>(intentionMapper.query(intention));
    }

    public Intention detail(Integer id) {
        return intentionMapper.detail(id);
    }

    public int count(Intention intention) {
        return intentionMapper.count(intention);
    }
}
