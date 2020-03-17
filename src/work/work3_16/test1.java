package work.work3_16;

import java.util.Scanner;

public class test1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("请输入一个整数");
        long n = in.nextLong();
        System.out.println("整数各个位数之和:" + sumDigits(n));
    }

    public static int sumDigits(long n)
    {
        int ans = 0;
        while (n > 0) {
            ans += n % 10;
            n /= 10;
        }
        return ans;
    }
}