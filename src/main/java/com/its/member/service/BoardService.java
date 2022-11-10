package com.its.member.service;

import com.its.member.commons.PagingConst;
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
        System.out.println("파일있음");
        if(!boardDTO.getBoardFile().isEmpty()){
            MultipartFile boardFile = boardDTO.getBoardFile();//1
            String originalFilename = boardFile.getOriginalFilename();//2
            System.out.println("originalFilename = " + originalFilename);
            System.out.println(System.currentTimeMillis());
            String storedFileName = System.currentTimeMillis() + "-" + originalFilename;//3
            System.out.println("storedFileName = " + storedFileName);
            boardDTO.setOriginalFileName(originalFilename);
            boardDTO.setStoredFileName(storedFileName); //4
            String savePath = "C:\\spring_img1\\"+storedFileName; //5
            boardFile.transferTo(new File(savePath));//6
            boardDTO.setFileAttached(1);
            BoardDTO savedBoard = boardRepository.boardSave(boardDTO); //7
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

    public void updateHits(Long id) {
        boardRepository.updateHits(id);
    }

    public BoardDTO findById(Long id) {
        return boardRepository.findById(id);
    }

    public void update(BoardDTO boardDTO) {
        boardRepository.update(boardDTO);
    }

    public void delete(Long id) {
        boardRepository.delete(id);
    }

    public List<BoardDTO> search(String type, String q) {
        Map<String,String> searchParams = new HashMap<>();
        searchParams.put("type",type);
        searchParams.put("q",q);
        List<BoardDTO> searchList = boardRepository.search(searchParams);
        return searchList;
    }
}
