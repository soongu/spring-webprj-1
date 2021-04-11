package com.myapp.webprj.reply.mapper;

import com.myapp.webprj.board.domain.Board;
import com.myapp.webprj.board.mapper.BoardMapper;
import com.myapp.webprj.common.Criteria;
import com.myapp.webprj.reply.domain.Reply;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

//자동주입을 받을 수 있음.
@SpringBootTest
class ReplyMapperTest {

    @Autowired
    private ReplyMapper mapper;

    @Test
    void repInsertTest() {
        for (int i = 1; i <= 20; i++) {
            Reply reply = new Reply();
            reply.setBno(1L);
            reply.setReply("테스트댓글"+i);
            reply.setReplyer("테스터" + i);

            mapper.insert(reply);
        }
    }

    @Test
    void repReadTest() {
        Reply reply = mapper.read(15L);
        System.out.println("reply = " + reply);
    }

    @Test
    void repDeleteTest() {

        mapper.delete(20L);
    }

    @Test
    void repModifyTest() {
        Reply read = mapper.read(10L);
        read.setReply("수정한 댓글");

        mapper.update(read);
    }

    @Test
    void repListTest() {
        List<Reply> list = mapper.getListWithPaging(new Criteria(), 1L);
        for (Reply reply : list) {
            System.out.println("reply = " + reply);
        }
    }

}