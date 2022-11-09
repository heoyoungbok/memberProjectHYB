package com.its.member.service;

import com.its.member.dto.CommentDTO;
import com.its.member.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentService {
    @Autowired
    private CommentRepository commentRepository;

    public List<CommentDTO> commentSave(CommentDTO commentDTO){
        return  commentRepository.commentSave(commentDTO);
    }
    public List<CommentDTO> findAll(Long boardId) {
        return commentRepository.findAll(boardId);
    }
}
