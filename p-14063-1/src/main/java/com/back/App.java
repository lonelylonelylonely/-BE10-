package com.back;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class App {
    Scanner sc = new Scanner(System.in);
    List<Wise_saying> list = new ArrayList<>();


    // 시작
    public void run() {
        System.out.println("==  Wise_saying_app ==");

        while (true) {
            String command;
            System.out.print("Command) ");
            command = sc.nextLine().trim();
            Rq rq = new Rq(command);

            switch (rq.getActionName()) {
                case "End":
                    System.out.println("Program is ended");
                    return;
                case "Register":
                    actionWrite();
                    break;
                case "List":
                    actionList();
                    break;
                case "Delete":
                    actionDelete(rq);
                    break;
                case "Edit":
                    actionEdit(rq);
                    break;
            }

        }
    }

    // 고객 응대 로직
    private void actionWrite() {

        System.out.print("Saying) ");
        String content = sc.nextLine().trim();
        System.out.print("Writer) ");
        String author = sc.nextLine().trim();

        write(content, author);

        System.out.println("%d th saying is registered".formatted(list.size()));
    }

    private void actionList() {
        System.out.println("id / author / content ");
        System.out.println("________________________________");
        for (Wise_saying i : list.reversed()) {
            System.out.println(i.id + " / " + i.writer + " / " + i.saying);
        }
    }

    private void write(String content, String author) {
        Wise_saying say = new Wise_saying(list.size() + 1, content, author);

        list.add(say);
    }

    private void actionDelete(Rq rq) {
        int id = rq.getParamAsInt("id", -1);

        if (id == -1) {
            System.out.println("id value is NOT provided");
            return;
        }

        Wise_saying foundSaying = findById(id);

        if (foundSaying == null) {
            System.out.println("%d th saying does NOT exist".formatted(id));
        } else {
            list.remove(foundSaying);
            System.out.println("%d th saying is deleted".formatted(id));
        }
    }

    private void actionEdit(Rq rq) {

        int id = rq.getParamAsInt("id", -1);
        if (id == -1) {
            System.out.println("id value is NOT provided");
            return;
        }

        System.out.print("rewrite-Saying) ");
        String content = sc.nextLine().trim();
        System.out.print("rewrite-Writer) ");
        String author = sc.nextLine().trim();

        rewrite(id, content, author);

        System.out.println("%d th saying is modified".formatted(id));
    }

    private void rewrite(int id, String content, String author) {
        Wise_saying wiseSaying = findById(id);
        wiseSaying.saying = content;
        wiseSaying.writer = author;
    }

    private Wise_saying findById(int id) {
        Wise_saying result = null;
        for (Wise_saying i : list) {
            if (i.getId() == id) {
                result = i;
                break;
            }
            ;
        }
        return result;
    }

}


