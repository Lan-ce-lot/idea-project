package work.work3_31;

import java.util.ArrayList;

public class Test2 {
    public static void main(String[] args) {

        String[] s = split("ab#12#453", "#");
        for (var i : s) {
            System.out.print(i + " ");
        }
        System.out.println();
        s = split("a?b?gf#e","[?#]");
//        s = split("a?b?gf#e","\\w");
        for (var i : s) {
            System.out.print(i + " ");
        }
    }

    public static String[] split(String s, String regex) {
        ArrayList<String> string = new ArrayList<String>();
        int i = 0;
        while (i < s.length()) {
            if (s.substring(i, i + 1).matches(regex)) {
                if (i != 0) string.add(s.substring(0, i));
                string.add(s.substring(i, i + 1));
                s = s.substring(i + 1, s.length());
            } else {
                i++;
            }
        }
        string.add(s);
        String[] nstring = (String[]) string.toArray(new String[string.size()]);
        return nstring;
    }
}
