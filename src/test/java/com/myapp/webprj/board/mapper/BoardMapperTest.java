package com.myapp.webprj.board.mapper;

import com.myapp.webprj.board.domain.Board;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

//자동주입을 받을 수 있음.
@SpringBootTest
class BoardMapperTest {

    @Autowired
    private BoardMapper mapper;

    @Test
    @DisplayName("데이터베이스에서 게시글 전체를 조회할 수 있어야 한다.")
    void findAllTest() {

        //when
        List<Board> boardList = mapper.getList();

        //then
        assertTrue(boardList.size() == 5);

        System.out.println("=============================");
        for (Board board : boardList) {
            System.out.println(board);
        }
        System.out.println("=============================");
    }

    @Test
    @DisplayName("데이터베이스 저장에 성공해야 한다.")
    void insertTest() {

        //given
        Board newArticle = new Board();
        newArticle.setTitle("아기공룡 둘리");
        newArticle.setContent("꿀잼 만화입니다. 하하호호~");
        newArticle.setWriter("고길동");

        //when
        mapper.save(newArticle);

        //then
        assertTrue(mapper.getList().get(0).getBno() == 6);
    }

    @Test
    @DisplayName("글 번호를 전달하면 해당 글 정보를 얻어야 한다.")
    void findOneTest() {
        Board board = mapper.findByBno(5L);
        System.out.println("board = " + board);

        assertTrue(board.getBno() == 5);
    }

    @Test
    @DisplayName("글내용, 글제목, 작성자를 수정할 수 있어야 한다.")
    void updateTest() {
        //given
        Board newBoard = new Board();
        newBoard.setBno(3L);
        newBoard.setWriter("도우너");
        newBoard.setContent("메롱메롱");
        newBoard.setTitle("둘리와 도우너");

        //when
        int resultNum = mapper.update(newBoard);
        //then
        assertTrue(resultNum == 1);
        assertTrue(mapper.findByBno(3L).getWriter().equals("도우너"));
    }

    @Test
    @DisplayName("글 번호를 전달하면 해당 글 정보가 삭제되어야 한다.")
    void deleteTest() {

        //when
        mapper.delete(4L);

        //then
        assertNull(mapper.findByBno(4L));

    }

}