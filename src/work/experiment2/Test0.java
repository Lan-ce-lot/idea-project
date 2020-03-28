package work.experiment2;

import java.util.LinkedHashMap;
import java.util.Queue;
import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.CountDownLatch;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


/**
 * A program for viewing images.
 *
 * @author Lance
 * @version 1.00 2020-03-08
 */

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JFrame;



public class Test0 {
    public static void main(String[] args) {
//        Customer customer = new Customer();
//        System.out.println(customer.getRandomNumber());
        Meals.init();

        while (true) {
            Meals.printMenu();
            Order order = new Order();

            order.selectPackage();
            for (var i : Meals.kfcPackageChoose.keySet()) {
                System.out.println(i + ' ' + Meals.kfcPackageChoose.get(i));
            }
            for (var i : Meals.additionalMealChoose.keySet()) {
                System.out.println(i + ' ' + Meals.additionalMealChoose.get(i));
            }
            Demo demo = new Demo();
            demo.setVisible(true);
        }
    }
}

class Customer {
    private String name;
    private String eMail;
    private String phoneNumbers;
    private String memberNumber;
    private int loyaltyPoints;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String geteMail() {
        return eMail;
    }

    public void seteMail(String eMail) {
        this.eMail = eMail;
    }

    public String getPhoneNumbers() {
        return phoneNumbers;
    }

    public void setPhoneNumbers(String phoneNumbers) {
        this.phoneNumbers = phoneNumbers;
    }

    public String getMemberNumber() {
        return memberNumber;
    }

    public int getLoyaltyPoints() {
        return loyaltyPoints;
    }

    public void setMemberNumber(String memberNumber) {
        this.memberNumber = memberNumber;
    }

    public void setLoyaltyPoints(int loyaltyPoints) {
        this.loyaltyPoints = loyaltyPoints;
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
            System.out.println("用户" + phoneNumbers + "您的会员办理成功, 会员号是:" + getRandomNumber());
        } else {
            System.out.println("用户" + eMail + "您的会员办理成功, 会员号是:" + getRandomNumber());
        }
    }

    public String getRandomNumber() {
        return String.valueOf((int) (1 + Math.random() * 100000000));
    }
}

class Order {
    Queue<String> kfcPackage;
    Queue<String> additionalMeals;
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
                        prise += Meals.additionalMealPrice.get(select);
                        Meals.additionalMealChoose.put(select, Meals.additionalMealChoose.get(select) + 1);
//                    additionalMeals.offer(select);
                    }
                }
                break;
            }

            if (m.matches()) {
                System.out.println("您已选择套餐" + select + ", Q结束选择");
                prise += Meals.kfcPackagePrice.get(select);
                Meals.kfcPackageChoose.put(select, Meals.kfcPackageChoose.get(select) + 1);
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
    static LinkedHashMap<String, Double> kfcPackagePrice = new LinkedHashMap<String, Double>();
    static LinkedHashMap<String, Double> additionalMealPrice = new LinkedHashMap<String, Double>();
    static LinkedHashMap<String, Long> kfcPackageChoose = new LinkedHashMap<String, Long>();
    static LinkedHashMap<String, Long> additionalMealChoose = new LinkedHashMap<String, Long>();

    public static void init() {

        kfcPackagePrice.put("1", 74.5D);
        kfcPackagePrice.put("2", 43.5D);
        kfcPackagePrice.put("3", 39.5D);
        additionalMealPrice.put("1", 12D);
        additionalMealPrice.put("2", 10D);
        additionalMealPrice.put("3", 8D);
        kfcPackageChoose.put("1", 0L);
        kfcPackageChoose.put("2", 0L);
        kfcPackageChoose.put("3", 0L);
        additionalMealChoose.put("1", 0L);
        additionalMealChoose.put("2", 0L);
        additionalMealChoose.put("3", 0L);
    }

    public static void setKfcPackage(LinkedHashMap<String, Double> kfcPackage) {
        kfcPackagePrice = kfcPackage;
    }

    public static void setAdditionalMeals(LinkedHashMap<String, Double> additionalMeals) {
        additionalMealPrice = additionalMeals;
    }

    public static void setKfcPackagePrice(LinkedHashMap<String, Double> kfcPackagePrice) {
        Meals.kfcPackagePrice = kfcPackagePrice;
    }

    public static void setAdditionalMealPrice(LinkedHashMap<String, Double> additionalMealPrice) {
        Meals.additionalMealPrice = additionalMealPrice;
    }

    public static void printMenu() {
        System.out.printf("%15s\n", "菜单");
        int con = 1;
        for (var i : kfcPackagePrice.entrySet()) {
            System.out.printf("%5s:%15s\n", i.getKey() + ".套餐餐点" + String.valueOf(con++), i.getValue());
        }
        System.out.println("----------------------------");
        con = 1;
        for (var i : additionalMealPrice.keySet()) {
            System.out.printf("%5s:%15s\n", i + ".附件餐点" + String.valueOf(con++), additionalMealPrice.get(i));
        }
        System.out.println("----------------------------");
    }

    public void changeMenu() {

    }
}

class Demo extends JFrame {


    public Demo() {
        super();
        setTitle("可视化报告");
        setBounds(100, 100, 600, 300);
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
        for (var it : Meals.kfcPackageChoose.keySet()) {
            int value = Meals.kfcPackageChoose.get(it).intValue() * 12 + 15;
            int step = (i + 1) * 40;//设置每隔柱形图的水平间隔为40
            //绘制矩形
            g2.fillRoundRect(leftMargin + step * 2, Height - value, 40, value, 40, 10);
            //列出产品的编号
            g2.drawString("套餐" + (i + 1), leftMargin + step * 2, Height - value - 5);
            i++;
        }
        for (var it : Meals.additionalMealChoose.keySet()) {
            int value = Meals.additionalMealChoose.get(it).intValue() * 12 + 15;
            int step = (i + 1) * 40;//设置每隔柱形图的水平间隔为40
            //绘制矩形
            g2.fillRoundRect(leftMargin + step * 2, Height - value, 40, value, 40, 10);
            //列出产品的编号
            g2.drawString("附加餐点" + (i + 1), leftMargin + step * 2, Height - value - 5);
            i++;
        }
    }
}