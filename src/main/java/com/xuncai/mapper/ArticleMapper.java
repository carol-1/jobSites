package com.xuncai.mapper;

import java.util.List;
import java.util.Map;

import com.xuncai.entity.Article;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ArticleMapper {

	public int create(Article article);

	public int delete(Integer id);

	public int update(Article article);

	public int updateSelective(Article article);

	public List<Article> query(Article article);

	public List<Article> getArticlesByChannelId(Integer channelId);

	public Article detail(Integer id);

	public int count(Article article);

}