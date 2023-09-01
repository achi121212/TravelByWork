package com.example.demo.dao;

import com.example.demo.model.HelperMember;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface HelperMemberDao extends JpaRepository<HelperMember,Integer> {
    HelperMember findHelperMemberByAccount(String account);

    HelperMember findHelperMemberByUsername(String username);

    HelperMember findHelperMemberByEmail(String email);

    public boolean existsByAccount(String account);
    public HelperMember findByAccount(String account);
    List<HelperMember> findAll();
}

