package work.work3_31;

public class Test1 {
    public static void main(String[] args) {
        Course c = new Course("JAVA语言程序设计");
        c.addStudent("张三");
        c.addStudent("李四");
        c.addStudent("王五");
        c.dropStudent("王五");
        String students[] = c.getStudents();
        for (int i = 0; i < c.getNumberOfStudents(); i++) {
            System.out.println(students[i]);
        }

    }
}

class Course {
    private String courseName;
    private String[] students = new String[100];
    private int numberOfStudents;


    public Course(String courseName) {
        this.courseName = courseName;
    }

    // 利用倍增思想
    public void addStudent(String student) {
        if (numberOfStudents >= students.length) {
            String[] temp = new String[students.length * 2];
            System.arraycopy(students, 0, temp, 0, students.length);
            students = temp;
        }
        students[numberOfStudents++] = student;
    }

    public String[] getStudents() {
        return students;
    }

    public int getNumberOfStudents() {
        return numberOfStudents;
    }

    public String getCourseName() {
        return courseName;
    }

    public void dropStudent(String student) {
        for (int i = 0; i < numberOfStudents; i++) {
            if (student == students[i]) {
                // 利用arraycopy函数将[i + 1, numberOfStudents]先前移动，把students[i]覆盖
                System.arraycopy(students, i + 1, students, i, numberOfStudents - i - 1);
                numberOfStudents--;
                break;
            }
        }
    }

    public void clear() {
        students = new String[100];
        numberOfStudents = 0;
    }
}