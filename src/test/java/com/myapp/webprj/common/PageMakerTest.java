package com.myapp.webprj.common;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import static org.junit.jupiter.api.Assertions.*;

class PageMakerTest {

    @Test
    void pageMakingTest() {

        Criteria cri = new Criteria(24, 10);
        int total = 267;

        PageMaker pageMaker = new PageMaker(cri, total);
        System.out.println("============================================");
        System.out.println(pageMaker);
        System.out.println("============================================");

    }

    @Test
    @DisplayName("URI 파라미터를 원하는대로 만들어야 한다.")
    void makeUriParamTest() {

        UriComponents build = UriComponentsBuilder.newInstance()
                .queryParam("page", 3)
                .queryParam("keyword", "멍멍이")
                .queryParam("type", "title")
                .build();

        System.out.println("build.toString() = " + build.toString());
    }

}