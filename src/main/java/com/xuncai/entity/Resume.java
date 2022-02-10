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
public class Resume extends Entity{

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
	private String jobStatus;
	/**
	 * 
	 */
	@Length(max = 0)
	private String evaluate;
	/**
	 * 
	 */
	@Length(max = 0)
	private String skill;
	/**
	 * 
	 */
	private Integer studentId;
	/**
	 * 0关闭|1开放
	 */
	private Integer status;

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
	public String getJobStatus() {
		return jobStatus;
	}
	public void setJobStatus(String jobStatus) {
		this.jobStatus = jobStatus;
	}
	public String getEvaluate() {
		return evaluate;
	}
	public void setEvaluate(String evaluate) {
		this.evaluate = evaluate;
	}
	public String getSkill() {
		return skill;
	}
	public void setSkill(String skill) {
		this.skill = skill;
	}
	public Integer getStudentId() {
		return studentId;
	}
	public void setStudentId(Integer studentId) {
		this.studentId = studentId;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
}