package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.dao.helpercvDao;
import com.example.demo.model.helpercv;


@RestController
public class helperShareController {

    @Autowired
    private helpercvDao helpercvdao;
  
    //更新or新增履歷、大頭貼
	@PostMapping("/updatehelpercv")
	public String updateHelpercv(@RequestBody helpercv cv) {
		System.out.println(cv.toString());
		helpercvdao.save(cv);
		return "成功";
	}
    //刪除helpercv
	@DeleteMapping("/deleteHelpercv/{id}")
    public String deleteHelperCV(@PathVariable int id) {
		helpercvdao.deleteById(id);
    	return "刪除成功";
    }
}