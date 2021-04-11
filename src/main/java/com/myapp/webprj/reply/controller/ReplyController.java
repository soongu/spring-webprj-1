package com.myapp.webprj.reply.controller;

import com.myapp.webprj.common.Criteria;
import com.myapp.webprj.reply.domain.Reply;
import com.myapp.webprj.reply.service.ReplyService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/replies")
@Log4j2
public class ReplyController {

    private final ReplyService replyService;

    //댓글 등록
    @PostMapping("/")
    public ResponseEntity<String> create(@RequestBody Reply reply) {
        log.info("/replies/ POST : " + reply);

        int insertCount = replyService.register(reply);
        log.info("REPLY INSERT COUNT: " + insertCount);

        return insertCount == 1 ?
                new ResponseEntity<>("regSuccess", HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);

    }

    //댓글 목록 조회
    @GetMapping("/{bno}/{page}")
    public ResponseEntity<List<Reply>> getList(@PathVariable("page") int page, @PathVariable("bno") Long bno) {

        log.info("/replies/"+bno+"/"+page +"GET !!");
        Criteria cri = new Criteria(page, 10);
        return new ResponseEntity<>(replyService.getList(cri, bno), HttpStatus.OK);
    }

    //댓글 개별 조회
    @GetMapping("/{rno}")
    public ResponseEntity<Reply> get(@PathVariable("rno") Long rno) {
        return new ResponseEntity<>(replyService.get(rno), HttpStatus.OK);

    }

    //댓글 삭제
    @DeleteMapping("/{rno}")
    public ResponseEntity<String> remove(@PathVariable("rno") Long rno) {
        return replyService.remove(rno) == 1 ?
                new ResponseEntity<>("delSuccess", HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }

    //댓글 수정
    @PutMapping("/{rno}")
    public ResponseEntity<String> modify(@RequestBody Reply reply, @PathVariable("rno") Long rno) {
        reply.setRno(rno);
        return replyService.modify(reply) == 1 ?
                new ResponseEntity<>("modSuccess", HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
