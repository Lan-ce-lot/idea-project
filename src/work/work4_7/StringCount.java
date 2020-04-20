package work.work4_7;

import java.util.Scanner;
import java.util.regex.Pattern;

public class StringCount {
    static int countChinese = 0;
    static int countLetter = 0;
    static int countNumber = 0;
    static int countSpace = 0;
    static int countOther = 0;
    public static void main(String[] args) {
        System.out.println("输入字符串");
        Scanner in = new Scanner(System.in);
        String s = in.nextLine();

        check(s);
        System.out.println("中文:" + countChinese);
        System.out.println("英文" + countLetter);
        System.out.println("数字" + countNumber);
        System.out.println("空格" + countSpace);
        System.out.println("其他" + countOther);
    }

    public static void check(String s) {
        String rex1 = "[\u4e00-\u9fa5]";//汉字
        String rex2 = "[a-zA-Z]";//英文
        String rex3 = "\\d";//数字
        String rex4 = "\\s";//空格
        for (int i = 0; i < s.length(); i++) {
            String temp = s.substring(i,i+1);
            if (Pattern.matches(rex1, temp)) countChinese++;
            else if (Pattern.matches(rex2, temp)) countLetter++;
            else if (Pattern.matches(rex3, temp)) countNumber++;
            else if (Pattern.matches(rex4, temp)) countSpace++;
            else countOther++;
        }
    }
}