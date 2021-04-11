CREATE SEQUENCE SEQ_REPLY;

CREATE TABLE tbl_reply (
    rno number(10),
    bno number(10) NOT NULL,
    reply VARCHAR2(1000) NOT NULL,
    replyer VARCHAR2(50) NOT NULL,
    reply_date DATE default SYSDATE,
    update_date DATE default SYSDATE
);

ALTER TABLE tbl_reply ADD CONSTRAINT pk_reply PRIMARY KEY (rno);

ALTER TABLE tbl_reply ADD CONSTRAINT fk_reply_board FOREIGN KEY (bno) REFERENCES tbl_board (bno);