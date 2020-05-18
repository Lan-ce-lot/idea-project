package work.experiment4;

import java.util.Scanner;
import java.util.ArrayList;
import java.io.File;
import java.io.PrintWriter;

public class Test2 {
    //    public static void main(String[] args) throws Exception {
//        String s = "F:\\srcRootDirectory";
//        Test2.test(s);
//    }
//
//    public static void test(String args) throws Exception {
//        File initialFile = new File(args);
//        if (!initialFile.exists()) {
//            System.out.println(args + " is not exist");
//            System.exit(2);
//        }
//        addPackage(initialFile);
//    }
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
        addPackage(initialFile);
    }

    public static void addPackage(File initialFile) throws Exception {
        if (initialFile.isFile()) {
            add(initialFile);
        } else if (initialFile.isDirectory()) {
            File[] fileList = initialFile.listFiles();
            for (File file : fileList) addPackage(file);
        }
    }

    public static void add(File file) throws Exception {
        ArrayList<String> fileContent = new ArrayList<>();
        Scanner input = new Scanner(file);
        while (input.hasNext()) {
            fileContent.add(new String(input.nextLine()));
        }

        try (PrintWriter output = new PrintWriter(file);) {
            String s = file.getParent();
            s = s.substring(s.lastIndexOf('\\') + 1);
            s = s.replace('\\', '.');

            System.out.println(s);
            output.println("package " + s + ";");
            for (String content : fileContent) output.println(content);
        }
    }
}