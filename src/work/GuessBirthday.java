package work;

import java.util.Scanner;
public class GuessBirthday {
    public static void main(String[] args) {
        String set1=
                " 1  3  5  7\n"+
                        " 9 11 13 15\n"+
                        "17 19 21 23\n"+
                        "25 27 29 31";

        String set2=
                " 2  3  6  7\n"+
                        "10 11 14 15\n"+
                        "18 19 22 23\n"+
                        "26 27 30 31";

        String set3=
                " 4  5  6  7\n"+
                        "12 13 14 15\n"+
                        "20 21 22 23\n"+
                        "28 29 30 31";

        String set4=
                " 8  9 10 11\n"+
                        "12 13 14 15\n"+
                        "24 25 26 27\n"+
                        "28 29 30 31";

        String set5=
                "16 17 18 19\n"+
                        "20 21 22 23\n"+
                        "24 25 26 27\n"+
                        "28 29 30 31";

        int day=0;

        boolean fals = true;
        Scanner input = new Scanner(System.in);
        for (int i = 0; i <= 4; i++) {
            System.out.println("你的生日在此集合里面吗？");
            if (i == 0) {
                System.out.print(set1);
            } else if (i == 1) {
                System.out.print(set2);
            } else if (i == 2) {
                System.out.print(set3);
            } else if (i == 3) {
                System.out.print(set4);
            } else {
                System.out.print(set5);
            }
            System.out.println("\n是请输入1，否请输入0：");
            int anwer = input.nextInt();
            if (anwer == 1) {
                day += anwer * (1 << i);
            }

        }
        System.out.println("生日为" + day + "号");
    }
}