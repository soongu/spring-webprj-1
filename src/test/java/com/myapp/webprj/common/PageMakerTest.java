package com.myapp.webprj.common;

import org.junit.jupiter.api.Test;

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

}