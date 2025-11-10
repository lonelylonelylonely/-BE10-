package com.back.domain.wiseSaying.service;

import com.back.Wise_saying;
import com.back.domain.AppContext;
import com.back.domain.wiseSaying.repository.WiseSayingRepository;

import java.util.ArrayList;
import java.util.List;

public class WiseSayingService {

    private final WiseSayingRepository wiseSayingRepository = AppContext.wiseSayingRepository;

    public void write(String content, String author) {
        Wise_saying say = new Wise_saying(content, author);

        wiseSayingRepository.save(say);
    }

    public Wise_saying findById(int id) {
        return wiseSayingRepository.findByid(id);

    }

    public void rewrite(int id, String content, String author) {
        Wise_saying wiseSaying = findById(id);
        wiseSaying.setContent(content);
        wiseSaying.setAuthor(author);

        wiseSayingRepository.save(wiseSaying);

    }


    public void removeif(Wise_saying foundSaying, int id) {
        if (foundSaying == null) {
            System.out.println("%d th saying does NOT exist".formatted(id));
        } else {
            wiseSayingRepository.deleteByid(id);

        }
    }

    public void readlist() {
        wiseSayingRepository.printList();

    }
}


