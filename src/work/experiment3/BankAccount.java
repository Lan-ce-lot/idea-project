package work.experiment3;

public class BankAccount {
    public String accountName;
    public double balance;
    public String accountId;
    public String email;
    public String password;             //密码
    public int accountType;             // 账号类型分1.活期账户,2.普通账户,3.储蓄账户
    public boolean freeze = false;      //冻结暂停

    public BankAccount() {
    }

    public BankAccount(String accountName, double balance, String accountId, String email, String password, int accountType) {
        this.accountName = accountName;
        this.balance = balance;
        this.accountId = accountId;
        this.email = email;
        this.password = password;
        this.accountType = accountType;
    }

    public void withdrawal(double amount) {
        balance -= amount;
        System.out.println("取款成功!您现在的余额为" + checkBalance() + "￥");
    }

    public void deposit(double amount) {
        balance += amount;
        System.out.println("存款成功!您现在的余额为" + checkBalance() + "￥");
    }

    public double checkBalance() {
        return balance;
    }

    public void opreate() {
        System.out.println("BUG!!!!");// 用于多态
    }

    public static void main(String[] args) {

    }
}