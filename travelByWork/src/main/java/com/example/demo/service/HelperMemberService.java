package com.example.demo.service;

import com.example.demo.dao.HelperMemberDao;
import com.example.demo.model.HelperMember;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class HelperMemberService {
    @Autowired
    private HelperMemberDao helperMemberDao;


    public Integer createHelperMember(HelperMember helperMember) {
        Integer createdId = helperMemberDao.save(helperMember).getHelpermemberid();
        return createdId;
    }
   public HelperMember getHelperMemberByAccount(String account) {
        HelperMember helperMember = helperMemberDao.findHelperMemberByAccount(account);
        if (helperMember != null) {
            return helperMember;
        } else {
            return null;
        }
    }


    public HelperMember getHelperMemberByUsername(String username) {
        HelperMember helperMember = helperMemberDao.findHelperMemberByUsername(username);
        if (helperMember != null) {
            return helperMember;
        } else {
            return null;
        }
    }


    public HelperMember getHelperMemberByEmail(String email) {
        HelperMember helperMember = helperMemberDao.findHelperMemberByEmail(email);
        if (helperMember != null) {
            return helperMember;
        } else {
            return null;
        }
    }


    public List<HelperMember> findAll() {

        return helperMemberDao.findAll();
    }
}
