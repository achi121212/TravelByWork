package com.example.demo.service;

import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.dao.storeMemberDao;
import com.example.demo.model.StoreMember;

@Service
public class storeMemberService {

	@Autowired
	private storeMemberDao dao;
	

	//判斷資料有無重複
	public Boolean queryDataExisted(StoreMember member) {	
		boolean accountExist=dao.existsByAccount(member.getAccount());
		boolean nameExist=dao.existsByStorename(member.getStorename());
		boolean emailExist=dao.existsByEmail(member.getEmail());
		boolean mobileExist=dao.existsByMobile(member.getMobile());
		if(accountExist || nameExist || emailExist || mobileExist ) {
			return true;
		}
		return false;	
	}
	//註冊店家資料加入資料庫
	public String addmember(StoreMember member,HttpSession session) {
		boolean b=queryDataExisted(member);
		if(b){ 
			return "新增失敗，資料重複";
		}else {
			session.setAttribute("newMember", member);
			dao.save(member);
			return "新增成功";
		}
	}
	//判斷登入的帳號密碼
	public String getByAccountAndPassword(HttpSession session,String account,String password) {
		StoreMember member=dao.findByAccountAndPassword(account, password);
		if(member!=null) {	
			session.setAttribute("storeMember", member);
			return "登入成功";
		}
		return "查無此會員";
	}
	//更新資料
	public String UpdateStoreData(StoreMember member,HttpSession session) {
		System.out.println(member.toString());
		dao.save(member);
		session.setAttribute("storeMember", member);
		return "修改成功";
	}

}
