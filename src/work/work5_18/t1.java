package work.work5_18;

/**
 * A program for viewing images.
 *
 * @author Lance
 * @version 1.00 2020-03-08
 */
//public class t1 {
//    public static void main(String[] args) {
//
//    }
//}

//class A {
//    abstract void unfinished() {
//    }
//}

public abstract class t1 {

        public static void main(String[] args) {
            Number[] numberArray = new Integer[2];
            System.out.println(Test.getType(numberArray));
            numberArray[0]=new Double(1.5);
    }
}

class Test
{
    public static void main(String[] args)
    {
        int i=1; //int类型变量
        System.out.println(getType(i)); //打印变量类型为int
    }
    public static String getType(Object o){ //获取变量类型方法
        return o.getClass().toString(); //使用int类型的getClass()方法
    }
}