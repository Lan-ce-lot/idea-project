package work3_10;

import java.util.Scanner;

/**
 * A program for viewing images.
 *
 * @author Lance
 * @version 1.00 2020-03-08
 */
public class test2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int[] myList = new int[10];

        System.out.println("请输入10个数字:");
        for (int i = 0; i < 10; i++) {
            myList[i] = in.nextInt();
        }

        myList = reverse(myList);
        System.out.println("倒序:");
        for (var i : myList) {
            System.out.printf("%d ", i);
        }
    }

    static int[] reverse(int[] list) {
        int[] res = new int[10];
        for (int i = 0; i < list.length; i++) {
            res[i] = list[list.length - i - 1];
        }
        return res;
    }
}