//package work.experiment2;
//
//class BankAccount {
//    public int number;//账号
//    public String name;//账户名
//    public double Amount=0;//余额
//    public boolean flag=false;//是否暂停
//    public BankAccount(int number,String name,double amount) {
//        this.number=number;
//        this.name=name;
//        this.Amount=amount;
//    }
//    public boolean getFlag() {
//        return flag;
//    }
//    public void setFlag(boolean flag) {
//        this.flag = flag;
//    }
//    //存款
//    public void deposit(double amount) {
//        if(!getFlag()) {
//            if(amount<=0)
//            {
//                throw new IllegalArgumentException("amount must be greater than zero");
//            }
//            else{
//                Amount+=amount;
//                System.out.println("存款成功");//存款成功
//            }
//        }
//        else {
//            System.out.println("您的账户已被暂停，无法交易！");
//        }
//    }
//    //取款
//    public void withdraw(double amount) {
//        if(!getFlag()) {
//            if(amount<=0)
//            {
//                throw new IllegalArgumentException("amount must be greater than zero");
//            }else if(amount>Amount)
//            {
//                throw new IllegalArgumentException("sumTransactions must be greater than zero");
//            }else{
//                Amount-=amount;
//                System.out.println("取款成功");//取款成功
//            }
//        }
//        else {
//            System.out.println("您的账户已被暂停，无法交易！");
//        }
//    }
//    public int  getNumber() {
//        return number;
//    }
//    public String getName() {
//        return name;
//    }
//    public double sumTransactions() {
//        double amount = 0.0;
//        amount=Amount;
//        return amount;
//    }
//    //打印信息
//    public void tostring() {
//        System.out.println("普通账户："+"账号："+getNumber()+"  账户名："+getName()+"  余额："+sumTransactions()+"  是否暂停："+getFlag());
//    }
//}
//class Current extends BankAccount{
//    public Current(int number,String name,double amount) {
//        super(number,name,amount);
//    }
//    //是否透支
//    public boolean IsOverdraw() {
//        return Amount<-500;
//    }
//    public void withdraw(double amount) {
//        if(!IsOverdraw()) {
//            if(!getFlag()) {
//                if(amount<=0)
//                {
//                    throw new IllegalArgumentException("amount must be greater than zero");
//                }else if(amount>Amount)
//                {
//                    throw new IllegalArgumentException("sumTransactions must be greater than zero");
//                }else{
//                    Amount-=amount;
//                    System.out.println("取款成功");//取款成功
//                }
//            }
//            else {
//                System.out.println("您的账户已被暂停，无法交易！");
//            }
//        }
//        else {
//            System.out.println("您的账户已透支，无法取款!");
//        }
//    }
//    public void tostring() {
//        System.out.println("活期账户："+"账号："+getNumber()+"  账户名："+getName()+"  余额："+sumTransactions()+"  是否暂停："+getFlag());
//    }
//}
//class Savingsaccount extends BankAccount{
//    public boolean appointment;
//    public Savingsaccount(int number,String name,double amount,boolean appointment) {
//        super(number, name, amount);
//        this.appointment=appointment;
//    }
//    public void deposit(double amount) {
//        if(appointment) {
//            if(!getFlag()) {
//                if(amount<=0)
//                {
//                    throw new IllegalArgumentException("amount must be greater than zero");
//                }
//                else{
//                    Amount+=amount;  //存款成功
//                }
//            }
//            else {
//                System.out.println("您的账户已被暂停，无法交易！");
//            }
//        }
//        else {
//            System.out.println("您没有提前7天预约，无法进行交易");
//        }
//
//    }
//    //取款
//    public void withdraw(double amount) {
//        if(appointment) {
//            if(!getFlag()) {
//                if(amount<=0)
//                {
//                    throw new IllegalArgumentException("amount must be greater than zero");
//                }else if(amount>Amount)
//                {
//                    throw new IllegalArgumentException("sumTransactions must be greater than zero");
//                }else{
//                    Amount-=amount;  //取款成功
//                }
//            }
//            else {
//                System.out.println("您的账户已被暂停，无法交易！");
//            }
//        }
//        else {
//            System.out.println("您没有提前7天预约，无法进行交易");
//        }
//    }
//    public void tostring() {
//        System.out.println("储蓄账户："+"账号："+getNumber()+"  账户名："+getName()+"  余额："+sumTransactions()+"  是否暂停："+getFlag());
//    }
//}
//import java.util.*;
//class Bank {
//    public ArrayList<BankAccount> accounts;//账户集合
//    public Bank() {
//        accounts =new ArrayList<BankAccount>();
//    }
//    //开户
//    public void addCustomer(BankAccount account) {
//        accounts.add(account);
//    }
//    //销户
//    public void removeCustomer(BankAccount account) {
//        accounts.remove(account);
//    }
//    //暂停账户
//    public void Suspend(){
//        tostring();
//        System.out.print("请输入要暂停的账户序号:");
//        Scanner input=new Scanner(System.in);
//        int a=input.nextInt();
//        accounts.get(a-1).setFlag(true);
//        System.out.println("该账户已暂停成功！");
//    }
//    //打印账户信息
//    public void tostring() {
//        for(int i=0;i<accounts.size();i++) {
//            System.out.print(i+1+".");
//            accounts.get(i).tostring();
//            System.out.println();
//        }
//    }
//}