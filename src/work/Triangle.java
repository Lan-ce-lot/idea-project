package work;

import java.util.Scanner;

public class Triangle {
    static boolean is_triangle(double a, double b, double c) {
        return a + b > c && a + c > b && b + c > a;
    }
    public static void main(String[] args) {
        System.out.println("输入三角形三个点的坐标：");
        Scanner in = new Scanner(System.in);
        double x1 = in.nextDouble();
        double y1 = in.nextDouble();
        double x2 = in.nextDouble();
        double y2 = in.nextDouble();
        double x3 = in.nextDouble();
        double y3 = in.nextDouble();
        double a = Math.sqrt((x1 - x2) * (x1 - x2) + (y1 - y2) * (y1 - y2));
        double b = Math.sqrt((x1 - x3) * (x1 - x3) + (y1 - y3) * (y1 - y3));
        double c = Math.sqrt((x2 - x3) * (x2 - x3) + (y2 - y3) * (y2 - y3));
        if (is_triangle(a, b, c)) {//判断是不是三角形
            double p = (a + b + c) / 2.0;
            double area = Math.sqrt(p * (p - a) * (p - b) * (p - c));
            System.out.printf("三角形的面积是：%.6f", area);
        } else {
            System.out.println("不是三角形！");
        }
    }
}
