package com.java.JAM.service;

import com.java.JAM.dao.MemberDao;

import java.sql.Connection;

public class MemberService {

    private MemberDao memberDao;

    public MemberService(Connection conn) {
        this.memberDao = new MemberDao(conn);
    }

    public boolean isLoginIdDup(String loginId) {
        return memberDao.isLoginIdDup(loginId);
    }

    public void doJoin(String loginId, String loginPw, String name) {
        memberDao.doJoin(loginId, loginPw, name);
    }

}