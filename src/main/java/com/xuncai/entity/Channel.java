package com.xuncai.entity;

import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;
import com.xuncai.utils.Entity;
import java.util.Date;



public class Channel extends Entity{

	/**
	 * 
	 */
	private Integer id;
	/**
	 * 
	 */
	@Length(max = 100)
	private String name;
	/**
	 * 
	 */
	private Integer parentId;
	/**
	 * 
	 */
	@Length(max = 100)
	private String channelImg;
	/**
	 * 
	 */
	@Length(max = 200)
	private String summary;
	/**
	 * Y单页|其他非单页
	 */
	@Length(max = 1)
	private String single;
	/**
	 * 
	 */
	@Length(max = 100)
	private String url;
	/**
	 * 
	 */
	@Length(max = 0)
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
	 * D删除
	 */
	@Length(max = 1)
	private String deletedFlag;
	/**
	 * 
	 */
	private Integer postion;

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getParentId() {
		return parentId;
	}
	public void setParentId(Integer parentId) {
		this.parentId = parentId;
	}
	public String getChannelImg() {
		return channelImg;
	}
	public void setChannelImg(String channelImg) {
		this.channelImg = channelImg;
	}
	public String getSummary() {
		return summary;
	}
	public void setSummary(String summary) {
		this.summary = summary;
	}
	public String getSingle() {
		return single;
	}
	public void setSingle(String single) {
		this.single = single;
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
	public String getDeletedFlag() {
		return deletedFlag;
	}
	public void setDeletedFlag(String deletedFlag) {
		this.deletedFlag = deletedFlag;
	}
	public Integer getPostion() {
		return postion;
	}
	public void setPostion(Integer postion) {
		this.postion = postion;
	}
}