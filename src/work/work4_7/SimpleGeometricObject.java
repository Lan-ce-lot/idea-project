package work.work4_7;

import java.util.Scanner;

public class SimpleGeometricObject {
    private String color = "white";
    private boolean filled;
    private java.util.Date dateCreated;

    /**
     * Construct a default geometric object
     */
    public SimpleGeometricObject() {
        dateCreated = new java.util.Date();
    }

    /**
     * Construct a geometric object with the specified color
     * and filled value
     */
    public SimpleGeometricObject(String color, boolean filled) {
        dateCreated = new java.util.Date();
        this.color = color;
        this.filled = filled;
    }

    /**
     * Return color
     */
    public String getColor() {
        return color;
    }

    /**
     * Set a new color
     */
    public void setColor(String color) {
        this.color = color;
    }

    /**
     * Return filled. Since filled is boolean,
     * its get method is named isFilled
     */
    public boolean isFilled() {
        return filled;
    }

    /**
     * Set a new filled
     */
    public void setFilled(boolean filled) {
        this.filled = filled;
    }

    /**
     * Get dateCreated
     */
    public java.util.Date getDateCreated() {
        return dateCreated;
    }

    /**
     * Return a string representation of this object
     */
    public String toString() {
        return "created on " + dateCreated + "\ncolor: " + color +
                " and filled: " + filled;
    }
}

class Triangle extends SimpleGeometricObject {
    private double side1 = 1.0;
    private double side2 = 1.0;
    private double side3 = 1.0;

    public Triangle() {
    }

    public Triangle(double side1, double side2, double side3) {
        this.side1 = side1;
        this.side2 = side2;
        this.side3 = side3;
    }

    public Triangle(String color, boolean filled, double side1, double side2, double side3) {
        super(color, filled);
        this.side1 = side1;
        this.side2 = side2;
        this.side3 = side3;
    }

    public double getSidel() {
        return side1;
    }

    public double getSide2() {
        return side2;
    }

    public double getSide3() {
        return side3;
    }

    public double getArea() {
        double s = getPerimeter() / 2.0;
        return Math.sqrt(s * (s - side1) * (s - side2) * (s - side3));
    }

    public double getPerimeter() {
        return (side1 + side2 + side3);
    }

    public  String toString() {
        return "Triangle: side1 = " + side1 + " side2 = " + side2 + " side3 = "+ side3;
    }

    public static void main(String[] args) {
        System.out.println("请输入三角形颜色和三边:");
        Scanner in = new Scanner(System.in);
        Triangle t = new Triangle(in.next(), true, in.nextDouble(), in.nextDouble(),in.nextDouble());

        System.out.println("三角形周长:" + t.getPerimeter());

        System.out.println("三角形面积:" + t.getArea());

        System.out.println("三角形边长:" + t.toString());

        System.out.println("三角形颜色:" + t.getColor());

        System.out.println("三角形是否填充:" + t.isFilled());

    }
}
//class Triangle extends SimpleGeometricObject
//{
//    private double side1=1.0;
//    private double side2=1.0;
//    private double side3=1.0;
//    public Triangle(){
//
//    }
//    public Triangle(double side1,double side2,double side3)
//    {
//        this.side1=side1;
//        this.side2=side2;
//        this.side3=side3;
//    }
//    public Triangle(String color, boolean filled, double side1, double side2, double side3) {
//        super(color, filled);
//        this.side1 = side1;
//        this.side2 = side2;
//        this.side3 = side3;
//    }
//    public double getSide1()
//    {
//        return side1;
//    }
//    public double getSide2()
//    {
//        return side2;
//    }
//    public double getSide3()
//    {
//        return side3;
//    }
//    public double getArea()
//    {
//        double s=(side1+side2+side3)/2;
//        double area=Math.sqrt(s*(s-side1)*(s-side2)*(s-side3));
//        return area;
//    }
//    public double getPerimeter()
//    {
//        return (side1+side2+side3);
//    }
//    public String toString0()
//    {
//        return "Triangle: side1 = " + side1 + " side2 = " + side2 +"side3="+ side3;
//    }
//        public static void main(String[] args) {
//        System.out.println("请输入三角形颜色和三边:");
//        Scanner in = new Scanner(System.in);
//        Triangle t = new Triangle(in.next(), true, in.nextDouble(), in.nextDouble(),in.nextDouble());
//
//        System.out.println("三角形周长:" + t.getPerimeter());
//
//        System.out.println("三角形面积:" + t.getArea());
//
//        System.out.println("三角形边长:" + t.toString());
//
//        System.out.println("三角形颜色:" + t.getColor());
//
//        System.out.println("三角形是否填充:" + t.isFilled());
//
//    }
//}