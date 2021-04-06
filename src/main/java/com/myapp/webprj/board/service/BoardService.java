package com.myapp.webprj.board.service;

import com.myapp.webprj.board.domain.Board;

import java.util.List;

public interface BoardService {

    //게시글 등록과정
    void register(Board board);

    //게시글 상세조회 과정
    Board get(Long bno);

    //게시글 수정 과정
    boolean modify(Board board);

    //게시글 삭제 과정
    boolean remove(Long bno);

    //게시물 전체 조회 과정
    List<Board> getList();
}
