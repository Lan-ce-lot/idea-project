package opp;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class Test2 {
    public static void main(String[] args) {
        GregorianCalendar C = new GregorianCalendar();
        System.out.println("当前日期:");
        System.out.println(C.get(Calendar.YEAR) + "-" + (C.get(Calendar.MONTH) + 1) + "-" + C.get(Calendar.DAY_OF_MONTH) +'\n');

        C.setTimeInMillis(1234567898765L);
        System.out.println("日期设置特定时间:1234567898765后的日期");
        System.out.println(C.get(Calendar.YEAR) + "-" + (C.get(Calendar.MONTH) + 1) + "-" + C.get(Calendar.DAY_OF_MONTH));
    }

}