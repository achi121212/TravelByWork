package com.example.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.helpercv;

public interface helpercvDao extends JpaRepository<helpercv,Integer>{

	public helpercv findByHelpermemberid(Integer helpermemberid);
	public helpercv findByUsername(String usename);
	public helpercv findByAccount(String account);
}
