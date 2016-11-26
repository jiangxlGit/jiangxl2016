package com.jiang.pojo;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * 
 * @功能概要： 学生实体类<br>
 * @项目名称： MDOS<br>
 * @初创作者： jiangxl <link 836200494@qq.com><br>
 * @公司名称： ShenZhen Montnets Technology CO.,LTD.<br>
 * @创建时间： 2016-10-25 下午3:52:21<br>
 */

@Entity
@Table(name = "tb_student")
public class Student {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long   id;// id
	
	@Column(name = "student_id")
	private String studentId;// 学号
	
	@Column(name = "name")
	private String name;// 姓名
	
	@Column(name = "gender")
	private String gender;// 性别

	@Column(name = "work_unit")
	private String workUnit;// 工作单位

	@Column(name = "post")
	private String post;// 职务

	@Column(name = "work_address")
	private String workAddress;// 工作地址

	@Column(name = "home_address")
	private String homeAddress;// 家庭住址

	@Column(name = "telephone")
	private String telephone;// 电话

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "create_date")
	private Date createDate;//创建时间
	
	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getGender() {
		return gender;
	}

	public String getWorkUnit() {
		return workUnit;
	}

	public String getPost() {
		return post;
	}

	public String getWorkAddress() {
		return workAddress;
	}

	public String getHomeAddress() {
		return homeAddress;
	}

	public String getTelephone() {
		return telephone;
	}

	public String getStudentId() {
		return studentId;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public void setStudentId(String studentId) {
		this.studentId = studentId;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public void setWorkUnit(String workUnit) {
		this.workUnit = workUnit;
	}

	public void setPost(String post) {
		this.post = post;
	}

	public void setWorkAddress(String workAddress) {
		this.workAddress = workAddress;
	}

	public void setHomeAddress(String homeAddress) {
		this.homeAddress = homeAddress;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

}
