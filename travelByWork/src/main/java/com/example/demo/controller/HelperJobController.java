package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dao.HelperJobDao;
import com.example.demo.model.HelperJob;

@RestController
public class HelperJobController {

	@Autowired
	private HelperJobDao dao;
	
	//從小幫手id取得資料
	@GetMapping("/getJobByHelperId/{helpermemberid}")
	public List<HelperJob> getJobByHelperId(@PathVariable int helpermemberid){
		return dao.findByHelpermemberid(helpermemberid);
	}
	//從storeworklistid取得 被 收藏數量
	@GetMapping("/getJobByWorkListIdSize/{storeworklistid}")
	public Integer getJobByWorkListIdSize(@PathVariable int storeworklistid){
		return dao.findByStoreworklistid(storeworklistid).size();
	}
	//從storeworklistid取得資料
	@GetMapping("/getJobByWorkListId/{storeworklistid}")
	public List<HelperJob> getJobByWorkListId(@PathVariable int storeworklistid){
		return dao.findByStoreworklistid(storeworklistid);
	}
	//新增資料
	@PostMapping("/addHelperJob")
	public String addHelperJob(@RequestBody HelperJob job) {
		dao.save(job);
		return "新增成功";
	}
	//delete
	@DeleteMapping("/deleteFavorite/{id}")
	public String deleteFavorite(@PathVariable int id) {
		dao.deleteById(id);
		return "刪除成功";
	}
}
