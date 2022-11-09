package com.its.member.controller;

import com.its.member.dto.BoardDTO;
import com.its.member.dto.CommentDTO;
import com.its.member.dto.PageDTO;
import com.its.member.service.BoardService;
import com.its.member.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


import javax.xml.stream.events.Comment;
import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping("/board")
public class BoardController {
@Autowired
private BoardService boardService;
@Autowired
private CommentService commentService;


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
        return "boardPaging";
    }

    @GetMapping("/paging")
    public String paging(@RequestParam(value = "page",required = false,defaultValue = "1") int page,Model model){
        List<BoardDTO> pagingList = boardService.pagingList(page);
        PageDTO pageDTO = boardService.PagingParam(page);
        model.addAttribute("boardList",pagingList);
        model.addAttribute("paging",pageDTO);
        return "boardPaging";
    }

    @GetMapping
    public String findById(@RequestParam("id") Long id,Model model,
                           @RequestParam(value = "page", required = false,defaultValue = "1")int page){
        boardService.updateHits(id);
        BoardDTO boardDTO = boardService.findById(id);
        model.addAttribute("board",boardDTO);
        model.addAttribute("page",page);
        List<CommentDTO> commentDTOList = commentService.findAll(id);
        model.addAttribute("commentList",commentDTOList);
        return "boardDetail";
    }

    @GetMapping("/update")
    public String updateForm(@RequestParam("id")Long id, Model model){
        BoardDTO boardDTO = boardService.findById(id);
        model.addAttribute("board",boardDTO);
        return "boardUpdate";
    }

    @PostMapping("/update")
    public String update(@ModelAttribute BoardDTO boardDTO, Model model ){
        boardService.update(boardDTO);
        BoardDTO dto = boardService.findById(boardDTO.getId());
        model.addAttribute("board",dto);





        return "boardDetail";


    }



    @GetMapping("deleteCheck")
    public String deleteCheck(@RequestParam("id") Long id, Model model){
        BoardDTO boardDTO = boardService.findById(id);
        model.addAttribute("board",boardDTO);
        return "deleteCheck";
    }

    @GetMapping("/delete")
    public String delete(@RequestParam("id") Long id){
        boardService.delete(id);
        return "redirect:/board/";
    }





}


