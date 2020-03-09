package learn;

/**
 * A program for viewing images.
 *
 * @author Lance
 * @version 1.00 2020-03-08
 */
public class FengZhuang {
    public static void main(String[] args) {
        Test a = new Test();
        a.setAge(10);
        System.out.println(a.getAge());
    }
}

class Test {
    private int age;
    private String name;


//    public Test(int age, String name) {
//        this.age = age;
//        this.name = name;
//    }

    public int getAge() {
        return age;
    }

    public String getName() {
        return name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setName(String name) {
        this.name = name;
    }
}