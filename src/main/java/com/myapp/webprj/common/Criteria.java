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

    private String type; //검색 조건
    private String keyword; //검색어

    public Criteria() {
        this(1, 10);
    }

    public Criteria(int page, int amount) {
        this.page = page;
        this.amount = amount;
    }

    public Criteria(int page, int amount, String type, String keyword) {
        this.page = page;
        this.amount = amount;
        this.type = type;
        this.keyword = keyword;
    }
}
