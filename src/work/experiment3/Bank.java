package work.experiment3;

import java.util.ArrayList;
import java.util.Scanner;

public class Bank {
    public static ArrayList<BankAccount> account = new ArrayList<>();
    static Scanner in = new Scanner(System.in);
    // 注册账户
    public static void openAccount() {
        BankAccount b;
        System.out.println("请选择注册账号类型:(1.活期/2.普通/3.储蓄)");
        int s = in.nextInt();
        if (s == 1) {
            b = new CurrentAccount();   // 多态, 向上转型
            b.accountType = 1;
        } else if(s == 2){
            b = new OrdinaryAccount();  // 多态, 向上转型
            b.accountType = 2;
        } else {
            b = new SavingsAccount();   // 多态, 向上转型
            b.accountType = 3;
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
    // 暂停账户
    public static void Suspend(String num) {
        for (var i : account) if (i.accountId.equals(num)) i.freeze = true;
    }
    // 关闭账户
    public static void closeAccount() {
        System.out.println("请输入关闭账号:");
        String s = in.next();
        for (int i = 0; i < account.size(); i++) if (account.get(i).accountId.equals(s)) account.remove(i);
        System.out.println("账号关闭成功!");
    }
    // 登入账户
    public static void login() {
        System.out.println("请输入您的账号:");
        String s = in.next();
        BankAccount b = new BankAccount();
        for (int i = 0; i < account.size(); i++) {
            if (account.get(i).accountId.equals(s)) {
                b = account.get(i);
            }
        }
        if (b.freeze) {
            System.out.println("账号已冻结!不允许交易");
            return;
        }
        System.out.println("请输入您的密码:");
        if (b.password.equals(in.next())) System.out.println("账号登入成功!");
        else {
            System.out.println("密码错误!");
            return;
        }

        while (b.opreate()) { }
    }
    // 生成ID(6位)
    public static String randomID() {
        return String.valueOf((int) ((1 + Math.random()) * 100000));
    }
    // 选项
    public static void select() {
        while (true) {
            System.out.println("1.用户入口/2.管理员入口");
            if (in.nextInt() == 1) {
                while (true) {
                    System.out.println("1.注册/2.登入/3.退出");
                    int n = in.nextInt();
                    if (n == 1) {
                        openAccount();
                    } else if (n == 2) {
                        login();
                    } else break;
                }
            } else {
                System.out.println("1.冻结/2.退出");
                if (in.nextInt() == 1) {
                    System.out.println("输入冻结账号:");
                    Suspend(in.next());
                    System.out.println("已冻结.");
                } else return;
            }
        }
    }

    public static void main(String[] args) {
        select();
    }
}