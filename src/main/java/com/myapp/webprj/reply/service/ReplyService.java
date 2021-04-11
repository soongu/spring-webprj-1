package com.myapp.webprj.reply.service;

import com.myapp.webprj.common.Criteria;
import com.myapp.webprj.reply.domain.Reply;

import java.util.List;

public interface ReplyService {

    int register(Reply reply);

    Reply get(Long rno);

    int modify(Reply reply);

    int remove(Long rno);

    List<Reply> getList(Criteria cri, Long bno);
}
