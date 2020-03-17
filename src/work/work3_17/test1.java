package work.work3_17;

import java.util.Scanner;


public class test1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("输入点的个数:");
        int numPoints = in.nextInt();

        double[][] point = new double[numPoints][3];
        System.out.println("输入" + numPoints +"个三维坐标:");
        for (int i = 0; i < point.length; i++) {
            for (int j = 0; j < point[i].length; j++)
                point[i][j] = in.nextDouble();
        }

        int ansP0 = 0;// 指向第一个点
        int ansP1 = 1;// 指向第二个点
        double shortest = getDistance(point[0][0], point[0][1], point[0][2], point[1][0], point[1][1], point[1][2]);

        for (int i = 0; i < point.length; i++) {
            for (int j = i + 1; j < point.length; j++) {
                double d = getDistance(point[i][0], point[i][1], point[i][2], point[j][0], point[j][1], point[j][2]);

                if (shortest > d) {
                    ansP0 = i;
                    ansP1 = j;
                    shortest = d;
                }
            }
        }

        System.out.println("距离最近的两点是:\n" + "(" + point[ansP0][0] + ", " + point[ansP0][1] + ", " + point[ansP0][2] + ")");
        System.out.println("和" + "(" + point[ansP1][0] + ", " + point[ansP1][1] + ", " + point[ansP1][2] + ")");
        System.out.printf("最短距离是:%.6f" ,shortest);
    }

    public static double getDistance(double x1, double y1, double z1, double x2, double y2, double z2) {
        return Math.sqrt((x2 - x1) * (x2 - x1) + (y2 - y1) * (y2 - y1) + (z2 - z1) * (z2 - z1));
    }
}