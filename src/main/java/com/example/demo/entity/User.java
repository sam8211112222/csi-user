package com.example.demo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


/**
 * 對應資料庫的user表格
 * @author SamChen
 * @version 1
 * @CreateDate 2021-05-31
 */
@Entity
@Table(name="user")
public class User {
	
	/**
	 * 帳號
	 */
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	/**
	 * 單位代碼
	 */
	@Column(name="org_code")
	private int orgCode;
	
	/**
	 * 姓名
	 */
	@Column(name="formal_name")
	private String formalName;
	
	/**
	 * 別名
	 */
	@Column(name="nick_name")
	private String nickName;
	
	/**
	 * 密碼
	 */
	@Column(name="password")
	private String password;
	
	/**
	 * 角色
	 */
	@Column(name="role")
	private int role;

	public User(int id, int orgCode, String formalName, String nickName, String password, int role) {
		super();
		this.id = id;
		this.orgCode = orgCode;
		this.formalName = formalName;
		this.nickName = nickName;
		this.password = password;
		this.role = role;
	}
	
	public User() {
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getOrgCode() {
		return orgCode;
	}

	public void setOrgCode(int orgCode) {
		this.orgCode = orgCode;
	}

	public String getFormalName() {
		return formalName;
	}

	public void setFormalName(String formalName) {
		this.formalName = formalName;
	}

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getRole() {
		return role;
	}

	public void setRole(int role) {
		this.role = role;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", orgCode=" + orgCode + ", formalName=" + formalName + ", nickName=" + nickName
				+ ", password=" + password + ", role=" + role + "]";
	}
}
