package work.work4_26;

import java.util.ArrayList;
import java.util.Scanner;

public class test {
    public static void main(String[] args) {
        System.out.println("请输入两个列表，每个列表有5个整数");
        Scanner in = new Scanner(System.in);
        ArrayList<Integer> list1 = new ArrayList<>();
        ArrayList<Integer> list2 = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            list1.add(in.nextInt());
        }

        for (int i = 0; i < 5; i++) {
            list2.add(in.nextInt());
        }

        System.out.println("并集");
        for (var i : union(list1, list2)) {
            System.out.print(i + " ");
        }
    }

    public static ArrayList<Integer> union(ArrayList<Integer> list1, ArrayList<Integer> list2) {
        ArrayList<Integer> list3 = new ArrayList<>();
        for (var i : list1) {
            if (!list3.contains(i)) {
                list3.add(i);
            }
        }

        for (var i : list2) {
            if (!list3.contains(i)) {
                list3.add(i);
            }
        }
        return list3;
    }
}