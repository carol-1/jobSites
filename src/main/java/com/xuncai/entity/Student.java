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
public class Student extends Entity{

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
	private Date birthday;
	/**
	 * 
	 */
	private Integer professionId;
	/**
	 * 
	 */
	@Length(max = 100)
	private String college;
	/**
	 * 
	 */
	@Length(max = 100)
	private String education;
	/**
	 * 
	 */
	@Length(max = 100)
	private String phone;
	/**
	 * 
	 */
	private Integer sex;
	/**
	 * 
	 */
	@Length(max = 100)
	private String photo;
	/**
	 * 
	 */
	private Date graduateDate;

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
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	public Integer getProfessionId() {
		return professionId;
	}
	public void setProfessionId(Integer professionId) {
		this.professionId = professionId;
	}
	public String getCollege() {
		return college;
	}
	public void setCollege(String college) {
		this.college = college;
	}
	public String getEducation() {
		return education;
	}
	public void setEducation(String education) {
		this.education = education;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public Integer getSex() {
		return sex;
	}
	public void setSex(Integer sex) {
		this.sex = sex;
	}
	public String getPhoto() {
		return photo;
	}
	public void setPhoto(String photo) {
		this.photo = photo;
	}
	public Date getGraduateDate() {
		return graduateDate;
	}
	public void setGraduateDate(Date graduateDate) {
		this.graduateDate = graduateDate;
	}
}