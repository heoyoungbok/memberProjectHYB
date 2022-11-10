package com.its.member.controller;

import com.its.member.dto.BoardDTO;
import com.its.member.dto.MemberDTO;
import com.its.member.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class MemberController {
    @Autowired
    private MemberService memberService;

    @GetMapping("/save")
    public String saveForm() {
        return "memberPages/memberSave";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute MemberDTO memberDTO, Model model) {
        boolean memberResult = memberService.save(memberDTO);
        model.addAttribute("memberResult", memberResult);
        return "memberPages/memberLogin";
    }


    @PostMapping("/joinCheck")
    public @ResponseBody String joinCheck(@RequestParam("inputEmail") String memberEmail) {

        String checkResult = memberService.joinCheck(memberEmail);
        return checkResult;
    }

    @GetMapping("/member")
    public String findByEmail(@RequestParam("memberEmail") String memberEmail, Model model) {
        MemberDTO memberDTO = memberService.findByEmail(memberEmail);
        model.addAttribute("member", memberDTO);
        return "memberList";
    }


    @GetMapping("/myPage")
    public String pageForm(HttpSession session, Model model) {
        String memberEmail = (String) session.getAttribute("loginEmail");
        MemberDTO memberDTO = memberService.findByEmail(memberEmail);
        model.addAttribute("member", memberDTO);
        return "myPage";
    }

    @PostMapping("/myPage")
    public String myPage(@ModelAttribute MemberDTO memberDTO, Model model) {
        memberService.myPage(memberDTO);
        MemberDTO dto = memberService.findByEmail(memberDTO.getMemberEmail());
        model.addAttribute("member", dto);
        return "myPage";
    }

    @GetMapping("/memberList")
    public String memberList(Model model) {
        List<MemberDTO> memberList = memberService.memberList();
        model.addAttribute("memberList", memberList);
        return "memberPages/memberList";
    }


    @GetMapping("/delete")
    public String delete(@RequestParam("id")Long id){
        memberService.delete(id);
        return "redirect:/memberList";
    }








}
//    @PostMapping("/memberList")
//    public String memberList(Model model){
//        List<MemberDTO> memberList = memberService.memberList();
//        model.addAttribute("memberList",memberList);
//        return "memberPages/memberList";
//    }
//}
