package com.example.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "helpercv")
public class helpercv {

	@Id
	private Integer helpermemberid;
	private String username;
	@Column(columnDefinition = "varchar(512)")
	private String helperphoto;
	@Column(columnDefinition = "varchar(512)")
	private String helpercvlink;
	private String account;

	public helpercv() {
	}

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public helpercv(Integer helpermemberid, String username, String helperphoto, String helpercvlink, String account) {
		super();
		this.helpermemberid = helpermemberid;
		this.username = username;
		this.helperphoto = helperphoto;
		this.helpercvlink = helpercvlink;
		this.account = account;
	}

	public String getHelpercvlink() {
		return helpercvlink;
	}

	public void setHelpercvlink(String helpercvlink) {
		this.helpercvlink = helpercvlink;
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

	public String getHelperphoto() {
		return helperphoto;
	}

	public void setHelperphoto(String helperphoto) {
		this.helperphoto = helperphoto;
	}

}
