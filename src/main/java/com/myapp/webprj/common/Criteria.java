package com.myapp.webprj.common;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

//페이지 정보 객체
@Setter @Getter
@ToString
public class Criteria {

    private int page;  //페이지 번호
    private int amount;//한 페이지당 게시물 수

    public Criteria() {
        this(1, 10);
    }

    public Criteria(int page, int amount) {
        this.page = page;
        this.amount = amount;
    }
}
