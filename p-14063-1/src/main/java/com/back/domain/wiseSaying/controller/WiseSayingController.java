package com.back.domain.wiseSaying.controller;

import com.back.Rq;
import com.back.domain.AppContext;
import com.back.domain.wiseSaying.service.WiseSayingService;
import com.back.Wise_saying;

import java.util.Scanner;

public class WiseSayingController {
    private final Scanner sc = AppContext.scanner;
    private final WiseSayingService wiseSayingService = AppContext.wiseSayingService;


    // 고객 응대 로직
    public void actionWrite() {

        System.out.print("Saying) ");
        String content = sc.nextLine().trim();
        System.out.print("Writer) ");
        String author = sc.nextLine().trim();

        wiseSayingService.write(content, author);


    }

    public void actionList() {
        System.out.println("Id / Author / Content / Written date  / Edited date");
        System.out.println("________________________________");
        wiseSayingService.readlist();

    }


    public void actionDelete(Rq rq) {
        int id = rq.getParamAsInt("id", -1);

        if (id == -1) {
            System.out.println("id value is NOT provided");
            return;
        }

        Wise_saying foundSaying = wiseSayingService.findById(id);

        wiseSayingService.removeif(foundSaying, id);

    }

    public void actionEdit(Rq rq) {

        int id = rq.getParamAsInt("id", -1);
        if (id == -1) {
            System.out.println("id value is NOT provided");
            return;
        }

        System.out.print("rewrite-Saying) ");
        String content = sc.nextLine().trim();
        System.out.print("rewrite-Writer) ");
        String author = sc.nextLine().trim();

        wiseSayingService.rewrite(id, content, author);
    }


}

