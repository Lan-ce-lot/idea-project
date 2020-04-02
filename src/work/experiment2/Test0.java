package work.experiment2;

import java.util.LinkedHashMap;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JFrame;

public class Test0 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Meals.init();
        while (true) {
            System.out.println("1.用户系统入口/2.管理系统入口(输入1,2, 其他任意键退出程序)");
            String str = in.next();
            if (str.equals("1")) {
                System.out.println("1.点餐/2.接收可视化报告");
                if (in.next().equals("1")) {
                    Meals.printMenu();
                    Order order = new Order();
                    order.selectPackage();
                } else {
                    System.out.println("请输入您的邮箱");
                    String s = in.next();
                    SendFileEmail.send(s);
                }
            } else if (str.equals("2")) {
                Meals.printMenu();
                System.out.println("1.修改菜单2.一周可视化报告(输入1或2, 其他任意键退出)");
                str = in.next();
                if (str.equals("1")) {
                    Meals.changeMenu();
                } else if (str.equals("2")) {
                    Demo demo = new Demo();
                    demo.setVisible(true);
                } else continue;

            } else return;
        }
    }
}

class Customer {
    private String name;
    private String eMail;
    private String phoneNumbers;
    private String memberNumber;

    public String geteMail() {
        return eMail;
    }

    public String getPhoneNumbers() {
        return phoneNumbers;
    }

    public void Membership() {
        Scanner in = new Scanner(System.in);
        // 匹配电话号码的正则表达式
        Pattern p = Pattern.compile("^1[3|4|5|8|9][0-9]\\d{8}$");
        // 匹配邮箱的正则表达式
        Pattern p1 = Pattern.compile("^\\w+([-+.]\\w+)*@\\w+([-.]\\w+)*\\.\\w+([-.]\\w+)*$");
        while (true) {
            System.out.println("请输入姓名:");
            name = in.next();
            System.out.println("电话/邮箱:(1.电话/2.邮箱)");
            if (in.next().equals("1")) {
                System.out.println("请输入电话号码:");
                phoneNumbers = in.next();
                eMail = " ";
            } else {
                System.out.println("请输入e-mail:");
                eMail = in.next();
                phoneNumbers = " ";
            }
            Matcher matchNumber = p.matcher(getPhoneNumbers());
            Matcher matchEmail = p1.matcher(geteMail());
            if (matchNumber.matches() || matchEmail.matches()) {
                break;
            } else {
                System.out.println("信息输入错误!请重试");
            }
        }
        if (phoneNumbers != " ") {
            memberNumber = getRandomNumber();
            try {
                Sms.send(memberNumber);
            } catch (Exception e) {
                e.printStackTrace();
            }
            System.out.println("用户" + phoneNumbers + "您的会员办理成功, 会员号是:" + memberNumber);
        } else {
            memberNumber = getRandomNumber();
            System.out.println("用户" + eMail + "您的会员办理成功, 会员号是:" + memberNumber);
        }
    }

    public String getRandomNumber() {
        return String.valueOf((int) (1 + Math.random() * 100000000));
    }
}

class Order {
    private double prise;
    Scanner in = new Scanner(System.in);

    public void selectPackage() {
        System.out.println("请选择套餐(输入数字1,2,3...), Q结束选择");
        while (true) {
            String select = in.next();
            Pattern p = Pattern.compile("\\d{1}");
            Matcher m = p.matcher(select);
            if (select.equals("Q")) {
                System.out.println("请选择附加餐点(输入数字1,2,3...), Q结束选择");
                while (true) {
                    select = in.next();
                    if (select.equals("Q")) {
                        System.out.println("请问KFC还是带走(1.KFC/2.带走)");
                        in.next().equals("1");
                        System.out.println("点餐完毕!" + "需支付:" + prise + "￥");
                        queryMember();
                        payWay();
                        break;
                    } else {
                        System.out.println("您已选择附加餐点" + select + ", Q结束选择");
                        prise += Meals.additionalMeal.get(select).prise;
                        Meals.additionalMeal.get(select).choose++;
                    }
                }
                break;
            }

            if (m.matches()) {
                System.out.println("您已选择套餐" + select + ", Q结束选择");
                prise += Meals.kfcPackage.get(select).prise;
                Meals.kfcPackage.get(select).choose++;
            } else {
                System.out.println("输入错误哦...请重试");
            }
        }
    }

    public boolean queryMember() {
        System.out.println(prise + "请问您是会员吗?(Y/N)");

        if (in.next().equals("Y")) {
            System.out.println("请输入会员号");
            System.out.println("尊贵的会员" + in.next() + ", 您可享受会员价");
            return true;
        } else {
            System.out.println("需要办理会员吗?(Y/N)");
            if (in.next().equals("Y")) {
                Customer customer = new Customer();
                customer.Membership();
                return true;
            } else {
                return false;
            }
        }
    }

    public void payWay() {
        System.out.println("需支付:" + prise + "￥");
        System.out.println("请选择支付方式(1.现金 2.会员价 3.积分)");
        String temp = in.next();
        if (temp.equals("1")) {
            System.out.println("共" + prise + "￥, 支付成功!");
        } else if (temp.equals("2")) {
            System.out.printf("共%.2f￥, 支付成功!(会员享8折优惠)\n", (prise * 0.8));
        } else {
            System.out.println("积分支付成功!");
        }
    }
}

class Meals {
    static LinkedHashMap<String, Meal> kfcPackage = new LinkedHashMap<String, Meal>();
    static LinkedHashMap<String, Meal> additionalMeal = new LinkedHashMap<String, Meal>();

    public static void init() {
        kfcPackage.put("1", new Meal(".套餐餐点1", 74.5D, 0, "中辣"));
        kfcPackage.put("2", new Meal(".套餐餐点2", 43.5D, 0, "微辣"));
        kfcPackage.put("3", new Meal(".套餐餐点3", 39.5D, 0, "不辣"));
        additionalMeal.put("1", new Meal(".附件餐点1", 12D, 0, "不辣"));
        additionalMeal.put("2", new Meal(".附加餐点2", 10D, 0, "不辣"));
        additionalMeal.put("3", new Meal(".附加餐点3", 8D, 0, "微辣"));
    }

    public static void printMenu() {
        System.out.printf("%18s\n", "菜单");
        int con = 1;
        for (var i : kfcPackage.entrySet()) {
            System.out.printf("%10s:%15s%10s\n", i.getKey() + i.getValue().name, i.getValue().prise + "￥", i.getValue().pungency);
        }
        System.out.println("-------------------------------------------");
        con = 1;
        for (var i : additionalMeal.keySet()) {
            System.out.printf("%10s:%15s%10s\n", i + additionalMeal.get(i).name, additionalMeal.get(i).prise + "￥", additionalMeal.get(i).pungency);
        }
        System.out.println("-------------------------------------------");
    }

    public static void changeMenu() {
        Scanner in = new Scanner(System.in);
        String temp;
        System.out.println("请选择要修改的餐点类型, 1.套餐/2.附加(输入1或2)");
        if (in.next().equals("1")) {
            System.out.println("请选择套餐(输入1,2,3)");
            temp = in.next();
//            kfcPackage.get(temp);
            System.out.println("请选择修改类型\n1.修改菜名 2.修改价格, 其他键结束修改");
            String temp1 = in.next();
            if (temp1.equals("1")) {
                System.out.println("请输入修改后菜名");
                kfcPackage.get(temp).name = in.next();
            } else if (temp1.equals("2")) {
                System.out.println("请输入修改后价格");
                kfcPackage.get(temp).prise = Double.valueOf(in.next());
            } else return;
        } else {
            System.out.println("请选择附加餐点(输入1,2,3)");
            temp = in.next();
//            additionalMeal.get(temp);
            System.out.println("请选择修改类型\n1.修改菜名 2.修改价格, 其他键结束修改");
            String temp1 = in.next();
            if (temp1.equals("1")) {
                System.out.println("请输入修改后菜名");
                kfcPackage.get(temp).name = in.next();
            } else if (temp1.equals("2")) {
                System.out.println("请输入修改后价格");
//                kfcPackage.get(temp).prise = Integer.valueOf(in.next()).intValue();
                kfcPackage.get(temp).prise = Integer.parseInt(in.next());
            } else return;
        }
        printMenu();
    }
}

class Meal {
    String name;
    double prise;
    int choose;
    String pungency;

    public Meal(String name, double prise, int choose, String pungency) {
        this.name = name;
        this.prise = prise;
        this.choose = choose;
        this.pungency = pungency;
    }
}

class Demo extends JFrame {
    public Demo() {
        super();
        setTitle("一周单品销售次数可视化报告");
        setBounds(100, 100, 900, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void paint(Graphics g) {
        int Width = getWidth();
        int Height = getHeight();
        int leftMargin = 20;//柱形图左边界
        int topMargin = 50;//柱形图上边界
        Graphics2D g2 = (Graphics2D) g;
        int ruler = Height - topMargin - 5;
        int rulerStep = ruler / 10;//将当前的高度评分为10个单位
        g2.setColor(Color.WHITE);//绘制白色背景
        g2.fillRect(0, 0, Width, Height);//绘制矩形图
        g2.setColor(Color.LIGHT_GRAY);
        for (int i = 0; i <= 10; i++) {//绘制灰色横线和百分比
            g2.drawString((20 - i * 2) + "", 5, topMargin + rulerStep * i);//写下百分比
            g2.drawLine(5, topMargin + rulerStep * i, Width, topMargin + rulerStep * i);//绘制灰色横线
        }
        g2.setColor(Color.orange);
        int i = 0;
        LinkedHashMap<String, Integer> p = new LinkedHashMap<String, Integer>();
        p.put("不辣", 0);
        p.put("微辣", 0);
        p.put("中辣", 0);
        for (var it : Meals.kfcPackage.keySet()) {
            System.out.println(Meals.kfcPackage.get(it).name + " " + Meals.kfcPackage.get(it).choose);
            int value = Meals.kfcPackage.get(it).choose * 12 + 11;
            int step = (i + 1) * 40;//设置每隔柱形图的水平间隔为40
            //绘制矩形
            g2.fillRoundRect(leftMargin + step * 2, Height - value, 40, value, 0, 0);
            //列出产品的编号
            g2.drawString("套餐" + (i + 1), leftMargin + step * 2, Height - value - 5);
            p.put(Meals.kfcPackage.get(it).pungency, p.get(Meals.kfcPackage.get(it).pungency) + Meals.kfcPackage.get(it).choose);
            i++;
        }
        g2.setColor(Color.green);
        for (var it : Meals.additionalMeal.keySet()) {
            System.out.println(Meals.additionalMeal.get(it).name + " " + Meals.additionalMeal.get(it).choose);
            int value = Meals.additionalMeal.get(it).choose * 12 + 11;
            int step = (i + 1) * 40;//设置每隔柱形图的水平间隔为40
            //绘制矩形
            g2.fillRoundRect(leftMargin + step * 2, Height - value, 40, value, 0, 0);
            //列出产品的编号
            g2.drawString("附加餐点" + (i + 1 - 3), leftMargin + step * 2, Height - value - 5);
            p.put(Meals.additionalMeal.get(it).pungency, p.get(Meals.additionalMeal.get(it).pungency) + Meals.additionalMeal.get(it).choose);
            i++;
        }
        g2.setColor(Color.red);
        for (var it : p.keySet()) {
            int value = p.get(it) * 12 + 11;
            System.out.println(it + " " + p.get(it));
            int step = (i + 1) * 40;//设置每隔柱形图的水平间隔为40
            //绘制矩形
            g2.fillRoundRect(leftMargin + step * 2, Height - value, 40, value, 0, 0);
            //列出产品的编号
            g2.drawString(it, leftMargin + step * 2, Height - value - 5);
            i++;
        }
    }
}