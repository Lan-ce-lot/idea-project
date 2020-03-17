package work.work3_10;

import java.util.Arrays;
import java.util.Scanner;

/**
 * A program for viewing images.
 *
 * @author Lance
 * @version 1.00 2020-03-08
 */
public class text1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int peer = 0;
        double sum = 0.0;
        double average = 0.0;
        int higher = 0;
        int lower = 0;
        double myList[] = new double[1005];

        System.out.println("请输入分数，以负数为终止条件：");
        while(true) {
            double temp = in.nextDouble();
            if (temp < 0) {
                System.out.println("输入结束，共" + peer + "人");
                break;
            } else if (temp > 100) {
                System.out.println("分数不能大于100！");
            } else {
                myList[peer] = temp;
                peer++;
            }
        }
        for (var i : myList)
            sum += i;

        average = sum / peer;

        Arrays.sort(myList, 0, peer);//快速排序，使数组升序，方便后面的操作

        for (int i = 0; i < peer; i++) {
            if (average <= myList[i]) {
                lower = i;
                higher = peer - lower;
                break;
            }
        }

        System.out.println("平均分：" + average);
        System.out.println("高于等于平均分的人数：" + higher);
        System.out.println("低于平均分的人数：" + lower);
    }
}