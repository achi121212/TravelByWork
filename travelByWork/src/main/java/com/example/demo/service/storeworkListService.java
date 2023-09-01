package com.example.demo.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.storeworkListDao;
import com.example.demo.model.storeworkList;

@Service //oli
public class storeworkListService {
    @Autowired
    private storeworkListDao slDao;

    public List<storeworkList> getAllStoreworkList() {
        return slDao.findAll();
    }

    public String addsl(storeworkList sl) {
        sl.setWorkupdatetime(new Date());
        slDao.save(sl);
        return "新增成功"; 
    }
}
