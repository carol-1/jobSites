package com.xuncai.entity;

import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;
import com.xuncai.utils.Entity;
import java.util.Date;


/**
 * 
 * @author 596183363@qq.com
 * @time 2020-12-24 22:40:33
 */
public class Article extends Entity{

	/**
	 * 
	 */
	private Integer id;
	/**
	 * 
	 */
	private Integer channelId;
	/**
	 * 
	 */
	@Length(max = 100)
	private String title;
	/**
	 * 
	 */
	@Length(max = 100)
	private String titleImg;
	/**
	 * 
	 */
	@Length(max = 200)
	private String summary;
	/**
	 * 
	 */
	@Length(max = 100)
	private String author;
	/**
	 * 
	 */
	@Length(max = 100)
	private String url;
	/**
	 * 
	 */
	private String content;
	/**
	 * 
	 */
	private Integer sort;
	/**
	 * 
	 */
	private Date createDate;
	/**
	 * 
	 */
	private Integer createUser;
	/**
	 * 
	 */
	private Date updateDate;

	private Integer views;

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getChannelId() {
		return channelId;
	}
	public void setChannelId(Integer channelId) {
		this.channelId = channelId;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getTitleImg() {
		return titleImg;
	}
	public void setTitleImg(String titleImg) {
		this.titleImg = titleImg;
	}
	public String getSummary() {
		return summary;
	}
	public void setSummary(String summary) {
		this.summary = summary;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Integer getSort() {
		return sort;
	}
	public void setSort(Integer sort) {
		this.sort = sort;
	}
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	public Integer getCreateUser() {
		return createUser;
	}
	public void setCreateUser(Integer createUser) {
		this.createUser = createUser;
	}
	public Date getUpdateDate() {
		return updateDate;
	}
	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}

	public Integer getViews() {
		return views;
	}

	public void setViews(Integer views) {
		this.views = views;
	}
}