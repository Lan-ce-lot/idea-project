package work.experiment.test1;

import java.util.Calendar;

/**
 * A program for viewing images.
 *
 * @author Lance
 * @version 1.00 2020-03-08
 */
public class TestApp {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Calendar c = Calendar.getInstance();
        int year = c.get(Calendar.YEAR);
        System.out.println(year + "年");
        for(int i = 0 ; i < 12 ; i++){
            c.set(Calendar.MONTH, i);
            print(c);
        }
    }

    private static void print(Calendar c) {
        System.out.println("************************");
        // TODO Auto-generated method stub
        int month = c.get(Calendar.MONTH)+1;
        System.out.println(month+"月");
        System.out.println("周日 周一 周二 周三 周四 周五 周六  ");
        c.set(Calendar.DAY_OF_MONTH, 1);
        int date = c.get(Calendar.DAY_OF_WEEK);
        for(int i = 1 ; i < date ; i++){
            System.out.print("   ");
        }
        while(c.get(Calendar.MONTH) == month - 1){ //重点，推出循环
            if(c.get(Calendar.DAY_OF_MONTH) < 10){
                System.out.print(" "+c.get(Calendar.DAY_OF_MONTH) + " ");
            }else{
                System.out.print(""+c.get(Calendar.DAY_OF_MONTH) + " ");
            }
            if(c.get(Calendar.DAY_OF_WEEK) == 7){
                System.out.println();
            }
            date = c.get(Calendar.DAY_OF_MONTH);
            date = date + 1;
            c.set(Calendar.DAY_OF_MONTH, date);
        }
        System.out.println();

    }

}