package work.work4_27;

/**
 * A program for viewing images.
 *
 * @author Lance
 * @version 1.00 2020-03-08
 */
public class Test {
    static void method()throws Exception {

        try {

            String s="abc";

            System.out.println(s.charAt(3));

        }

        catch(RuntimeException ex){

            System.out.println("RuntimeException in method()");

        }

        catch(Exception ex){

            System.out.println("Exception in method()");

        }

    }

    public static void main(String[] args){

    }

}