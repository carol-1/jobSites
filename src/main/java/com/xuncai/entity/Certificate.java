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
public class Certificate extends Entity{

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
	private String file;
	/**
	 * 
	 */
	private Date obtainDate;
	/**
	 * 
	 */
	private Integer resumeId;

	private Resume resume;

	public Resume getResume() {
		return resume;
	}

	public void setResume(Resume resume) {
		this.resume = resume;
	}

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
	public String getFile() {
		return file;
	}
	public void setFile(String file) {
		this.file = file;
	}
	public Date getObtainDate() {
		return obtainDate;
	}
	public void setObtainDate(Date obtainDate) {
		this.obtainDate = obtainDate;
	}
	public Integer getResumeId() {
		return resumeId;
	}
	public void setResumeId(Integer resumeId) {
		this.resumeId = resumeId;
	}
}