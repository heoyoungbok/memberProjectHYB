package com.its.member.controller;

import com.its.member.dto.BoardDTO;
import com.its.member.dto.PageDTO;
import com.its.member.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping("/board")
public class BoardController {
@Autowired
private BoardService boardService;


    @GetMapping("/save")
    public String saveForm(){
        return "boardSave";
    }

    @PostMapping("/save")
    public String boardSave(@ModelAttribute BoardDTO boardDTO) throws IOException {
        boardService.boardSave(boardDTO);
        return "redirect:/board/";
    }
    @GetMapping("/")
    public String findAll(Model model){
        List<BoardDTO> boardList = boardService.findAll();
        model.addAttribute("boardList",boardList);
        return "boardList";
    }

    @GetMapping("/paging")
    public String paging(@RequestParam(value = "page",required = false,defaultValue = "1") Model model,int page){
        List<BoardDTO> pagingList = boardService.pagingList(page);
        PageDTO pageDTO = boardService.PagingParam(page);
        model.addAttribute("boardList",pagingList);
        model.addAttribute("paging",pageDTO);
        return "boardPaging";
    }


}
