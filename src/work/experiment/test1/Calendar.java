package work.experiment.test1;

import java.util.Scanner;

/**
 * A program for viewing images.
 *
 * @author Lance
 * @version 1.00 2020-03-08
 */
public class Calendar {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("请输入年份:");
        int[] monthSet = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        int[][] date = new int[120][46];
        int year = in.nextInt();

        int firstDayWeek = getFirstDayWeek(year);
        if (isLeapYear(year)) {
            monthSet[1] = 29;
        }
        date = getDate(firstDayWeek, monthSet);
//        System.out.println(1);
        printCalendar(date);
    }

    public static int getFirstDayWeek(int year) {
        year--;
        int month = 13;
        int day = 1;
        int cen = year / 100;
        int y = year % 100;

        int week = (cen / 4 - 2 * cen + y + y / 4 + 13 * (month + 1) / 5 + day - 1) % 7;

        return week;
    }

    public static boolean isLeapYear(int year) {
        return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
    }

    public static int[][] getDate(int w, int[] monthSet) {
        int temp[][] = new int[120][46];
        for (int i = 0; i < 12; i++) {
            for (int j = w, k = 1; k <= monthSet[i]; j++, k++) {
                temp[i][j] = k;
            }
            w = (w + monthSet[i]) % 7;
        }
        return temp;
    }

    public static void printCalendar(int[][] temp) {
        for (int i = 0; i < 24; i++) {
            if (i % 8 == 0) {
                printMonth(i / 7);
            } else if (i % 8 == 1) {
                printWeek();
            } else {
                printDate(i / 8, i % 8, temp);
            }

        }
    }

    public static void printMonth(int flag) {
        if (flag == 0) {
//            System.out.print("日   一   二   三   四   五   六    ");
            System.out.print("                             1月     ");
            System.out.print("                             2月     ");
            System.out.print("                             3月      ");
            System.out.print("                             4月    \n");
        } else if (flag == 1) {
            System.out.print("                             5月     ");
            System.out.print("                             6月     ");
            System.out.print("                             7月      ");
            System.out.print("                             8月    \n");
        } else {
            System.out.print("                             9月     ");
            System.out.print("                            10月     ");
            System.out.print("                            11月      ");
            System.out.print("                            12月    \n");
        }
    }

    public static void printWeek() {
        for (int i = 0; i < 4; i++) {
            System.out.print("日   一   二   三   四   五   六      ");
        }
        System.out.println();
    }

    public static void printDate(int flag, int row,int[][] temp) {
        for (int i = flag * 4; i < (flag + 1) * 4; i++) {
            for (int j = (row - 2) * 7; j < (row - 1) * 7; j++) {
                if (temp[i][j] != 0) {
//                    System.out.print(temp[i][j] + "日   ");
//                    System.out.print(temp[i][j] + "    ");
                    System.out.printf("%-5d", temp[i][j]);
                } else {
                    System.out.print("     ");
                }
            }
            System.out.print("  ");
            if (i - flag * 4 == 2) {
                System.out.print(" ");
            }
        }
        System.out.println();
    }
}