package com.its.member.service;

import com.its.member.dto.MemberDTO;
import com.its.member.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MemberService {
    @Autowired
    private MemberRepository memberRepository;

    public boolean save(MemberDTO memberDTO) {
     int result = memberRepository.save(memberDTO);
     if (result > 0){
         return  true;
     }else {
         return false;
     }
    }

    public String joinCheck(String memberEmail) {
        String checkResult = memberRepository.joinCheck(memberEmail);
        if(checkResult == null){
            return "ok";
        }else {
            return "no";
        }
    }

    public boolean login(String memberEmail,String memberPassword) {
        MemberDTO memberDTO = memberRepository.login(memberEmail, memberPassword);
        if(memberDTO != null) {
            return true;
        } else {
            return false;
        }
    }
    public boolean login(MemberDTO memberDTO) {
        MemberDTO member = memberRepository.login(memberDTO);
        if (member != null){
            return true;
        }else {
            return false;
        }
    }




}

