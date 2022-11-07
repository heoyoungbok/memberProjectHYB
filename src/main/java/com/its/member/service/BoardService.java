package com.its.member.service;

import com.its.member.dto.BoardDTO;
import com.its.member.repository.BoardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.List;

@Service
public class BoardService {
    @Autowired
    private BoardRepository boardRepository;

    public void boardSave(BoardDTO boardDTO) throws IOException {
        if(!boardDTO.getBoardFile().isEmpty()){
            MultipartFile boardFile = boardDTO.getBoardFile();
            String originalFilename = boardFile.getOriginalFilename();
            String storedFileName = System.currentTimeMillis() + "-" + originalFilename;
            String savePath = "C:\\spring_img1\\"+storedFileName;
            boardFile.transferTo(new File(savePath));
            boardDTO.setFileAttached(1);
            BoardDTO savedBoard = boardRepository.boardSave(boardDTO);
            boardRepository.saveFileName(savedBoard);
        } else {
            boardDTO.setFileAttached(0);
        }   boardRepository.boardSave(boardDTO);
    }

    public List<BoardDTO> findAll() {
        List<BoardDTO> boardDTOList = boardRepository.findAll();
        return  boardDTOList;
    }
}
