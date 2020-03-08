package work;

import java.util.Scanner;

public class Amount {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.println("请输入投资总额：");
        double total = in.nextDouble();
        System.out.println("请输入年利率：");
        double rate = in.nextDouble();
        System.out.println("请输入年数：");
        double years = in.nextDouble();

        double month_rate = rate / 12;
        double future = total * Math.pow((1 + month_rate), 12 * years);
        System.out.printf("未来投资金额: %.6f", future);
    }
}
