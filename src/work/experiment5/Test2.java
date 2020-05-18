package work.experiment5;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class Test2 {
    public static void main(String[] args) {
        // 得到当前时间

        Calendar ca = Calendar.getInstance();
//        ca.set(2020, 10, 18);
        System.out.println("今天是: " +
                ca.get(GregorianCalendar.YEAR) + "年" +
                (ca.get(GregorianCalendar.MONTH) + 1) + "月" +
                ca.get(GregorianCalendar.DAY_OF_MONTH) + "日");

        printDaysApart(ca);
    }

    public static void printDaysApart(Calendar ca) {
        Calendar b = new GregorianCalendar();
        // b设置为国庆节日期, 9代表10月
        b.set(ca.get(GregorianCalendar.YEAR), 9, 1);
        // 如果今年国庆已过, 则+1转成明年国庆
        if (b.getTimeInMillis() < ca.getTimeInMillis())
            b.set(ca.get(GregorianCalendar.YEAR) + 1, 9, 1);
        // 日历的时间值单位(毫秒), 除 (1000 * 60 * 60 * 24)转成单位(天)
        long diffDays = (b.getTimeInMillis() - ca.getTimeInMillis()) / (1000 * 60 * 60 * 24);
        System.out.println("距离国庆: " + diffDays + " 天");
    }
}