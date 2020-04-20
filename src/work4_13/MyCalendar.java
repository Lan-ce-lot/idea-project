package work4_13;

import java.time.DayOfWeek;
import java.time.LocalDate;

/**
 * A program for viewing images.
 *
 * @author Lance
 * @version 1.00 2020-03-08
 * 求可以打印2018年的所有的日期打印输出，请自行阅读下列程序，将空白处补充完整
 */
public class MyCalendar{

    private int year;

    public MyCalendar (int year){

        this.year = year;

    }

    /**

     * 判断指定的年份是否是闰年

     */

    public boolean isLeapYear(int year){

        return year%4==0 && year%100 != 0 || year % 400 == 0;

    }



    /**

     * 获取星期数

     */

    public int getWeekDay(int month){

        int dayOfMonth=getDaysOfMonth(month);    //获得月的天数

        LocalDate date=LocalDate.of(year, month, 1);//获得指定年份月份的日期

        //设置为指定月份的第一天

        DayOfWeek weekDay=date.getDayOfWeek();

        int week=weekDay.getValue()%7;

        return week;

    }



    /**

     * 获取指定月份的总天数

     */

    public int getDaysOfMonth(int month){

        switch(month){

            case 1: case 3: case 5: case 7: case 8: case 10: case 12: return 31;

            case 4: case 6: case 9: case 11: return 30;

            case 2:if(isLeapYear(year))

                return 29;

            else

                return 28;

            default:return -1;

        }

    }





    /**打印*/

    public void print(){

        for(int i=1;i<=12;i++){

//            (5)       ;
            printTitle(i);
            printDays(i);

        }

    }



    /**打印年历的标题*/

    private void printTitle(int month){

        System.out.printf("\n\n%16d年%2d月日历\n",year, month);

        System.out.println(" 日 一 二 三 四 五 六");

    }



    /**打印指定月的月历*/

    private void printDays(int month){

        int week=getWeekDay(month);

        String format="%"+(4*week)+"s";

        if(week>0)

            System.out.printf(format," ");

//        int days=      (6)       ;
        int days= getDaysOfMonth(month)     ;


        for(int i=1;i<=days;i++){

            System.out.printf("%4s",""+i);



            if(     (i + week) % 7 == 0       )

                System.out.println();

        }



        System.out.println();

    }

    public static void main(String[] args){

        MyCalendar c=      new        MyCalendar(2018);

        c.print();

    }

}