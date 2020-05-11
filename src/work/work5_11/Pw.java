package work.work5_11;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * A program for viewing images.
 *
 * @author Lance
 * @version 1.00 2020-03-08
 */
public class Pw {
    public static void main(String[] args) throws FileNotFoundException {
//        java.io.File f = new java.io.File("src\\work\\work5_11\\1.txt");
        java.io.File f = new java.io.File("11.txt");
        System.out.println(f.exists());

        java.io.PrintWriter output = new java.io.PrintWriter(f);
        output.print("HCS\n");
        output.print("HCS11\n" +
                "12");
        output.close();

        Scanner s = new Scanner(f);

        System.out.println(s.nextLine());
        System.out.println(s.nextLine());
        System.out.println(s.nextInt());

        s.close();
    }
}