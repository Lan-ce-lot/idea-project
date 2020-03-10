package work3_10;

import java.util.Arrays;

/**
 * A program for viewing images.
 *
 * @author Lance
 * @version 1.00 2020-03-08
 */
public class Array {
    public static void main(String[] args) {
        double[] myList = {1.9, 2.9, 3.4};
        double[] yourList = new double[3];
        for (var i : myList) {
            System.out.println(i);
        }
        System.out.println(Arrays.toString(myList));
        System.arraycopy(myList, 0, yourList, 0, 3);
        for (var i : yourList) {
            System.out.println(i);
        }
    }
}