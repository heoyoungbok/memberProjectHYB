package com.its.member.repository;

import com.its.member.dto.MemberDTO;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class MemberRepository {
    @Autowired
    private SqlSessionTemplate sql;


    public int save(MemberDTO memberDTO) {
        return sql.insert("Member.save",memberDTO);
    }

    public String joinCheck(String memberEmail) {
        return sql.selectOne("Member.joinCheck",memberEmail);
    }

    public MemberDTO login(String memberEmail,String memberPassword){
        MemberDTO member = new MemberDTO();
        member.setMemberEmail(memberEmail);
        member.setMemberPassword(memberPassword);
        return sql.selectOne("Member.login",member);
    }
    public MemberDTO login(MemberDTO memberDTO) {
        return sql.selectOne("Member.login",memberDTO);
    }


    public MemberDTO findByEmail(String memberEmail) {
        return sql.selectOne("Member.findByEmail",memberEmail);
    }

    public void myPage(MemberDTO memberDTO) {
        sql.update("Member.myPage",memberDTO);
    }
}

