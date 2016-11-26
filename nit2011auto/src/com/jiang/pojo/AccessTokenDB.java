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


@Entity
@Table(name = "tb_access_token")
public class AccessTokenDB {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long   id;// id
	
	@Column(name = "access_token")
	private String accessToken;	 // 获取到的凭证
	
	@Column(name = "expires_in")
	private Integer expiresIn; 		 // 凭证有效时间，单位：秒
	
	@Column(name = "expires_custom")
	private Integer expiresCustom;	 // 获取access_token的提前时间
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "create_date")
	private Date createDate;		 // 创建时间

	public Long getId() {
		return id;
	}

	public String getAccessToken() {
		return accessToken;
	}

	public Integer getExpiresIn() {
		return expiresIn;
	}

	public Integer getExpiresCustom() {
		return expiresCustom;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setAccessToken(String accessToken) {
		this.accessToken = accessToken;
	}

	public void setExpiresIn(Integer expiresIn) {
		this.expiresIn = expiresIn;
	}

	public void setExpiresCustom(Integer expiresCustom) {
		this.expiresCustom = expiresCustom;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	

	
}
