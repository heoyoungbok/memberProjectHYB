package com.its.member.controller;

import com.its.member.service.BoardService;
import com.its.member.service.CommentService;
import com.its.member.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class AdminController {
    @Autowired
    private BoardService boardService;
    @Autowired
    private MemberService memberService;
    @Autowired
    private CommentService commentService;






}
