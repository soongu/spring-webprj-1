package com.myapp.webprj.board.service;

import com.myapp.webprj.board.domain.Board;
import com.myapp.webprj.board.mapper.BoardMapper;
import com.myapp.webprj.common.Criteria;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BoardServiceImpl implements BoardService {

    private final BoardMapper boardMapper;

    @Override
    public void register(Board board) {
        boardMapper.save(board);
    }

    @Override
    public Board get(Long bno) {
        return boardMapper.findByBno(bno);
    }

    @Override
    public boolean modify(Board board) {
        return boardMapper.update(board) == 1;
    }

    @Override
    public boolean remove(Long bno) {
        return boardMapper.delete(bno) == 1;
    }

    @Override
    public List<Board> getList(Criteria cri) {
        return boardMapper.getListWithPaging(cri);
    }

    @Override
    public int getTotal() {
        return boardMapper.getTotalCount();
    }
}
