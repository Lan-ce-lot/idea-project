package work.work3_17;

import java.util.Scanner;


public class test2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("随机生成4x4矩阵(0 和 1):");

        int[][] m = new int[4][4];
        int row = 0;
        int clu = 0;
        int maxRow = 0;
        int maxClu = 0;
        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < m[i].length; j++) {
                m[i][j] = (int) (Math.random() * 2);
                System.out.printf("%d ", m[i][j]);
            }
            System.out.println();
        }

        for (int i = 0; i < m.length; i++) {    //行
            int temp = 0;
            for (int j = 0; j < m[i].length; j++) {
                if (m[i][j] == 1) {
                    temp++;
                }
            }
            if (temp > maxRow) {
                maxRow = temp;
                row = i;
            }
        }

        for (int i = 0; i < 4; i++) {    //列
            int temp = 0;
            for (int j = 0; j < 4; j++) {
                if (m[j][i] == 1) {
                    temp++;
                }
            }
            if (temp > maxClu) {
                maxClu = temp;
                clu = i;
            }
        }
        System.out.println("(行列都从1开始)");
        System.out.println("具有最多 1的行为:第" + (row + 1) + "行");
        System.out.println("具有最多 1的列为:第" + (clu + 1) + "列");
    }
}