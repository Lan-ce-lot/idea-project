package work.experiment2;

import Sql.MySQLDemo;
import learn.interest.ImageSetTest;

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
    private  String firstname;
    private String phoneNumbers;
    private String memberNumber;
    public String geteMail() {
        return eMail;
    }
    public String getPhoneNumbers() {
        return phoneNumbers;
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (true) {
            var n = new Customer();
            n.Membership();
        }
    }
    public void Membership() {
        Scanner in = new Scanner(System.in);
        Pattern p = Pattern.compile("^1[3|4|5|8|9]\\d{9}$");// 匹配电话号码的正则表达式
        Pattern p1 = Pattern.compile("^\\w+([-+.]\\w+)*@\\w+([-.]\\w+)*\\.\\w+([-.]\\w+)*$");// 匹配邮箱的正则表达式
        while (true) {
            System.out.println("请输入姓氏:");
            name = in.next();
            if (!checkLastName(name)) {
                System.out.println("信息输入错误!请重试");
                continue;
            }
            System.out.println("请输入名字:");
            firstname = in.next();
            if (!checkFirstNmae(firstname)) {
                System.out.println("信息输入错误!请重试");
                continue;
            }
            System.out.println("电话/邮箱:(1.电话/2.邮箱)");
            if (in.next().equals("1")) {
                System.out.println("请输入电话号码:");
                phoneNumbers = in.next();
                Matcher matchNumber = p.matcher(getPhoneNumbers());
                if (!matchNumber.matches()) {
                    System.out.println("信息输入错误!请重试");
                    continue;
                }
            } else {
                System.out.println("请输入e-mail:");
                eMail = in.next();
                Matcher matchEmail = p1.matcher(geteMail());
                if (!matchEmail.matches()) {
                    System.out.println("信息输入错误!请重试");
                    continue;
                }
            }
            break;
        }
        if (phoneNumbers != null) {
            memberNumber = getRandomNumber();
            //@！！！！！！！！！！！！！！！
            try {
                Sms.send(memberNumber);
            } catch (Exception e) {
                e.printStackTrace();
            }
            System.out.println("id:" + memberNumber +" 姓:" + name + " 名:" + firstname + " 电话:" + "未输入" + " 邮箱:" + eMail);
            MySQLDemo.inster(memberNumber, name, firstname, phoneNumbers, "未输入");
            System.out.println("发送至手机\n" + name + firstname + "用户" + "您的会员办理成功, 会员号是:" + memberNumber);
        } else {
            memberNumber = getRandomNumber();
            SendFileEmail.send(eMail, memberNumber);
            System.out.println("id:" + memberNumber +" 姓:" + name + " 名:" + firstname + " 电话:" + "未输入" + " 邮箱:" + eMail);
            MySQLDemo.inster(memberNumber, name, firstname, "未输入", eMail);
            System.out.println("发送至邮箱\n" +name + firstname + "用户" + "您的会员办理成功, 会员号是:" + memberNumber);
        }
    }

    public static boolean checkFirstNmae(String name) {
        Pattern pattern = Pattern.compile("[\\u4e00-\\u9fa5]+");// 验证姓名正则
        Matcher matcher = pattern.matcher(name);
        return matcher.matches();
    }

    public static boolean checkLastName(String name) {
        String[] surName = {
                "赵","钱","孙","李","周","吴","郑","王","冯","陈",
                "楮","卫","蒋","沈","韩","杨","朱","秦","尤","许",
                "何","吕","施","张","孔","曹","严","华","金","魏",
                "陶","姜","戚","谢","邹","喻","柏","水","窦","章",
                "云","苏","潘","葛","奚","范","彭","郎","鲁","韦",
                "昌","马","苗","凤","花","方","俞","任","袁","柳",
                "酆","鲍","史","唐","费","廉","岑","薛","雷","贺",
                "倪","汤","滕","殷","罗","毕","郝","邬","安","常",
                "乐","于","时","傅","皮","卞","齐","康","伍","余",
                "元","卜","顾","孟","平","黄","和","穆","萧","尹",
                "姚","邵","湛","汪","祁","毛","禹","狄","米","贝",
                "明","臧","计","伏","成","戴","谈","宋","茅","庞",
                "熊","纪","舒","屈","项","祝","董","梁","杜","阮",
                "蓝","闽","席","季","麻","强","贾","路","娄","危",
                "江","童","颜","郭","梅","盛","林","刁","锺","徐",
                "丘","骆","高","夏","蔡","田","樊","胡","凌","霍",
                "虞","万","支","柯","昝","管","卢","莫","经","房",
                "裘","缪","干","解","应","宗","丁","宣","贲","邓",
                "郁","单","杭","洪","包","诸","左","石","崔","吉",
                "钮","龚","程","嵇","邢","滑","裴","陆","荣","翁",
                "荀","羊","於","惠","甄","麹","家","封","芮","羿",
                "储","靳","汲","邴","糜","松","井","段","富","巫",
                "乌","焦","巴","弓","牧","隗","山","谷","车","侯",
                "宓","蓬","全","郗","班","仰","秋","仲","伊","宫",
                "宁","仇","栾","暴","甘","斜","厉","戎","祖","武",
                "符","刘","景","詹","束","龙","叶","幸","司","韶",
                "郜","黎","蓟","薄","印","宿","白","怀","蒲","邰",
                "从","鄂","索","咸","籍","赖","卓","蔺","屠","蒙",
                "池","乔","阴","郁","胥","能","苍","双","闻","莘",
                "党","翟","谭","贡","劳","逄","姬","申","扶","堵",
                "冉","宰","郦","雍","郤","璩","桑","桂","濮","牛",
                "寿","通","边","扈","燕","冀","郏","浦","尚","农",
                "温","别","庄","晏","柴","瞿","阎","充","慕","连",
                "茹","习","宦","艾","鱼","容","向","古","易","慎",
                "戈","廖","庾","终","暨","居","衡","步","都","耿",
                "满","弘","匡","国","文","寇","广","禄","阙","东",
                "欧","殳","沃","利","蔚","越","夔","隆","师","巩",
                "厍","聂","晁","勾","敖","融","冷","訾","辛","阚",
                "那","简","饶","空","曾","毋","沙","乜","养","鞠",
                "须","丰","巢","关","蒯","相","查","后","荆","红",
                "游","竺","权","逑","盖","益","桓","公","仉","督",
                "晋","楚","阎","法","汝","鄢","涂","钦","归","海",
                "岳","帅","缑","亢","况","后","有","琴","商","牟",
                "佘","佴","伯","赏","墨","哈","谯","笪","年","爱",
                "阳","佟"};
        String[] compoundNmae = {
                "万俟","司马","上官","欧阳","夏侯",
                "诸葛","闻人","东方","赫连","皇甫",
                "尉迟","公羊","澹台","公冶","宗政",
                "濮阳","淳于","单于","太叔","申屠",
                "公孙","仲孙","轩辕","令狐","锺离",
                "宇文","长孙","慕容","鲜于","闾丘",
                "司徒","司空","丌官","司寇","南宫",
                "子车","颛孙","端木","巫马","公西",
                "漆雕","乐正","壤驷","公良","拓拔",
                "夹谷","宰父","谷梁","段干","百里",
                "东郭","南门","呼延","羊舌","微生",
                "梁丘","左丘","东门","西门"};
        if (name.length() == 1) {
            for (var i : surName) {
                if (i.equals(name)) {
                    return true;
                }
            }
            return false;
        } else {
            for (var i : compoundNmae) {
                if (i.equals(name)) {
                    return true;
                }
            }
            return false;
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
                        System.out.println("请问KFC还是带走(1.KFC/2.带走/需要取消订单按Q)");
                        if (in.next().equals("Q")) {
                            System.out.println("订单已取消, 谢谢使用!");
                            return;
                        }
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
            } else System.out.println("输入错误哦...请重试");
        }
    }

    public boolean queryMember() {
        System.out.println(prise + "请问您是会员吗?(Y/N)");
        if (in.next().equals("Y")) {
            while (true) {
                System.out.println("请输入会员号");
                String id = in.next();
                if (MySQLDemo.query(id)) {
                    System.out.println("尊贵的会员" + id + ", 您可享受会员价");
                    return true;
                } else System.out.println("会员号输入错误!请重试");
            }
        } else {
            System.out.println("需要办理会员吗?(Y/N)");
            if (in.next().equals("Y")) {
                Customer customer = new Customer();
                customer.Membership();
                return true;
            } else return false;
        }
    }

    public void payWay() {
        System.out.println("需支付:" + prise + "￥");
        System.out.println("请选择支付方式(1.原价 2.会员价 3.积分)");
        String temp = in.next();
        if (temp.equals("1")) {
            System.out.println("(1.现金 2.扫码)");
            temp = in.next();
            if (temp.equals("2")) {
                System.out.println("(1.支付宝 2.微信)");
                if (in.next().equals("1")) {
                    ImageSetTest N = new ImageSetTest("1");
                } else {
                    ImageSetTest N = new ImageSetTest();
                }
            } System.out.println("共" + prise + "￥, 支付成功!");
        } else if (temp.equals("2")) {
            System.out.println("(1.现金 2.扫码)");
            temp = in.next();
            if (temp.equals("2")) {
                System.out.println("(1.支付宝 2.微信)");
                if (in.next().equals("1")) {
                    ImageSetTest N = new ImageSetTest("1");
                } else {
                    ImageSetTest N = new ImageSetTest();
                }
            }
            System.out.printf("共%.2f￥, 支付成功!(会员享8折优惠)\n", (prise * 0.8));
        } else System.out.println("积分支付成功!");
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
        int count = 0;
        LinkedHashMap<String, Integer> p = new LinkedHashMap<String, Integer>();
        p.put("不辣", 0);
        p.put("微辣", 0);
        p.put("中辣", 0);
        for (var it : Meals.kfcPackage.keySet()) {
            System.out.println(Meals.kfcPackage.get(it).name + ": " + Meals.kfcPackage.get(it).choose);
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
            count += p.get(it);
            int value = p.get(it) * 12 + 11;
            System.out.println(it + ": " + p.get(it));
            int step = (i + 1) * 40;//设置每隔柱形图的水平间隔为40
            //绘制矩形
            g2.fillRoundRect(leftMargin + step * 2, Height - value, 40, value, 0, 0);
            //列出产品的编号
            g2.drawString(it, leftMargin + step * 2, Height - value - 5);
            i++;
        }
        System.out.println("总销售量: " + count);
    }
}