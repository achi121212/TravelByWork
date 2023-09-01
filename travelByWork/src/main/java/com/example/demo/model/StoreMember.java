package com.example.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="storemember")
public class StoreMember {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer storememberid;
	@Column(name="storename")
	private String storename;
	@Column(name="ownername")
	private String ownername;
	private String account;
	private String password;
	private String email;
	private String mobile;
	private String phone;
	private String address;
	@Column(name="createtime")
	private String createtime;
	private String role;
	

	public StoreMember() {}




	public Integer getStorememberid() {
		return storememberid;
	}
	public void setStorememberid(Integer storememberid) {
		this.storememberid = storememberid;
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
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}




	public String getStorename() {
		return storename;
	}




	public void setStorename(String storename) {
		this.storename = storename;
	}




	public String getOwnername() {
		return ownername;
	}




	public void setOwnername(String ownername) {
		this.ownername = ownername;
	}




	public String getCreatetime() {
		return createtime;
	}




	public void setCreatetime(String createtime) {
		this.createtime = createtime;
	}




	public StoreMember(Integer storememberid, String storename, String ownername, String account, String password,
			String email, String mobile, String phone, String address, String createtime, String role) {
		super();
		this.storememberid = storememberid;
		this.storename = storename;
		this.ownername = ownername;
		this.account = account;
		this.password = password;
		this.email = email;
		this.mobile = mobile;
		this.phone = phone;
		this.address = address;
		this.createtime = createtime;
		this.role = role;
	}




	





}
