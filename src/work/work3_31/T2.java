package work.work3_31;

public class T2 {
    public static void main(String[] args) {
        String[] s = split("ab#12#453", "#");
        for (var i : s) {
            System.out.print(i + " ");
        }
        System.out.println();
        s = split("a?b?gf#e","[?#]");
        for (var i : s) {
            System.out.print(i + " ");
        }
    }
    public static String[] split(String s, String regex) {
        String[] res = new String[100];
        int con = 0;
        for (int i = 0, flag = 0; i < s.length(); i++) {
            if (s.substring(i, i + 1).matches(regex)) {
                res[con++] = s.substring(flag, i);
                res[con++] = s.substring(i, i + 1);
                flag = i + 1;
            }
        }
        return java.util.Arrays.copyOf(res, con);
    }
}