package opp;

/**
 * A program for viewing images.
 *
 * @author Lance
 * @version 1.00 2020-03-08
 */

import java.util.Scanner;

public class ly {

    //求该年份1月1号的星期

    public static int weekday(int year) {

        int yearTotalDay = 0;
        int week;
        for (int n = 1900; n < year; n++) {

            if ((year % 4 == 0 && year % 100 != 0) || (year % 400 == 0)) {
                yearTotalDay += 366;
            } else {
                yearTotalDay += 365;
            }
        }
        yearTotalDay = yearTotalDay + 1;
        week = yearTotalDay % 7;
        return week;
    }

    //设置一个三维数组calendar[3][4][5][7]存放日期， 第一维是分三块输出，第二维是每块的月数，第三,四维则是具体的时间

    public static int[][][][] calendar(int year, int week) {

        int[][][][] temp = new int[3][4][6][7];
        int[] monthSet = new int[]{31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        int monthNimble = 0;
        int cw = week;
        if ((year % 4 == 0 && year % 100 != 0) || (year % 400 == 0)) {
            monthSet[1] = 29;
        }
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 4; j++) {
                for (int k = 0, l = 1; k < 6; k++) {
                    for (int o = cw; o < 7; o++) {
                        temp[i][j][k][o] = l;
                        l++;
                        if (l > monthSet[monthNimble]) {
                            l = 1;
                            break;
                        }
                    }

                    cw = 0;
                }
                week = (week + monthSet[monthNimble]) % 7;
                monthNimble++;
                cw = week;
            }
        }
        return temp;
    }

    //暴力输出月号以及星期列表

    public static void printMW(int i) {
        System.out.println("            " + ((i + 1) * (i + 1)) + "月" + "             " + ((i + 1) * (i + 1) + 1) + "月" + "             " + ((i + 1) * (i + 1) + 2) + "月" + "            " + ((i + 1) * (i + 1) + 3) + "月");
        System.out.println("日一二 三 四 五 六  " + "日一二 三 四 五 六  " + "日一二 三 四 五 六  " + "日一二 三 四 五 六  ");
    }

    //打印日历表

    public static void printCalendar(int[][][][] temp) {
        int[][][][] te = new int[3][4][6][7];
        te = temp;
        for (int a = 0; a < 3; a++) {
            printMW(a);
            for (int b = 0; b < 6; b++) {
                for (int c = 0; c < 4; c++) {
                    for (int d = 0; d < 7; d++) {
                        if (te[a][c][b][d] != 0)
                            System.out.printf("%02d ", te[a][c][b][d]);
                        else System.out.print("   ");
                    }
                    System.out.print("  ");
                }
                System.out.println("");
            }
            //System.out.println("");
        }
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("请输入年份：");
        int year = input.nextInt();
        int week = weekday(year);
        int[][][][] tem = new int[3][4][6][7];
        tem = calendar(year, week);
        printCalendar(tem);
    }
}