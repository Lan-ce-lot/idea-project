package work.experiment.test1;
import java.util.Scanner;
/*1.	固定价格
各种套餐选择
1.1 附加
附加餐点选择
1.2用餐选择
“KFC”和“带走”。
1.3会员
然后询问客户是否有“会员号”。如果他/她没有会员号码，他/她可以通过输入名字来选择加入会员姓氏、电子邮件和/或手机号码。名字和姓氏都是必须的，
而且在电子邮件和手机号码之间至少有一个。输入并按确认后，客户将收到一封电子邮件和/或一条带有8位会员号码的短信。
1.4付款
现金支付或会员价支付，或者消耗积分。
2.管理制度
2.1修改品种及其价格
应该可以修改期权的价格，并指出期权是否不可用。
2.2查看统计信息
应该可以可视化一份报告，显示菜单上每个项目在过去一周（周一到周日）的销售次数。
为了“辣”的东西应显示出顾客选择的最受欢迎的辣度。或者，用户可以要求系统自动生成此报告，
并在周一将其发送到用户的电子邮件。
3.其他要求
•	必须考虑基本限制和错误检查：例如，客户为加入忠诚度计划而输入的数据应采用正确的格式
（有效的名字和姓氏、有效的电子邮件和/或手机号码）。
•	软件应易于使用：即用户应能够使用常识或简单的指令操作软件。
•	软件应该是用户友好的：例如，用户应该能够随时取消操作；它应该在操作过程中及时向用户显示消息；等等。
•	所有输入和输出文件应采用简单的文件格式。*/
class Customer
{
    String name;
    String email;
    long telephoneNumber;
    long member;
    public String getName()
    {
        return name;
    }
    public void setName(String changeName)
    {
        name=changeName;
    }
    public String getEmail()
    {
        return email;
    }
    public void setEmail(String changeEmail)
    {
        email=changeEmail;
    }
    public long getTelephoneNumber()
    {
        return telephoneNumber;
    }
    public void setTelephoneNumber(long changeTelephoneNumber)
    {
        telephoneNumber=changeTelephoneNumber;
    }
    public long getMember()
    {
        return member;
    }
    public void setMember(long changeMember)
    {
        member=changeMember;
    }
}
class CommodityKindAndPrice
{
    MenuList[] menu=new MenuList[20];
    CommodityKindAndPrice()
    {
        int i;
        for(i=0;i<menu.length;i++)
        {
            menu[i]=new MenuList();
            menu[i].count=i;
        }
        menu[0].dishName="新奥尔良烤翅    "; menu[0].dishPrice=23; menu[0].data.year=2020;menu[0].data.month=3; menu[0].data.day=20;
        menu[0].data2.year=2020;menu[0].data2.month=6; menu[0].data2.day=20;menu[0].spicy="辣";
        menu[1].dishName="新奥尔良鸡腿堡 ";menu[1].dishPrice=45; menu[1].data.year=2020; menu[1].data.month=3;menu[1].data.day=20;
        menu[1].data2.year=2020;menu[1].data2.month=6; menu[1].data2.day=20;menu[1].spicy="不辣";
        menu[2].dishName="劲爆鸡米花        "; menu[2].dishPrice=20;	menu[2].data.year=2020; menu[2].data.month=3; menu[2].data.day=20;
        menu[2].data2.year=2020;menu[2].data2.month=6; menu[2].data2.day=20;menu[2].spicy="辣";
        menu[3].dishName="老北京鸡肉卷     "; menu[3].dishPrice=38; menu[3].data.year=2020;menu[3].data.month=3; menu[3].data.day=20;
        menu[3].data2.year=2020;menu[3].data2.month=6; menu[3].data2.day=20;menu[3].spicy="不辣";
        menu[4].dishName="菌菇堡奥堡        ";menu[4].dishPrice=49; menu[4].data.year=2020; menu[4].data.month=3;menu[4].data.day=20;
        menu[4].data2.year=2020;menu[4].data2.month=6; menu[4].data2.day=20;menu[4].spicy="不辣";
        menu[5].dishName="九珍果汁            "; menu[5].dishPrice=18;menu[5].data.year=2020; menu[5].data.month=3; menu[5].data.day=20;
        menu[5].data2.year=2020;menu[5].data2.month=6; menu[5].data2.day=20;menu[5].spicy="冰";

    }
    public void printCommodity()
    {
        int i=0;
        System.out.println("商品信息：");
        while(menu[i].dishName!=null)
        {
            System.out.printf("%-2d",menu[i].count);
            System.out.print(menu[i].dishName+"\t");
            System.out.printf("%6.2f元   ",menu[i].dishPrice);
            System.out.printf("%-4s\n",menu[i].spicy);
            i++;
        }
    }
    public void printInovice(int[] haveOrder,int[] p )
    {
        int i=0;
        double allPrice=0;
        while(haveOrder[i]!=-1)
        {
            System.out.printf("%-2d",menu[haveOrder[i]].count);
            System.out.print(menu[haveOrder[i]].dishName);
            System.out.printf("%-6.2f元   ",menu[haveOrder[i]].dishPrice);
            System.out.printf("%-4s\n",menu[i].spicy);
            allPrice+=menu[haveOrder[i]].dishPrice;
            i++;
        }
        if(p[0]==1)
            System.out.print("您选择的KFC门店是月兔广场门店");
        else
            System.out.print("您选择的KFC门店是商城门店");
        if(p[1]==1)
            System.out.print("\t您选择堂吃");
        else
            System.out.print("\t您选择带走食用");
        if(p[2]==1)
            System.out.print("\t因为您是会员所以全场打九折!\n您一共消费"+(allPrice*0.9));
        else
            System.out.print("\t您不是我们的会员用户！\n您一共消费"+allPrice);
    }
    public void lastWeekOrderReport(int[] order)
    {
        int i=0;
        int[] orderReport= new int[20];
        for(i=0;i<orderReport.length;i++)
        {
            orderReport[i]=(int)Math.random()*50;//给予默认值，通过随机函数产生
            System.out.print(orderReport[i]+"   ");
        }
        i=0;
        while(order[i]>=0)
        {
            orderReport[order[i]]++;
            i++;
        }
        i=0;
        while(order[i]>=0)
        {
            System.out.printf("%-2d",menu[i].count);
            System.out.print(menu[i].dishName);
            System.out.printf("%-6.2f元   ",menu[i].dishPrice);
            System.out.printf("%-4s\t",menu[i].spicy);
            System.out.print(orderReport[i]+"\n");
            i++;
        }

    }
    public void changeCommodity(Data todayData)
    {
        int i=0,k=0;
        Scanner input=new Scanner(System.in);
        System.out.print("请输入要修改哪个菜的信息：");
        i=input.nextInt();
        System.out.println("请根据你要修改的内容输入相应的数字");

        while(k!=-1)
        {
            System.out.println("1:修改菜名 2：修改价格 3：修改开始年份 4：修改开始月份5：修改开始日期");
            System.out.print("6：修改结束年份 7：修改结束月份 8：修改结束日期9：修改顾客喜欢的辣度\n当修改结束后请按-1\n");
            k=input.nextInt();
            switch(k)
            {
                case -1:System.out.println("修改菜品信息结束");break;
                case 1:System.out.print("请修改菜名：");;menu[i].dishName=input.next();break;
                case 2:
                {
                    if(todayData.year>=menu[i].data.year&&todayData.year<=menu[i].data2.year)
                    {
                        if(todayData.month>menu[i].data.month&&todayData.month<menu[i].data2.month)
                        {
                            System.out.print("请修改价格：");
                            menu[i].dishPrice=input.nextDouble();
                        }
                        else if((todayData.month==menu[i].data.month||todayData.month==menu[i].data2.month)
                                &&todayData.day>=menu[i].data.day&&todayData.day<=menu[i].data2.day)
                        {
                            System.out.print("请修改价格：");
                            menu[i].dishPrice=input.nextDouble();
                        }
                        else
                            System.out.println("您要修改的菜品不再可修改的日期之内，不能修改");
                    }
                    else
                        System.out.println("您要修改的菜品不再可修改的日期之内，不能修改");
                    break;}
                case 3:System.out.print("请修改开始年份：");menu[i].data.year=input.nextInt();break;
                case 4:System.out.print("请修改开始月份");menu[i].data.month=input.nextInt();break;
                case 5:System.out.print("请修改开始日子：");menu[i].data.day=input.nextInt();break;
                case 6:System.out.print("请修改结束年份");menu[i].data2.year=input.nextInt();break;
                case 7:System.out.print("请修改结束月份");menu[i].data2.month=input.nextInt();break;
                case 8:System.out.print("请修改结束日子");menu[i].data2.day=input.nextInt();break;
                case 9:System.out.print("请修改菜的辣度信息：");menu[i].spicy=input.next();break;
                default:System.out.println("您输入有误！");k=-2;break;
            }
        }
    }
}
class MenuList
{
    int count;
    String dishName;
    double dishPrice;
    Data data =new Data();
    Data data2=new Data();
    String spicy;
}
class Data
{
    int year;
    int month;
    int day;
}
public class KFCOrderSystem {

    public static void main(String[] args)
    {
        // TODO 自动生成的方法存根
        //KFCOrderSystem.chooseWhichKFC(0);
        int k=0;
        Scanner input=new Scanner(System.in);
        System.out.print("输入1进入点餐系统；输入2进入管理系统,输入-1以结束");
        k=input.nextInt();
        CommodityKindAndPrice printCommodity=new CommodityKindAndPrice();
        while(k!=-1)
        {
            if(k==1)
            {
                System.out.print("您需要一份之前一周的订单销售次数吗？\n需要请按0，不需要请按1:");
                int answer=input.nextInt();
                int[] order= {1,3,5,1,2,-1};
                if(answer==0)
                {
                    printCommodity.lastWeekOrderReport(order);
                }
                int[] p =new int[3];
                chooseWhichKFC();//要记录一下在哪吃的
                p[0]=input.nextInt();//用于记录顾客选择哪家kfc
                p[1]=diningChoice();//用于记录顾客堂吃还是带走
                printCommodity.printCommodity();
                int[] haveOrder=orderCommodity();
                p[2]=isMember();
                printCommodity.printInovice(haveOrder,p);
                System.out.print("点单结束，继续点单请按1，结束点单请按-1");
                k=input.nextInt();
            }
            else if(k==2)
            {
                Data todayData=new Data();
                System.out.print("请输入今天的年月日！");
                todayData.year=input.nextInt();
                todayData.month=input.nextInt();
                todayData.day=input.nextInt();
                printCommodity.printCommodity();
                printCommodity.changeCommodity(todayData);
                printCommodity.printCommodity();
                System.out.print("更改商品信息结束\n请输入-1以结束程序\t输入1进入点单系统\t输入2再次进入管理系统");
                k=input.nextInt();
            }
        }
    }

    //附近餐点选择
    public static void chooseWhichKFC()
    {
        System.out.println("附近的餐点有：\n1.月兔广场 \n2.商城");
    }
    //用餐选择设想为0：kfc 1：带走
    public static int diningChoice()
    {
        int k=0;
        Scanner input=new Scanner(System.in);
        System.out.println("在店里吃，还是带走?\n在店内吃请按1；带走按2");
        k=input.nextInt();
        return k;

    }
    public static int[] orderCommodity()
    {
        System.out.println("请输入您想要的菜的编号(输入-1以结束点菜)：");
        int[] order=new int[20];
        int i=0;
        Scanner input =new Scanner(System.in);
        for(i=0;i<order.length;i++)
        {
            order[i]=input.nextInt();
            if(order[i]==-1)
                break;
        }
        return order;

    }

    //确认是否是会员,按道理会员可打折，暂时懒得写
    public static int isMember()
    {
        int k=0;
        System.out.println("是否是会员？是请按1，不是按0,如果不需要注册请按-1");
        Scanner input=new Scanner(System.in);
        k=input.nextInt();
        if(k==0)
        {
            System.out.println("您正在注册会员!\n姓名必须填入，邮箱和电话号码要有一个");
            Customer newMember=new Customer();
            long changeTelephoneNumber=1;
            String changeName,changeEmail;
            do
            {
                System.out.print("请输入您的姓名：");
                changeName=input.next();
                newMember.setName(changeName);
                System.out.print("请输入您的email：");
                changeEmail=input.next();

                newMember.setEmail(changeEmail);
                System.out.print("请输入您的电话号码：");
                changeTelephoneNumber=input.nextLong();
                newMember.setTelephoneNumber(changeTelephoneNumber);
                //System.out.print(changeName+" "+changeEmail+" "+changeTelephoneNumber);
            }while(changeName==null&&(changeEmail==null||changeTelephoneNumber==0));
            double temp=Math.random()*100000001;
            @SuppressWarnings("deprecation")
            long changeMember=new Double(temp).longValue();
            newMember.setMember(changeMember);
            //System.out.print(changeMember);
            System.out.print("恭喜您！会员注册完毕\n");
            k=1;
        }

        return k;
    }
}
