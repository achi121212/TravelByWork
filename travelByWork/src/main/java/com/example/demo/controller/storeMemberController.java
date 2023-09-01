package com.example.demo.controller;

import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.dao.storeMemberDao;
import com.example.demo.model.StoreMember;
import com.example.demo.service.storeMemberService;

@RestController
public class storeMemberController {

	@Autowired
	private storeMemberDao dao;
	@Autowired
	private storeMemberService service;

	// 註冊資料加入資料庫
	@PostMapping("/storesignup")
	public String signup(@RequestBody StoreMember member, HttpSession session) {
		return service.addmember(member, session);
	}

	// 登入
	@GetMapping("/storelogin")
	public String loginQuery(HttpSession session, @RequestParam(value = "account") String account,@RequestParam(value = "password") String password) {
		return service.getByAccountAndPassword(session, account, password);
	}

	// 更新會員資料
	@PostMapping("/storeupdata")
	public String updateData(@RequestBody StoreMember member, HttpSession session) {
		return service.UpdateStoreData(member,session);
	}

	// 刪除storemember
	@DeleteMapping("/deleteStoreMemebr/{id}")
	public String deleteStoreMemebr(@PathVariable int id) {
		dao.deleteById(id);
		return "刪除成功";
	}


}
