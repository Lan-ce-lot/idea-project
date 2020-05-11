package work.work5_11;

public class Test {

    public static void main(String[] args) {
        try {
            method();
            System.out.println("After the method cal1");
        } catch (RuntimeException ex) {
            System.out.println("RuntimeException in main");
        } catch (Exception ex) {
            System.out.println("Exception in main");
        }
    }

    static void method() throws Exception {
        try {
            CircleWithException c1 = new CircleWithException(1);
            c1.setRadius(-1);
            System.out.println(c1.getRadius());
        } catch (RuntimeException ex) {
            System.out.println("RuntimeException in method()");
        } catch (Exception ex) {
            System.out.println("Exception in method()");
            throw ex;
        }
    }
}

class InvalidRadiusException extends Exception{
    public InvalidRadiusException(String t) {
        super(t);
    }
}

class CircleWithException {
    private double radius;
    private static int numberOfObjects = 0;

    public CircleWithException() throws InvalidRadiusException{
        this(1.0);
    }

    public CircleWithException(double newRadius) throws InvalidRadiusException {
        setRadius(newRadius);
        numberOfObjects++;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double newRadius) throws InvalidRadiusException {
        if (newRadius >= 0)
            radius =  newRadius;
        else
            throw new InvalidRadiusException("Radius cannot be negative");
    }

    public static int getNumberOfObjects() {
        return numberOfObjects;
    }

    public double findArea() {
        return radius * radius * 3.14159;
    }

}