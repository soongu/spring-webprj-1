package com.myapp.webprj.reply.service;

import com.myapp.webprj.common.Criteria;
import com.myapp.webprj.reply.domain.Reply;
import com.myapp.webprj.reply.mapper.ReplyMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ReplyServiceImpl implements ReplyService {

    private final ReplyMapper replyMapper;

    @Override
    public int register(Reply reply) {
        return replyMapper.insert(reply);
    }

    @Override
    public Reply get(Long rno) {
        return replyMapper.read(rno);
    }

    @Override
    public int modify(Reply reply) {
        return replyMapper.update(reply);
    }

    @Override
    public int remove(Long rno) {
        return replyMapper.delete(rno);
    }

    @Override
    public List<Reply> getList(Criteria cri, Long bno) {
        return replyMapper.getListWithPaging(cri, bno);
    }
}
