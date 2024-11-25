package com.aloha.board_test_lsj.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.util.UriComponentsBuilder;

import com.aloha.board_test_lsj.dto.Board;
import com.aloha.board_test_lsj.dto.Page;
import com.aloha.board_test_lsj.service.BoardService;

import lombok.extern.slf4j.Slf4j;






@Controller
@RequestMapping("/board")
@Slf4j
public class BoardController {

    @Autowired BoardService boardService;

    
    // 등록
    @GetMapping("/insert")
    public String insert() {
        return "board/insert";
    }

    // 등록 처리
    @PostMapping("/insert")
    public String insert(Board board) {
        boardService.insert(board);
        return "redirect:/board/list";
    }
    
    // 목록
    @GetMapping("/list")
    public String list(Model model, Page page) {
        List<Board> list = boardService.list(page);
        model.addAttribute("list", list);
        model.addAttribute("rows", page.getRows());
        model.addAttribute("page", page);

        return "/board/list";
    }
    
    // 조회
    @GetMapping("/read")
    public String select(@RequestParam("id") String id, Model model) {
        Board board = boardService.select(id);
        model.addAttribute("board", board);
        return "/board/read";
    }
    

    // 수정
    @GetMapping("/update")
    public String update(@RequestParam("id") String id, Model model) {
        Board board = boardService.select(id);
        model.addAttribute("board", board);
        return "/board/update";
    }

    @PostMapping("/update")
    public String update(@RequestParam("id") String id, Board board) {
        boardService.update(board);
        return "redirect:/board/read?id=" + id;
    }
    
    // 삭제
    @GetMapping("/delete")
    public String delete(@RequestParam("id") String id) {
        log.info("아이디id : " + id);
        boardService.delete(id);
        return "/board/list";
    }
    
}
