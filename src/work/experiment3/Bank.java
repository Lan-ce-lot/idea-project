package work.experiment3;

import java.util.ArrayList;
import java.util.Scanner;

public class Bank {
    public static ArrayList<BankAccount> account = new ArrayList<>();
    static Scanner in = new Scanner(System.in);
    public static void openAccount() {
        BankAccount b = new BankAccount();
        System.out.println("开始注册账号");
        System.out.println("请选择注册账号类型:(1.活期/2.普通)");
        int s = in.nextInt();
        if (s == 1) {
            b = new CurrentAccount();// 多态
            b.accountType = 1;
        }
        else {
            b = new OrdinaryAccount();// 多态
            b.accountType = 2;
        }
        System.out.println("请输入您的姓名:");
        b.accountName = in.next();
        System.out.println("请输入您的邮箱:");
        b.email = in.next();
        System.out.println("请输入您的密码:");
        b.password = in.next();
        System.out.println("账号注册成功!");
        b.accountId = randomID();
        System.out.println("您的账号是:" + b.accountId);
        account.add(b);
    }

    public static void closeAccount() {
        System.out.println("请输入关闭账号:");
        String s = in.next();
        for (var i : account) if (i.accountId.equals(s)) account.remove(i);
        System.out.println("账号关闭成功!");
    }

    public static void login() {
        System.out.println("开始登入账号");
        System.out.println("请输入您的账号:");
        String s = in.next();
        BankAccount b = new BankAccount();
        for (int i = 0; i < account.size(); i++) {
            if (account.get(i).accountId.equals(s)) {
                b = account.get(i);
            }
        }
        System.out.println("请输入您的密码:");
        if (b.password.equals(in.next())) System.out.println("账号登入成功!");
        else {
            System.out.println("密码错误!");
            return;
        }
        System.out.println("账号登入成功!");

        while (true) {
            System.out.println("1.继续/2.退出");
            if (in.nextInt() == 1) b.opreate();
            else return;
        }
    }

    public static String randomID() {
        return String.valueOf((int) (1 + Math.random() * 100000));
    }

    public static void select() {
        while (true) {
            System.out.println("1.注册/2.登入/3.退出");
            int n = in.nextInt();
            if (n == 1) {
                openAccount();
            } else if (n == 2) {
                login();
            } else return;
        }
    }

    public static void main(String[] args) {
        select();
    }
}