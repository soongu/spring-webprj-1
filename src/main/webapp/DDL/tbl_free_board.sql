
CREATE SEQUENCE SEQ_FREE_BOARD;

CREATE TABLE tbl_free_board (
    bno NUMBER(10),
    title VARCHAR2(200) NOT NULL,
    content VARCHAR2(2000) NOT NULL,
    writer VARCHAR2(50) NOT NULL,
    regdate DATE DEFAULT SYSDATE,
    updatedate DATE DEFAULT SYSDATE
);

ALTER TABLE tbl_free_board ADD CONSTRAINT pk_free_board PRIMARY KEY (bno);

INSERT INTO tbl_free_board (bno, title, content, writer) VALUES (seq_free_board.nextval, '테스트01', '테스트내용입니다.', 'user01');
INSERT INTO tbl_free_board (bno, title, content, writer) VALUES (seq_free_board.nextval, '테스트02', '테스트내용입니다.', 'user02');
INSERT INTO tbl_free_board (bno, title, content, writer) VALUES (seq_free_board.nextval, '테스트03', '테스트내용입니다.', 'user03');
INSERT INTO tbl_free_board (bno, title, content, writer) VALUES (seq_free_board.nextval, '테스트04', '테스트내용입니다.', 'user04');
INSERT INTO tbl_free_board (bno, title, content, writer) VALUES (seq_free_board.nextval, '테스트05', '테스트내용입니다.', 'user05');

COMMIT;