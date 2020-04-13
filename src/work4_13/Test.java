package work4_13;

public class Test {
    public static void main(String[] args) {
        Person p = new Person("张三", "江西", "19914665732", "1617025845@qq.com");
        Student student = new Student("李四", "江西", "19914665732", "1617025845@qq.com", "大一");
        Employee e = new Employee("王五", "江西", "19914665732", "1617025845@qq.com", "办公室", 1000.0, "2020-4-13");
        Faculty f = new Faculty("赵六", "江西", "19914665732", "1617025845@qq.com", "办公室", 100.0, "2020-4-13","08:30", 1);
        Staff s = new Staff("田七", "江西", "19914665732", "1617025845@qq.com", "办公室", 100.0, "2020-4-13","部长");
        System.out.println(p.toString());
        System.out.println(student.toString());
        System.out.println(e.toString());
        System.out.println(f.toString());
        System.out.println(s.toString());
    }
}

class Person {
    String name;
    String address;
    String phoneNumber;
    String email;

    Person() {}

    Person(String name, String address, String phoneNumber, String email) {
        this.name = name;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }

    public String toString() {
        return "Person " + name;
    }
}

class Student extends Person {
    final String class1 = "大一";
    final String class2 = "大二";
    final String class3 = "大三";
    final String class4 = "大四";
    String classStatus;

    public Student() {}

    public Student(String name, String address, String phoneNumber, String email, String classStatus) {
        super(name, address, phoneNumber, email);
        this.classStatus = classStatus;
    }

    public String toString() {
        return "Student " + name;
    }
}

class Employee extends Person {
    String office;
    double salary;
    String date;

    public Employee() {}
    public Employee(String name, String address, String phoneNumber, String email, String office, double salary, String date) {
        super(name, address, phoneNumber, email);
        this.office = office;
        this.salary = salary;
        this.date = date;
    }

    public String toString() {
        return "Employee " + name;
    }
}

class Faculty extends Employee {
    String time;
    int level;

    public Faculty() {}
    public Faculty(String name,String address,String phoneNumber,String email,String office,double salary,String date,String time,int level) {
        super(name, address, phoneNumber, email, office, salary, date);
        this.time = time;
        this.level = level;
    }

    public String toString() {
        return "Faculty " + name;
    }
}

class Staff extends Employee {
    String positionName;

    public Staff() {}
    public Staff(String name, String address, String phoneNumber, String email, String office, double salary, String date,String positionName) {
        super(name, address, phoneNumber, email, office, salary, date);
        this.positionName = positionName;
    }

    public String toString() {
        return "Staff " + name;
    }
}