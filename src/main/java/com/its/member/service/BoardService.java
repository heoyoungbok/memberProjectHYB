package com.its.member.service;

import com.its.member.commos.PagingConst;
import com.its.member.dto.BoardDTO;
import com.its.member.dto.PageDTO;
import com.its.member.repository.BoardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    public List<BoardDTO> pagingList(int page) {
        int pagingStart=(page-1) * PagingConst.PAGE_LIMIT;
        Map<String,Integer> pagingParams = new HashMap<>();
        pagingParams.put("start",pagingStart);
        pagingParams.put("limit",PagingConst.PAGE_LIMIT);
        List<BoardDTO> pagingList = boardRepository.pagingList(pagingParams);
        return  pagingList;

    }

    public PageDTO PagingParam(int page) {
        int boardCount = boardRepository.boardCount();
        int maxPage = (int) (Math.ceil((double) boardCount / PagingConst.PAGE_LIMIT));
        int startPage = (((int) (Math.ceil((double) page /  PagingConst.BLOCK_LIMIT)))-1) *PagingConst.BLOCK_LIMIT+1;
        int endPage = startPage + PagingConst.BLOCK_LIMIT -1;
        if (endPage > maxPage){
            endPage = maxPage;
        }
        PageDTO pageDTO = new PageDTO();
        pageDTO.setPage(page);
        pageDTO.setMaxPage(maxPage);
        pageDTO.setStartPage(startPage);
        pageDTO.setEndPage(endPage);
        return pageDTO;
    }
}
