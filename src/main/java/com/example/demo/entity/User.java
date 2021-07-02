package com.example.demo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;


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
	private String id;
	
	/**
	 * 單位代碼
	 */
	@Column(name="org_code")
	private Integer orgCode;
	
	/**
	 * 姓名
	 */
	@Column(name="formal_name")
	@NotEmpty(message = "姓名不可為空")
	@NotBlank
	private String formalName;
	
	/**
	 * 別名
	 */
	@Column(name="account")
	@NotEmpty(message = "別名不可為空")
	@NotBlank
	private String account;
	
	/**
	 * 密碼
	 */
	@Column(name="password")
	@NotEmpty(message = "密碼不可為空")
	@NotBlank
	@Pattern(regexp = "^[a-zA-Z\\d\\S]{5,8}",
			message = "請輸入任意英數字混合共5~8碼")
	private String password;
	
	/**
	 * 角色
	 */
	@Column(name="role")
	private Integer role;

	public User(String id, Integer orgCode, String formalName, String account, String password, Integer role) {
		this.id = id;
		this.orgCode = orgCode;
		this.formalName = formalName;
		this.account = account;
		this.password = password;
		this.role = role;
	}

	public User() {
		// TODO Auto-generated constructor stub
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Integer getOrgCode() {
		return orgCode;
	}

	public void setOrgCode(Integer orgCode) {
		this.orgCode = orgCode;
	}

	public String getFormalName() {
		return formalName;
	}

	public void setFormalName(String formalName) {
		this.formalName = formalName;
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

	public Integer getRole() {
		return role;
	}

	public void setRole(Integer role) {
		this.role = role;
	}

	@Override
	public String toString() {
		return "User{" +
				"id='" + id + '\'' +
				", orgCode=" + orgCode +
				", formalName='" + formalName + '\'' +
				", account='" + account + '\'' +
				", password='" + password + '\'' +
				", role=" + role +
				'}';
	}
}
