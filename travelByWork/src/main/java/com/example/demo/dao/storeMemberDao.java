package com.example.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.StoreMember;

@Repository
public interface storeMemberDao extends JpaRepository<StoreMember, Integer> {

	public boolean existsByAccount(String account);

	public boolean existsByEmail(String email);

	public boolean existsByStorename(String name);

	public boolean existsByMobile(String mobile);

	public StoreMember findByAccountAndPassword(String account, String password);

	StoreMember findStoreMemberByAccount(String account);

	StoreMember findStoreMemberByEmail(String email);
}
