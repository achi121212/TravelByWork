package com.example.demo.controller;

import com.example.demo.dao.HelperMemberDao;
import com.example.demo.dao.helpercvDao;
import com.example.demo.model.HelperMember;
import com.example.demo.model.StoreMember;
import com.example.demo.model.helpercv;
import com.example.demo.service.HelperMemberService;
import com.example.demo.service.storeMemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class HelperMemberController {

    @Autowired
    private HelperMemberService helperMemberService;
    @Autowired
	private helpercvDao helpercvdao;
    @Autowired
    private HelperMemberDao dao;
   
    @PostMapping("/googleLogin")
    public String googlelogin(@RequestBody HelperMember helperMember,HttpSession session) {

    	HelperMember member=helperMemberService.getHelperMemberByEmail(helperMember.getEmail());
    	if(member==null) {
    		helperMemberService.createHelperMember(helperMember);
    		HelperMember newMember=helperMemberService.getHelperMemberByAccount(helperMember.getAccount());
    		Map<String, Object> userMap = new HashMap<>();
            userMap.put("helperMember", newMember);
    		session.setAttribute("user",userMap);
            session.setMaxInactiveInterval(60);
        	return "成功";
    	}else {
    		helpercv helpercv=helpercvdao.findByAccount(helperMember.getAccount());
            Map<String, Object> userMap = new HashMap<>();
            userMap.put("helpercv", helpercv);
            userMap.put("helperMember", member);
    		session.setAttribute("user",userMap);
            session.setMaxInactiveInterval(60);
    		return "成功";
    	}
    }
    @GetMapping("/getGoogleSession")
    public ResponseEntity<Object> getGoogleSession(HttpSession session) {
        return ResponseEntity.status(HttpStatus.OK).body(session.getAttribute("user"));
    }

    //刪除helperMember
    @DeleteMapping("/deleteHelperMemebr/{id}")
    public String deleteHelperMemebr(@PathVariable int id) {
    	dao.deleteById(id);
    	return "刪除成功";
    }

}