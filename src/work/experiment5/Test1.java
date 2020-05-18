package work.experiment5;

public class Test1 {

    public static void main(String[] args) {
        java.util.Scanner input = new java.util.Scanner(System.in);

        System.out.println("请您输入是否填充:");
        boolean filled = true;
        if (input.next().equals("是")) filled = true;
        else filled = false;

        System.out.println("请您输入颜色:");
        String color = input.next();

        System.out.println("请您输入三角形的三条边:");
        double side1 = input.nextDouble();
        double side2 = input.nextDouble();
        double side3 = input.nextDouble();

        GeometricObject triangle = new Triangle(filled, color, side1, side2, side3);

        System.out.println("填充: " + triangle.isFilled());
        System.out.println("颜色: " + triangle.getColor());
        System.out.println("边1: " + side1 + "\n边2: " + side2 + "\n边3: " + side3);
        System.out.printf("面积: %.2f\n", triangle.getArea());
        System.out.println("周长: " + triangle.getPerimater());
    }
}

abstract class GeometricObject {

    private boolean filled;
    private String color;

    protected GeometricObject() {
        this(false, "white");
    }

    protected GeometricObject(boolean filled, String color) {
        this.filled = filled;
        this.color = color;
    }

    public boolean isFilled() {
        return filled;
    }

    public void setFilled(boolean filled) {
        this.filled = filled;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public abstract double getArea();

    public abstract double getPerimater();
}

class Triangle extends GeometricObject {
    private double side1;
    private double side2;
    private double side3;

    public Triangle() {
        super();
    }

    public Triangle(boolean filled, String color, double side1, double side2, double side3) {
        super(filled, color);
        this.side1 = side1;
        this.side2 = side2;
        this.side3 = side3;
    }

    public double getSide1() {
        return side1;
    }

    public void setSide1(double side1) {
        this.side1 = side1;
    }

    public double getSide2() {
        return side2;
    }

    public void setSide2(double side2) {
        this.side2 = side2;
    }

    public double getSide3() {
        return side3;
    }

    public void setSide3(double side3) {
        this.side3 = side3;
    }

    public double getArea() {
        double area = Math.sqrt((getPerimater() / 2) * (getPerimater() / 2 - side1) *
                (getPerimater() / 2 - side2) * (getPerimater() / 2 - side3));
        return area;
    }

    public double getPerimater() {
        return side1 + side2 + side3;
    }
}
