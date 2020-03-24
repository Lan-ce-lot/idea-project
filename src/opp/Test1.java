package opp;

import java.util.Random;

public class Test1 {
    public static void main(String[] args) {
        myRandom();
    }

    public static void myRandom() {
        Random random = new Random(1000);
        System.out.println("0到100 之间前50 个随机整数");
        for (int i = 0; i < 50; i++) {
            System.out.print(random.nextInt(100) + " ");
        }
        System.out.println();
    }
}