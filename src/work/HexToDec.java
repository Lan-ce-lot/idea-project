package work;

import java.util.Scanner;

public class HexToDec {
    public static void main (String[] args)
    {
        Scanner in = new Scanner(System.in);
        System.out.print("输入十六进制数: ");
        String hexString = in.nextLine();
        int hex_V = 0;
        for (int i = 0; i < hexString.length(); i++) {
            char ch = Character.toUpperCase(hexString.charAt(i));
            if (ch >= 'A' && ch <= 'F') {
                hex_V = hex_V * 16 + (ch - 'A' + 10);
            } else {
                hex_V = hex_V * 16 + (ch - '0');
            }
        }
        System.out.println("十进制是： " + hex_V);
    }
}
