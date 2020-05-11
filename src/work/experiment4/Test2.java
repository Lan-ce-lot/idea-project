package work.experiment4;

/**
 * A program for viewing images.
 *
 * @author Lance
 * @version 1.00 2020-03-08
 */

import java.util.Scanner;
import java.util.ArrayList;
import java.io.File;
import java.io.PrintWriter;

public class Test2 {
    public static void main(String[] args) throws Exception {
        if (args.length != 1) {
            System.out.println("Useage srcRootDirectory");
            System.exit(1);
        }

        File initialFile = new File(args[0]);
        if (!initialFile.exists()) {
            System.out.println(args[0] + " is not exist");
            System.exit(2);
        }
//      System.out.println(initialFile.isFile());
//      System.out.println(initialFile.isDirectory());
//      System.out.println(initialFile.getParent());
//     用流来读取的时候只能读取文件，不能读取文件夹
        addPackage(initialFile);
    }

    public static void addPackage(File initialFile) throws Exception {
        if (initialFile.isFile()) {
            add(initialFile);
        } else if (initialFile.isDirectory()) {
            File[] fileList = initialFile.listFiles();
            for (File file : fileList) {
                addPackage(file);
            }
        }
    }

    public static void add(File file) throws Exception {
        ArrayList<String> fileContent = new ArrayList<>();
        Scanner input = new Scanner(file);
        while (input.hasNext()) {
            fileContent.add(new String(input.nextLine()));
        }

        try (
                PrintWriter output = new PrintWriter(file);
        ) {
            output.println("//" + file.getParent());
            for (String content : fileContent) {
                output.println(content);
            }
        }
    }
}