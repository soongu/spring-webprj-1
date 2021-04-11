package com.myapp.webprj.reply.mapper;

import com.myapp.webprj.common.Criteria;
import com.myapp.webprj.reply.domain.Reply;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface ReplyMapper {

    //댓글 입력
    int insert(Reply reply);

    //댓글 조회
    Reply read(Long rno);

    //댓글 삭제
    public int delete(Long rno);

    //댓글 수정
    public int update(Reply reply);

    //댓글 목록 조회
    public List<Reply> getListWithPaging(@Param("cri") Criteria cri, @Param("bno") Long bno);

    //댓글 개수 조회
    public int getCountByBno(Long bno);
}
