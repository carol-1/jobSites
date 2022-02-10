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
public class Company extends Entity{

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
	@Length(max = 100)
	private String account;
	/**
	 * 
	 */
	@Length(max = 100)
	private String password;
	/**
	 * 
	 */
	@Length(max = 100)
	private String contact;
	/**
	 * 
	 */
	@Length(max = 100)
	private String telephone;
	/**
	 * 
	 */
	@Length(max = 100)
	private String email;
	/**
	 * 
	 */
	@Length(max = 200)
	private String addr;
	/**
	 * 
	 */
	@Length(max = 100)
	private String url;
	/**
	 * 
	 */
	@Length(max = 100)
	private String size;
	/**
	 * 
	 */
	@Length(max = 100)
	private String type;
	/**
	 * 
	 */
	@Length(max = 100)
	private String logo;
	/**
	 * 
	 */
	@Length(max = 0)
	private String description;

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
	public String getAccount() {
		return account;
	}
	public void setAccount(String account) {
		this.account = account;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getContact() {
		return contact;
	}
	public void setContact(String contact) {
		this.contact = contact;
	}
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAddr() {
		return addr;
	}
	public void setAddr(String addr) {
		this.addr = addr;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getSize() {
		return size;
	}
	public void setSize(String size) {
		this.size = size;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getLogo() {
		return logo;
	}
	public void setLogo(String logo) {
		this.logo = logo;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
}