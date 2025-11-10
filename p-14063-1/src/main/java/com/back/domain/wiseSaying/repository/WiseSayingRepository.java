package com.back.domain.wiseSaying.repository;

import com.back.Wise_saying;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class WiseSayingRepository {
    // 단순 데이터 저장, 조회 역할
    private int lastId = 0;
    private final List<Wise_saying> list = new ArrayList<>();

    public Wise_saying findByid(int id) {
        Wise_saying result = null;
        for (Wise_saying i : list) {
            if (i.getId() == id) {
                return i;
            }
        }
        return result;
    }

    public void save(Wise_saying wiseSaying) {
        if (wiseSaying.isNew()) {
            wiseSaying.setId(++lastId);
            wiseSaying.setCreateDate(LocalDateTime.now());
            list.add(wiseSaying);
        } else {
            wiseSaying.setModifyDate(LocalDateTime.now());
        }
    }

    public void deleteByid(int id){
        Wise_saying foundSaying = findByid(id);
        list.remove(foundSaying);
        System.out.println("%d th saying is deleted".formatted(id));

    }

    public void printList(){
        for (Wise_saying i : list.reversed()) {
            System.out.println(i.getId() + " / "
                    + i.getAuthor() + " / "
                    + i.getContent() + " / "
                    + i.getForPrintCreateDate() + " / "
                    + i.getForPrintModifyDate()
            );
        }
    }

}
