package com.example.demo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.HelperJob;

public interface HelperJobDao extends JpaRepository<HelperJob,Integer> {

	List<HelperJob> findByHelpermemberid(int helpermemberid);
	List<HelperJob> findByStoreworklistid(int storeworklistid);
}
