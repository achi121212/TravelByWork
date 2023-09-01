package com.example.demo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.storeworkList;

@Repository //oli
public interface storeworkListDao extends JpaRepository<storeworkList, Integer> {
    // 用storememberid找資料
	public List<storeworkList> findByStorememberid(int storememberid);
	
}
