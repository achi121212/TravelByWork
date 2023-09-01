package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dao.storeworkListDao;
import com.example.demo.model.storeworkList;
import com.example.demo.service.storeworkListService;

@RestController // oli
public class storeworkListController {
	@Autowired
	private storeworkListService slservice;
	@Autowired
	private storeworkListDao workListDao;

	@GetMapping("/getPostJobs")
	public List<storeworkList> getPostJobs() {
		return slservice.getAllStoreworkList();
	}

	@PostMapping(value = "/createJob")
	public String addsl(@RequestBody storeworkList sl) {
		System.out.println(sl.toString());
		return slservice.addsl(sl);
	}

	@DeleteMapping("/deleteStoreWorkList/{id}")
	public String deletestoreworklist(@PathVariable int id) {
		workListDao.deleteById(id);
		return "刪除成功";
	}

	@GetMapping("/getFavoriteJob/{storeworklistid}")
	public storeworkList getFavoriteJob(@PathVariable int storeworklistid) {
		return workListDao.findById(storeworklistid).get();
	}

	@GetMapping("/getByStoreMemebrId/{storememberid}")
	public List<storeworkList> getByStoreMemebrId(@PathVariable int storememberid) {
		return workListDao.findByStorememberid(storememberid);
	}
}
