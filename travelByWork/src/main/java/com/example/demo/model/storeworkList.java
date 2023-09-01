package com.example.demo.model;

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
@Table(name="storeworklist")
public class storeworkList {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer storeworklistid;
	private String location;
	@Temporal(TemporalType.TIMESTAMP)
	private Date workupdatetime;
	private String workage;
	private String worksexual;
	private String howtoapply;
	private String others;
	private String changedatebegin;
	private String changedateeend;
	private String aleastdays;
	private String breaktime;
	private String workhours;
	private String atwhattime;
	private String workdetails;
	private String scooters;
	private String meals;
	private String money;
	private String workbonus;
	private Integer storememberid;
	@Column(name="storename")
	private String storeName;
	@Column(name="ownername")
	private String ownerName;
	private String email;
	private String mobile;
	private String phone;
	private String address;
	
	
	public storeworkList() {
		super();
		// TODO Auto-generated constructor stub
	}
	public storeworkList(Integer storeworklistid, String location, Date workupdatetime, String workage,
			String worksexual, String howtoapply, String others, String changedatebegin, String changedateeend,
			String aleastdays, String breaktime, String workhours, String atwhattime, String workdetails,
			String scooters, String meals, String money, String workbonus, Integer storememberid, String storeName,
			String ownerName, String email, String mobile, String phone, String address) {
		super();
		this.storeworklistid = storeworklistid;
		this.location = location;
		this.workupdatetime = workupdatetime;
		this.workage = workage;
		this.worksexual = worksexual;
		this.howtoapply = howtoapply;
		this.others = others;
		this.changedatebegin = changedatebegin;
		this.changedateeend = changedateeend;
		this.aleastdays = aleastdays;
		this.breaktime = breaktime;
		this.workhours = workhours;
		this.atwhattime = atwhattime;
		this.workdetails = workdetails;
		this.scooters = scooters;
		this.meals = meals;
		this.money = money;
		this.workbonus = workbonus;
		this.storememberid = storememberid;
		this.storeName = storeName;
		this.ownerName = ownerName;
		this.email = email;
		this.mobile = mobile;
		this.phone = phone;
		this.address = address;
	}
	public Integer getStorememberid() {
		return storememberid;
	}
	public void setStorememberid(Integer storememberid) {
		this.storememberid = storememberid;
	}
	public String getStoreName() {
		return storeName;
	}
	public void setStoreName(String storeName) {
		this.storeName = storeName;
	}
	public String getOwnerName() {
		return ownerName;
	}
	public void setOwnerName(String ownerName) {
		this.ownerName = ownerName;
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
	
	public Integer getStoreworklistid() {
		return storeworklistid;
	}
	public void setStoreworklistid(Integer storeworklistid) {
		this.storeworklistid = storeworklistid;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public Date getWorkupdatetime() {
		return workupdatetime;
	}
	public void setWorkupdatetime(Date workupdatetime) {
		this.workupdatetime = workupdatetime;
	}
	public String getWorkage() {
		return workage;
	}
	public void setWorkage(String workage) {
		this.workage = workage;
	}
	public String getWorksexual() {
		return worksexual;
	}
	public void setWorksexual(String worksexual) {
		this.worksexual = worksexual;
	}
	public String getHowtoapply() {
		return howtoapply;
	}
	public void setHowtoapply(String howtoapply) {
		this.howtoapply = howtoapply;
	}
	public String getOthers() {
		return others;
	}
	public void setOthers(String others) {
		this.others = others;
	}
	public String getChangedatebegin() {
		return changedatebegin;
	}
	public void setChangedatebegin(String changedatebegin) {
		this.changedatebegin = changedatebegin;
	}
	public String getChangedateeend() {
		return changedateeend;
	}
	public void setChangedateeend(String changedateeend) {
		this.changedateeend = changedateeend;
	}
	public String getAleastdays() {
		return aleastdays;
	}
	public void setAleastdays(String aleastdays) {
		this.aleastdays = aleastdays;
	}
	public String getBreaktime() {
		return breaktime;
	}
	public void setBreaktime(String breaktime) {
		this.breaktime = breaktime;
	}
	public String getWorkhours() {
		return workhours;
	}
	public void setWorkhours(String workhours) {
		this.workhours = workhours;
	}
	public String getAtwhattime() {
		return atwhattime;
	}
	public void setAtwhattime(String atwhattime) {
		this.atwhattime = atwhattime;
	}
	public String getWorkdetails() {
		return workdetails;
	}
	public void setWorkdetails(String workdetails) {
		this.workdetails = workdetails;
	}
	public String getScooters() {
		return scooters;
	}
	public void setScooters(String scooters) {
		this.scooters = scooters;
	}
	public String getMeals() {
		return meals;
	}
	public void setMeals(String meals) {
		this.meals = meals;
	}
	public String getMoney() {
		return money;
	}
	public void setMoney(String money) {
		this.money = money;
	}
	public String getWorkbonus() {
		return workbonus;
	}
	public void setWorkbonus(String workbonus) {
		this.workbonus = workbonus;
	}
	@Override
	public String toString() {
		return "storeworkList [storeworklistid=" + storeworklistid + ", location=" + location + ", workupdatetime="
				+ workupdatetime + ", workage=" + workage + ", worksexual=" + worksexual + ", howtoapply=" + howtoapply
				+ ", others=" + others + ", changedatebegin=" + changedatebegin + ", changedateeend=" + changedateeend
				+ ", aleastdays=" + aleastdays + ", breaktime=" + breaktime + ", workhours=" + workhours
				+ ", atwhattime=" + atwhattime + ", workdetails=" + workdetails + ", scooters=" + scooters + ", meals="
				+ meals + ", money=" + money + ", workbonus=" + workbonus + ", storememberid=" + storememberid
				+ ", storeName=" + storeName + ", ownerName=" + ownerName + ", email=" + email + ", mobile=" + mobile
				+ ", phone=" + phone + ", address=" + address + "]";
	}
	
	

}