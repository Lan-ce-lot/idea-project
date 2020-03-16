package work3_16;

/**
 * Get Rand char.
 *
 * @author Lance
 * @version 1.00 2020-03-08
 */
public class test1 {
    public static void main(String[] args) {
        RandChar();
    }
    static void RandChar() {
        System.out.println((char)('a' + Math.random() * ('z' - 'a' + 1)));
    }
}