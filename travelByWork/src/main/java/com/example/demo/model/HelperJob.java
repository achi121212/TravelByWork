package com.example.demo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="helperjob")
public class HelperJob {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer helperjobid;
	private Integer helpermemberid;
	private Integer storeworklistid;
	private Boolean favorite;		//收藏

	public HelperJob(Integer helperjobid, Integer helpermemberid, Integer storeworklistid, Boolean favorite) {
		super();
		this.helperjobid = helperjobid;
		this.helpermemberid = helpermemberid;
		this.storeworklistid = storeworklistid;
		this.favorite = favorite;
	}
	public HelperJob() {
		super();
	}
	public Integer getHelperjobid() {
		return helperjobid;
	}
	public void setHelperjobid(Integer helperjobid) {
		this.helperjobid = helperjobid;
	}
	public Integer getHelpermemberid() {
		return helpermemberid;
	}
	public void setHelpermemberid(Integer helpermemberid) {
		this.helpermemberid = helpermemberid;
	}
	public Boolean getFavorite() {
		return favorite;
	}
	public void setFavorite(Boolean favorite) {
		this.favorite = favorite;
	}
	public Integer getStoreworklistid() {
		return storeworklistid;
	}
	public void setStoreworklistid(Integer storeworklistid) {
		this.storeworklistid = storeworklistid;
	}
	
	
}
