package com.its.member.repository;

import com.its.member.dto.CommentDTO;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CommentRepository {
    @Autowired
    private SqlSessionTemplate sql;
    public List<CommentDTO> commentSave(CommentDTO commentDTO){
        return sql.selectList("Comment.commentSave",commentDTO);

    }

    public List<CommentDTO>findAll(Long boardId){
        return sql.selectList("Comment.findAll",boardId);
    }

}
