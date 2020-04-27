package work.experiment3;

import java.util.Scanner;

public class SavingsAccount extends BankAccount {
    public double interest;// 利息

    public SavingsAccount() { }

    public SavingsAccount(String accountName,double balance,String accountId,String email,
                          String password,int accountType,boolean freeze,double interest) {
        super(accountName, balance, accountId, email, password, accountType, freeze);
        this.interest = interest;
    }

    public void withdrawal(double amount) {
        System.out.println("请预约后7个工作日再来取款");
    }

    public boolean opreate() {
        System.out.println("1.存款/2.取款/3.余额/4.关闭账号/5.退出");
        Scanner in = new Scanner(System.in);
        int temp = in.nextInt();
        if (temp == 1) {
            System.out.println("请输入存款金额:");
            deposit(in.nextInt());
        } else if (temp == 2) {
            System.out.println("请输入取款金额:");
            withdrawal(in.nextInt());
        } else if (temp == 3) {
            System.out.println("您当前的余额为 " + checkBalance() + "￥");
        } else if (temp == 4) {
            Bank.closeAccount();
        } else return false;
        return true;
    }
}