package com.back;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

//TIP 코드를 <b>실행</b>하려면 <shortcut actionId="Run"/>을(를) 누르거나
// 에디터 여백에 있는 <icon src="AllIcons.Actions.Execute"/> 아이콘을 클릭하세요.
public class Main {
    public static void main(String[] args) {
        System.out.println("==  Wise_saying_app ==");


        Scanner sc = new Scanner(System.in);
        List<Wise_saying> list = new ArrayList<>();

        while (true) {


            Wise_saying say = new Wise_saying();
            System.out.print("Command) ");
            say.command = sc.nextLine().trim();

            if (Objects.equals(say.command, "End")) {
                break;

            } else if (Objects.equals(say.command, "Register")) {
                say.id = list.size() + 1;
                System.out.print("Saying) ");
                say.saying = sc.nextLine().trim();
                System.out.print("Writer) ");
                say.writer = sc.nextLine().trim();
                list.add(say);
                System.out.println("%d th saying is registered".formatted(say.id));

            } else if (Objects.equals(say.command, "List")) {
                System.out.println("________________________________");
                for (Wise_saying i : list.reversed()) {
                    System.out.println(i.id + " / " +i.writer + " / " + i.saying);
                }

            }
            // else if (Objects.equals(say.command, "Delete")) {  }

        }

    }

    static class Wise_saying {
        String command;
        String saying;
        String writer;
        int id;
    }
}
