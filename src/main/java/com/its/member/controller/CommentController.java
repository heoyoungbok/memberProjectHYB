package com.its.member.controller;

import com.its.member.dto.CommentDTO;
import com.its.member.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
@RequestMapping("/comment")
@Controller
public class CommentController {
@Autowired
    private CommentService commentService;

    @PostMapping("/save")
    public @ResponseBody List<CommentDTO> commentSave(CommentDTO commentDTO){
        commentService.commentSave(commentDTO);
      List<CommentDTO> commentDTOList = commentService.findAll(commentDTO.getBoardId());
    return commentDTOList;
    }


}
