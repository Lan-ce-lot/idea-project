package work4_13;

import java.util.regex.Pattern;
import java.util.Scanner;

public class PasswordValidator {
    public static void checkPassword(String password) {
        String str_1 = "[a-zA-Z\\d]{8,}";  //正则表达式密码只能包含字母和数字,至少8位字符

        if (Pattern.matches(str_1, password)) {
            System.out.println("密码正确");
        } else {
            System.out.println("密码错误");
        }
    }

    /**
     * 测试main方法
     */
    public static void main(String[] args) {
        while (true) {
            Scanner input = new Scanner(System.in);
            System.out.println("请输入密码:");
            String password = input.nextLine();
            checkPassword(password);
        }
    }
}


