package work3_9;

import java.util.Scanner;

public class test2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("请输入一个数");
        int n = in.nextInt();
        double ans = 0.0;
        for (int i = n; i > 0; i--) {
            ans += 1.0 / i;
        }
        System.out.printf("计算结果是：%.2f\n", ans);
    }
}
