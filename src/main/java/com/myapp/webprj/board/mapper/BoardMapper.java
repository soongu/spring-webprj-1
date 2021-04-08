package com.myapp.webprj.board.mapper;

import com.myapp.webprj.board.domain.Board;
import com.myapp.webprj.common.Criteria;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface BoardMapper {

    //글 전체 목록조회
    List<Board> getList();

    //글 목록조회(페이징 처리)
    List<Board> getListWithPaging(Criteria cri);
    //총 게시물 수 조회
    int getTotalCount();

    //제목으로 검색
    List<Board> getListByTitle(Criteria cri);
    //제목으로 검색게시물 수 조회
    int getTotalCountByTitle(Criteria cri);

    //검색처리 통합 조회
    List<Board> getSearchList(Criteria cri);
    int getSearchTotalCount(Criteria cri);

    //글 상세 조회
    Board findByBno(Long bno);

    //글 쓰기 기능
    void save(Board board);

    //글 수정 기능
    int update(Board board);

    //글 삭제 기능
    int delete(Long bno);
}
