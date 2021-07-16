package com.example.demo.entity;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;


/**
 * 對應資料庫的user表格
 *
 * @author SamChen
 * @version 1
 * @CreateDate 2021-05-31
 */
@Entity
@Table(name = "user")
public class User {

    /**
     * 帳號
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    /**
     * 單位代碼
     */
    @Column(name = "org_code")
    private Integer orgCode;

    /**
     * 姓名
     */
    @Column(name = "formalname", unique = true)
    @NotEmpty(message = "姓名不可為空")
    @NotBlank
    private String formalName;

    /**
     * 帳號
     */
    @Column(name = "username", unique = true)
    @NotEmpty(message = "別名不可為空")
    @NotBlank
    private String username;

    /**
     * 密碼
     */
    @Column(name = "password")
    @NotBlank(message = "密碼不可為空")
    private String password;

    /**
     * 啟用
     */
    @Column(name = "enabled")
    private Boolean enabled;
    /**
     * 角色
     */
    @Column(name = "authority")
    private String authority;

    public User() {
        // TODO Auto-generated constructor stub
    }

    public User(Integer id, Integer orgCode, String formalName, String username, String password, Boolean enabled, String authority) {
        this.id = id;
        this.orgCode = orgCode;
        this.formalName = formalName;
        this.username = username;
        this.password = password;
        this.enabled = enabled;
        this.authority = authority;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Boolean getEnabled() {
        return enabled;
    }

    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }

    public String getAuthority() {
        return authority;
    }

    public void setAuthority(String authority) {
        this.authority = authority;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", orgCode=" + orgCode +
                ", formalName='" + formalName + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", enabled=" + enabled +
                ", authority='" + authority + '\'' +
                '}';
    }
}
