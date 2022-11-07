package com.its.member.repository;

import com.its.member.dto.BoardDTO;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class BoardRepository {
    @Autowired
    private SqlSessionTemplate sql;

    public BoardDTO boardSave(BoardDTO boardDTO) {
     sql.insert("Board.boardSave",boardDTO);
     return boardDTO;
    }

    public void saveFileName(BoardDTO boardDTO) {
        sql.insert("Board.saveFile",boardDTO);
    }

    public List<BoardDTO> findAll() {
       return sql.selectList("Board.findAll");
    }
}
