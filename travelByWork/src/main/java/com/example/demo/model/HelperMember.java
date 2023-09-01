package com.example.demo.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "helpermember")
public class HelperMember implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer helpermemberid;
	private String username;
	private String name;
	private String account;
	private String password;
	private String email;
	private String mobile;
	private String country;
	private String birth;
	private String sexual;
	private Date createtime;
	private String role;

	public HelperMember() {
	}

	public HelperMember(Integer helpermemberid, String username, String name, String account, String password,
			String email, String mobile, String country, String birth, String sexual, Date createtime, String role) {
		this.helpermemberid = helpermemberid;
		this.username = username;
		this.name = name;
		this.account = account;
		this.password = password;
		this.email = email;
		this.mobile = mobile;
		this.country = country;
		this.birth = birth;
		this.sexual = sexual;
		this.createtime = createtime;
		this.role = role;
	}

	public Integer getHelpermemberid() {
		return helpermemberid;
	}

	public void setHelpermemberid(Integer helpermemberid) {
		this.helpermemberid = helpermemberid;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getBirth() {
		return birth;
	}

	public void setBirth(String birth) {
		this.birth = birth;
	}

	public String getSexual() {
		return sexual;
	}

	public void setSexual(String sexual) {
		this.sexual = sexual;
	}

	public Date getCreatetime() {
		return createtime;
	}

	public void setCreatetime(Date createtime) {
		this.createtime = createtime;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	@Override
	public String toString() {
		return "HelperMember{" + "helpermemberid=" + helpermemberid + ", username='" + username + '\'' + ", name='"
				+ name + '\'' + ", account='" + account + '\'' + ", password='" + password + '\'' + ", email='" + email
				+ '\'' + ", mobile='" + mobile + '\'' + ", country='" + country + '\'' + ", birth='" + birth + '\''
				+ ", sexual='" + sexual + '\'' + ", createtime=" + createtime + ", role='" + role + '\'' + '}';
	}
}
