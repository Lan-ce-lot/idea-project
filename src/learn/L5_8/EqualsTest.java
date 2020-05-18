package learn.L5_8;


import java.time.LocalDate;
import java.util.Objects;

/**
 * A program for viewing images.
 *
 * @author Lance
 * @version 1.00 2020-03-08
 */
public class EqualsTest {
    public static void main(String[] args) {
        var alice1 = new Employee("A", 75000, LocalDate.of(1987, 12, 15));
        var alice2 = alice1;
        var alice3 = new Employee("A", 75000, LocalDate.of(1987, 12, 15));
        var bob = new Employee("Bob", 50000, LocalDate.of(1989, 10, 1));

        System.out.println("a1 == a2: " + (alice1 == alice2));
        System.out.println("a1 == a3: " + (alice1 == alice3));
        System.out.println("a1.equals(a3): " + alice1.equals(alice3));
        System.out.println("a1.equals(bob): " + alice1.equals(bob));
        System.out.println("bob.toString: " + bob);

        var carl = new Manger("Ca", 80000, LocalDate.of(1987, 12, 15));
        var boss = new Manger("Ca", 80000, LocalDate.of(1987, 12, 15));
        boss.setBonus(5000);
        System.out.println("boss.toSting(): " + boss.toString());
        System.out.println("ca.toString(): " + carl.toString());
        System.out.println("ca.equals(boss): " + carl.equals(boss));
        System.out.println("a1.hashCode(): " + alice1.hashCode());
        System.out.println("a3.hashCode(): " + alice3.hashCode());
        System.out.println("bob.hashCode(): " + bob.hashCode());
        System.out.println("Ca.hashCode(): " + carl.hashCode());


    }
}

class Employee {
    private String name;
    private double salary;
    private LocalDate hireDay;

    public Employee(String name, double salary, LocalDate hireDay) {
        this.name = name;
        this.salary = salary;
        this.hireDay = hireDay;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getSalary() {
        return salary;
    }

    public void raiseSalary(double byPercent) {
        double raise = salary * byPercent / 100;
        salary += raise;
    }

    public LocalDate getHireDay() {
        return hireDay;
    }

    public void setHireDay(LocalDate hireDay) {
        this.hireDay = hireDay;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return Double.compare(employee.salary, salary) == 0 &&
                Objects.equals(name, employee.name) &&
                Objects.equals(hireDay, employee.hireDay);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, salary, hireDay);
    }

    @Override
    public String toString() {
        return getClass().getName() + "{" +
                "name='" + name + '\'' +
                ", salary=" + salary +
                ", hireDay=" + hireDay +
                '}';
    }
}

class Manger extends Employee {

    private double bonus;

    public Manger(String name, double salary, LocalDate hireDay) {
        super(name, salary, hireDay);
        bonus = 0;
    }

    public double getSalay() {
        double baseSalary = super.getSalary();
        return baseSalary + bonus;
    }

    public void setBonus(double bonus) {
        this.bonus = bonus;
    }


    @Override
    public boolean equals(Object o) {
        if (!super.equals(o)) return false;
        Manger manger = (Manger) o;
        return Double.compare(manger.bonus, bonus) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), bonus);
    }

    @Override
    public String toString() {
        return "Manger{" +
                "bonus=" + bonus +
                "} " + super.toString();
    }
}