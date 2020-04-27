package work.experiment3;

import java.util.Scanner;

public class BankAccount {
    public String accountName;          // 用户
    public double balance = 0;          // 余额
    public String accountId;            // 账号

    public String email;                // 邮箱
    public String password;             // 密码
    public int accountType;             // 账号类型分1.活期账户,2.普通账户,3.储蓄账户
    public boolean freeze = false;      // 是否冻结

    public BankAccount() { }

    public BankAccount(String accountName, double balance, String accountId, String email,
                       String password, int accountType, boolean freeze) {
        this.accountName = accountName;
        this.balance = balance;
        this.accountId = accountId;
        this.email = email;
        this.password = password;
        this.accountType = accountType;
        this.freeze = freeze;
    }
    // 取款
    public void withdrawal(double amount) {
        if (balance < amount) System.out.println("取款失败!余额不足, 您现在的余额为" + checkBalance() + "￥");
        else {balance -= amount;System.out.println("取款成功!您现在的余额为" + checkBalance() + "￥");}
    }
    // 存款
    public void deposit(double amount) {
        balance += amount;
        System.out.println("存款成功!您现在的余额为" + checkBalance() + "￥");
    }
    // 检查余额
    public double checkBalance() {
        return balance;
    }
    // 无实际作用, 方便后面的多态, 向上转型
    public boolean opreate() {
        System.out.println("父类BUG!!!!");
        return false;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        BankAccount b = new BankAccount("黄昌盛", 100, "123456", "123@qq.com", "123", 0, false);
        System.out.println("创建账号:" + "姓名:" + b.accountName + " 余额:" +
                b.balance + " id:" +b.accountId );
        System.out.println("输入存款金额:");
        b.deposit(in.nextDouble());
        System.out.println("输入取款金额:");
        b.withdrawal(in.nextDouble());
        System.out.println("余额查询:" + b.checkBalance() + "￥");
    }
}