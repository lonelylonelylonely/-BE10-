package com.back;

public class Main {
    public static void main(String[] args) {
         App app = new App();
         app.run();

//        testRq1();
    }

    private static void testRq1() {
        Rq rq = new Rq("List?searchKeywordType=content&searchKeyword=Java&page=2");
        String actionName = rq.getActionName();
        String searchKeywordType = rq.getParam("searchKeywordType", "");
        String searchKeyword = rq.getParam("searchKeyword", "");
        int page = rq.getParamAsInt("page", -1);
        int id = rq.getParamAsInt("id", -1);
        String sort = rq.getParam("sort","idDesc");

        System.out.println("actionName : " + actionName);
        System.out.println("param searchKeywordType : " + searchKeywordType);
        System.out.println("param searchKeywordType : " + searchKeyword);
        System.out.println("param page : " + page);
        System.out.println("param id : " + id);
        System.out.println("param sort : " + sort);
    }
}




//        System.out.println("==  Wise_saying_app ==");
//
//
//        Scanner sc = new Scanner(System.in);
//        List<Wise_saying> list = new ArrayList<>();
//
//        while (true) {
//
//
//            Wise_saying say = new Wise_saying();
//            System.out.print("Command) ");
//            say.command = sc.nextLine().trim();
//
//            if (Objects.equals(say.command, "End")) {
//                break;
//
//            } else if (Objects.equals(say.command, "Register")) {
//                say.id = list.size() + 1;
//                System.out.print("Saying) ");
//                say.saying = sc.nextLine().trim();
//                System.out.print("Writer) ");
//                say.writer = sc.nextLine().trim();
//                list.add(say);
//                System.out.println("%d th saying is registered".formatted(say.id));
//
//            } else if (Objects.equals(say.command, "List")) {
//                System.out.println("________________________________");
//                for (Wise_saying i : list.reversed()) {
//                    System.out.println(i.id + " / " +i.writer + " / " + i.saying);
//                }
//
//            }
//            // else if (Objects.equals(say.command, "Delete")) {  }
//
//        }
//
//    }
//
//    static class Wise_saying {
//        String command;
//        String saying;
//        String writer;
//        int id;
//    }

