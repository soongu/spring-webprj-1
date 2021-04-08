package com.myapp.webprj.board.controller;

import com.myapp.webprj.board.domain.Board;
import com.myapp.webprj.board.service.BoardService;
import com.myapp.webprj.common.Criteria;
import com.myapp.webprj.common.PageMaker;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/board/*")
@Log4j2
public class BoardController {

    private final BoardService boardService;

    //게시물 목록 요청 처리
    @GetMapping("/list")
    public String list(Criteria cri, Model model) {
        log.info("/board/list GET요청 발생!: " + cri);

//        List<Board> list = boardService.getList(cri);
        List<Board> list = boardService.searchList(cri);

        model.addAttribute("list", list);
        model.addAttribute("pageInfo", new PageMaker(cri, boardService.getTotal(cri)));
        return "board/list";
    }

    //게시글 등록 화면 요청 처리
    @GetMapping("/register")
    public String register() {
        log.info("/board/register GET요청!");
        return "board/register";
    }
    //게시글 데이터베이스 저장 요청
    @PostMapping("/register")
    public String register(Board board, RedirectAttributes ra) {
        log.info("/board/register POST요청: " + board);
        boardService.register(board);
        ra.addFlashAttribute("msg", "regSuccess");
        return "redirect:/board/list";
    }

    //게시글 상세조회 요청
    @GetMapping("/get")
    public String get(Long bno, Model model) {
        log.info("/board/get GET요청!: " + bno);
        Board board = boardService.get(bno);
        model.addAttribute("board", board);
        return "board/get";
    }

    //게시글 수정 화면 요청
    @GetMapping("/modify")
    public String modify(Long bno, Model model) {
        log.info("/board/modify GET!: " + bno);
        model.addAttribute("board", boardService.get(bno));
        return "board/modify";
    }

    //게시글 수정 완료처리 요청
    @PostMapping("/modify")
    public String modify(Board board, RedirectAttributes ra) {
        log.info("/board/modify POST!: " + board);
        boolean modify = boardService.modify(board);
        if (modify) {
            ra.addFlashAttribute("msg", "modSuccess");
        }
        return "redirect:/board/list";
    }

    //게시글 삭제 완료처리 요청
    @PostMapping("/remove")
    public String remove(Long bno, RedirectAttributes ra) {
        log.info("/board/remove POST!: " + bno);
        boolean remove = boardService.remove(bno);
        if (remove) {
            ra.addFlashAttribute("msg", "delSuccess");
        }
        return "redirect:/board/list";
    }
}
