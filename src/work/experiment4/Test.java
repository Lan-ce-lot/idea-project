package work.experiment4;

import java.util.Scanner;
import java.util.regex.Pattern;

public class Test {

    public static void bin2Dec(String bin) throws NumberFormatException {
        int decimal = 0;
        int p = 0;
        String str_1 = "[0,1]{1,}";  //正则表达式, 匹配只包含数字0和1的字符串
        if (!Pattern.matches(str_1, bin))
            throw new NumberFormatException("字符串不是一个二进制宇符串！");
        else {
            int intBin = Integer.parseInt(bin, 10);
            while (intBin != 0) {
                int temp = intBin % 10;
                decimal += temp * Math.pow(2, p);
                intBin = intBin / 10;
                p++;
            }
        }
        System.out.println("十进制为:" + decimal);
    }

    public static void main(String[] args) {
        try {
            Scanner in = new Scanner(System.in);
            System.out.print("请输入一个二进制数:");
            String bin = in.next();
            bin2Dec(bin);
        } catch (NumberFormatException ex) {
            System.out.println(ex);
        }
    }
}
