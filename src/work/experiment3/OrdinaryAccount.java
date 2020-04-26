package work.experiment3;

import java.util.Scanner;

/**
 * A program for viewing images.
 *
 * @author Lance
 * @version 1.00 2020-03-08
 */
public class OrdinaryAccount extends BankAccount {

    public OrdinaryAccount() { }

    public OrdinaryAccount(String accountName, double balance, String accountId, String email, String password, int accountType) {
        super(accountName, balance, accountId, email, password, accountType);
    }

    public void withdrawal(double amount) {
        if (balance < amount) {
            System.out.println("取款失败, 您已账号余额不足, 余额为" + checkBalance() + '￥');

            /**
             *
             */
        } else {
            balance -= amount;
            System.out.println("取款成功, 账号余额为" + checkBalance() + '￥');
        }
    }

    public void opreate() {
        System.out.println("1.存款/2.取款/3.余额/4.关闭账号/5.退出");
        Scanner in = new Scanner(System.in);
        int temp = in.nextInt();
        if (temp == 1) {
            System.out.println("请输入存款金额:");
            deposit(in.nextInt());
        } else if (temp == 2) {
            System.out.println("请输入取款金额:");
            deposit(in.nextInt());
        } else if (temp == 3) {
            System.out.println("您当前的余额为 " + checkBalance() + "￥");
        } else if (temp == 4) {
            Bank.closeAccount();
        } else return;
    }

    public static void main(String[] args) {

    }
}