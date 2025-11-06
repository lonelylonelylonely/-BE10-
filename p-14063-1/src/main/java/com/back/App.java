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

            if (Objects.equals(command , "End")) {
                break;

            } else if (Objects.equals(command , "Register")) {
                actionWrite();

            } else if (Objects.equals(command , "List")) {
                actionList();

            } else if (command.contains("Delete")) {
                actionDelete(command);
            } else if (command.contains("Edit")) {
                actionEdit(command);
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
            System.out.println(i.id + " / " +i.writer + " / " + i.saying);
        }
    }

    private void write(String content, String author) {
        Wise_saying say = new Wise_saying();
        say.id = list.size() + 1;
        say.saying = content;
        say.writer = author;

        list.add(say);
    }

    private void actionDelete(String cmd) {
         String[] cmdBits = cmd.split("=",2);
        int id = Integer.parseInt(cmdBits[1].trim());

         if (list.size() == 0){
            System.out.println("No Data");

        } else {
            for (Wise_saying i : list) {
                if (i.id == id) {
                    list.remove(i);
                    System.out.println("%d th saying is deleted".formatted(id));
                    break;
                }
            }
        }
    }

    private void actionEdit(String cmd) {
        String[] cmdBits = cmd.split("=",2);
        int id = Integer.parseInt(cmdBits[1].trim());

        System.out.print("rewrite-Saying) ");
        String content = sc.nextLine().trim();
        System.out.print("rewrite-Writer) ");
        String author = sc.nextLine().trim();

        rewrite(id, content, author);

        System.out.println("%d th saying is modified".formatted(id));
    }

    private void rewrite( int id, String content, String author) {
        Wise_saying wiseSaying = findById(id);
        wiseSaying.saying = content;
        wiseSaying.writer = author;
    }

    private Wise_saying findById(int id) {
        Wise_saying result = null;
        for (Wise_saying i : list) {
            if (i.id == id) {
                result = i;
                break;
            };
        }
        return result;
    }


    static class Wise_saying {
        String saying;
        String writer;
        int id;
    }
}

