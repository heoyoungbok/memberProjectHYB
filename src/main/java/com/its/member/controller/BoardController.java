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
        return "boardPages/boardSave";
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String boardSave(@ModelAttribute BoardDTO boardDTO) throws IOException {
        System.out.println("BoardController.boardSave");
        boardService.boardSave(boardDTO);
        System.out.println("save완료");
        return "redirect:/board/";
    }
    @GetMapping("/")
    public String findAll(Model model){
        List<BoardDTO> boardList = boardService.findAll();
        model.addAttribute("boardList",boardList);
        return "boardPages/boardPaging";
    }

    @GetMapping("/paging")
    public String paging(@RequestParam(value = "page",required = false,defaultValue = "1") int page,Model model){
        List<BoardDTO> pagingList = boardService.pagingList(page);
        PageDTO pageDTO = boardService.PagingParam(page);
        model.addAttribute("boardList",pagingList);
        model.addAttribute("paging",pageDTO);
        return "boardPages/boardPaging";
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
        return "boardPages/boardDetail";
    }

    @GetMapping("/update")
    public String updateForm(@RequestParam("id")Long id, Model model){
        BoardDTO boardDTO = boardService.findById(id);
        model.addAttribute("board",boardDTO);
        return "boardPages/boardUpdate";
    }

    @PostMapping("/update")
    public String update(@ModelAttribute BoardDTO boardDTO, Model model ){
        boardService.update(boardDTO);
        BoardDTO dto = boardService.findById(boardDTO.getId());
        model.addAttribute("board",dto);

        return "boardPages/boardDetail";


    }



    @GetMapping("deleteCheck")
    public String deleteCheck(@RequestParam("id") Long id, Model model){
        BoardDTO boardDTO = boardService.findById(id);
        model.addAttribute("board",boardDTO);
        return "boardPages/deleteCheck";
    }

    @GetMapping("/delete")
    public String delete(@RequestParam("id") Long id){
        boardService.delete(id);
        return "redirect:/board/";
    }



    @GetMapping("/search")
    public String search(@RequestParam("type")String type,
                          @RequestParam("q") String q, Model model){
        System.out.println("type = " + type + ", q = " + q + ", model = " + model); // 중간출력확인
        List<BoardDTO> searchList = boardService.search(type, q);
        model.addAttribute("boardList",searchList); //  보드리스트 파라미터
        System.out.println("searchList = " + searchList); //
        return "boardPages/boardPaging";
    }
}


