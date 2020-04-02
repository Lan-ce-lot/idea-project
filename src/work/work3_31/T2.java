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
            if (s.substring(i, i + 1).matches(regex)) {// 若匹配
                res[con++] = s.substring(flag, i);// 将分隔符之前的字符放入数组
                res[con++] = s.substring(i, i + 1);// 将分隔符放入数组
                flag = i + 1;
            }
            if (i == s.length() - 1 && flag != s.length()) res[con++] = s.substring(flag, s.length());
        }
        return java.util.Arrays.copyOf(res, con);// 返回字符串数组的非null部分
    }
}