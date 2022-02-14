package com.xuncai.service;

import com.xuncai.mapper.ArticleMapper;
import com.xuncai.entity.Article;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;


import java.util.List;

@Service
public class ArticleService {

    @Autowired
    private ArticleMapper articleMapper;

    public int create(Article article) {
        return articleMapper.create(article);
    }

    public int delete(String ids) {
        String[] arr = ids.split(",");
        int row = 0;
        for (String s : arr) {
            if(!StringUtils.isEmpty(s)){
                articleMapper.delete(Integer.parseInt(s));
            row++;
            }
        }
        return row;
    }

    public int delete(Integer id) {
        return articleMapper.delete(id);
    }

    public int update(Article article) {
        return articleMapper.update(article);
    }

    public int updateSelective(Article article) {
        return articleMapper.updateSelective(article);
    }

    public PageInfo<Article> query(Article article) {
        if(article != null && article.getPage() != null){
            PageHelper.startPage(article.getPage(),article.getLimit());
        }
        return new PageInfo<Article>(articleMapper.query(article));
    }

    public Article detail(Integer id) {
        return articleMapper.detail(id);
    }

    public int count(Article article) {
        return articleMapper.count(article);
    }

    public PageInfo<Article> getArticlesByChannelId(Article article){
        if(article != null && article.getPage() != null){
            PageHelper.startPage(article.getPage(),article.getLimit());
        }
        return new PageInfo<Article>(articleMapper.getArticlesByChannelId(article.getChannelId()));
    }
}
