package com.myapp.webprj.board.mapper;

import com.myapp.webprj.board.domain.Board;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface BoardMapper {

    //글 전체 목록조회
    List<Board> getList();

    //글 상세 조회
    Board findByBno(Long bno);

    //글 쓰기 기능
    void save(Board board);

    //글 수정 기능
    int update(Board board);

    //글 삭제 기능
    int delete(Long bno);
}
