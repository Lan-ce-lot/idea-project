package work.experiment3;


import java.util.Scanner;

/**
 * A program for viewing images.
 *
 * @author Lance
 * @version 1.00 2020-03-08
 */
public class CurrentAccount extends BankAccount {

    public double overdraft = 500;

    public CurrentAccount() { }

    public CurrentAccount(String accountName, double balance, String accountId, String email, String password, int accountType, double overdraft) {
        super(accountName, balance, accountId, email, password, accountType);
        this.overdraft = overdraft;
    }

    public void withdrawal(double amount) {
        balance -= amount;
        if (balance < 0) {
            System.out.println("您已透支" + (-balance) + '￥');
            /**
             *
             */
        }
    }

    public void opreate() {
        System.out.println("1.存款/2.取款/3.余额/4.查询透支额度/5.关闭账号/6.退出");
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
            System.out.println("您当前的透支额度为 " + overdraft + "￥");
        } else if (temp == 5){
            Bank.closeAccount();
        } else return;
    }

    public static void main(String[] args) {

    }
}