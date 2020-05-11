package work.work5_11;

import java.io.File;

/**
 * A program for viewing images.
 *
 * @author Lance
 * @version 1.00 2020-03-08
 */
public class Fi {
    public static void main(String[] args) {
//        File f = new File("F:\\work\\idea\\java1\\src\\work\\work5_11\\1.txt");
        File f = new File("src\\work\\work5_11\\1.txt");
        System.out.println(f.exists());
        System.out.println(f.isAbsolute()); // 绝对路径
        System.out.println(f.canRead()); // 可读
        System.out.println(f.isDirectory()); // 是否是一个目录
        System.out.println(f.getPath());
        System.out.println(f.isFile());

        System.out.println(f.getName());
        System.out.println(f.getAbsolutePath());
        System.out.println(f.getParent());
        System.out.println(f.lastModified()); // 最近修改的时间
        System.out.println(f.length());
        System.out.println(f.listFiles());


    }
}