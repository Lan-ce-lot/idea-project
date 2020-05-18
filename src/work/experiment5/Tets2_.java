package work.experiment5;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/**
 * A program for viewing images.
 *
 * @author Lance
 * @version 1.00 2020-03-08
 */
public class Tets2_ {
    public static void main(String[] args) {
        System.out.println();
    }
    /**
     * 日期间隔计算
     * 计算公式(示例):
     *      20121201- 20121212
     *      取出20121201这一年过了多少天 d1 = 天数  取出 20121212这一年过了多少天 d2 = 天数
     *      如果2012年这一年有366天就要让间隔的天数+1，因为2月份有 29日。
     * @param maxDays   用于记录一年中有365天还是366天
     * @param d1    表示在这年中过了多少天
     * @param d2    表示在这年中过了多少天
     * @param y1    当前为2012年
     * @param y2    当前为2012年
     * @param calendar  根据日历对象来获取一年中有多少天
     * @return  计算后日期间隔的天数
     */
    public static int numerical(int maxDays, int d1, int d2, int y1, int y2, Calendar calendar){
        int day = d1 - d2;
        int betweenYears = y1 - y2;
        List d366 = new ArrayList();

        if(calendar.getActualMaximum(Calendar.DAY_OF_YEAR) == 366){
            System.out.println(calendar.getActualMaximum (Calendar.DAY_OF_YEAR));
            day += 1;
        }

        for (int i = 0; i < betweenYears; i++) {
            // 当年 + 1 设置下一年中有多少天
            calendar.set(Calendar.YEAR, (calendar.get (Calendar.YEAR)) + 1);
            maxDays = calendar.getActualMaximum (Calendar.DAY_OF_YEAR);
            // 第一个 366 天不用 + 1 将所有366记录，先不进行 加入然后再少加一个
            if(maxDays != 366){
                day += maxDays;
            }else{
                d366.add(maxDays);
            }
            // 如果最后一个 maxDays 等于366 day - 1
            if(i == betweenYears-1 && betweenYears > 1 && maxDays == 366){
                day -= 1;
            }
        }

        for(int i = 0; i < d366.size(); i++){
            // 一个或一个以上的366天
            if(d366.size() >= 1){
                day =  (day + (int)d366.get(i));
            }
        }
        return day;
    }

}