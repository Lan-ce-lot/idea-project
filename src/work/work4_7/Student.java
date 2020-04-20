package work.work4_7;

class Student {
    public String name;
    public int age;
    public String education;

    public Student() {
    }

    public Student(String name, int age, String education) {
        this.name = name;
        this.age = age;
        this.education = education;
    }

    public void show() {
        System.out.println("姓名:" + name + "  年龄:" + age + "  学历:" + education);
    }
}

//本科生类
class Undergraduate extends Student {
    private String specialty;

    public Undergraduate() {
    }

    public Undergraduate(String name, int age, String education, String specialty) {
        super(name, age, education);
        this.specialty = specialty;
    }

    public void show() {
        System.out.println("姓名:" + name + "  年龄:" + age + "  学历:" + education + "  专业:" + specialty);
    }
}

//研究生类
class Graduate extends Student {
    private String direction;

    public Graduate() {
    }

    public Graduate(String name, int age, String education, String direction) {
        super(name, age, education);
        this.direction = direction;
    }

    public void show() {
        System.out.println("姓名:" + name + "  年龄:" + age + "  学历:" + education + "  方向:" + direction);
    }
}

class TestExtends {
    public static void main(String[] args) {
        Student A = new Student("张三", 18, "大学");
        A.show();
        System.out.println();

        Undergraduate B = new Undergraduate("李四", 22, "本科", "软件工程");
        B.show();
        System.out.println();

        Graduate C = new Graduate("王五", 24, "研究生", "人工智能");
        C.show();
        System.out.println();
    }
}
