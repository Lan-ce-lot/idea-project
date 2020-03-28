package work.experiment2;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * A program for viewing images.
 *
 * @author Lance
 * @version 1.00 2020-03-08
 */
public class regEx {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.next();
//        String re = "^1[3|4|5|8|9][0-9]\\d{8}$";
        Pattern p = Pattern.compile("^1[3|4|5|8|9][0-9]\\d{8}$");
        Matcher match = p.matcher(s);
        System.out.println(match.matches());
//\d{1}
        // 要验证的字符串
//        String str = "service@xsoftlab.net";
        String str = in.next();
        // 邮箱验证规则
//        String regEx = "[a-zA-Z_]{1,}[0-9]{0,}@(([a-zA-z0-9]-*){1,}\\.){1,3}[a-zA-z\\-]{1,}";
        String regEx = "^\\w+([-+.]\\w+)*@\\w+([-.]\\w+)*\\.\\w+([-.]\\w+)*$";
        // 编译正则表达式
        Pattern pattern = Pattern.compile(regEx);
        // 忽略大小写的写法
        // Pattern pat = Pattern.compile(regEx, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(str);
        // 字符串是否与正则表达式相匹配
        boolean rs = matcher.matches();
        System.out.println(rs);
    }
}