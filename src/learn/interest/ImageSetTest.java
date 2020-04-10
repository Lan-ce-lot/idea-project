package learn.interest;

import javax.swing.*;
import java.awt.Image;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

public class ImageSetTest extends JFrame {
    private JLabel jlb = new JLabel();
    private ImageIcon icon;
    private String s;
    private int width = 450, height = 600;
    public ImageSetTest() {
        this.setSize(455, 620);
        this.setLayout(null);
        try {
                icon = new ImageIcon(new URL("http://39.107.228.31/wp-content/uploads/2020/04/wx.png"));
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        Image img = icon.getImage();
        img = img.getScaledInstance(width, height, Image.SCALE_DEFAULT);
        icon.setImage(img);
        jlb.setIcon(icon);
        this.add(jlb);
        jlb.setSize(width, height);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    public ImageSetTest(String s) {
        this.setSize(405, 620);
        this.setLayout(null);
        try {
                icon = new ImageIcon(new URL("http://39.107.228.31/wp-content/uploads/2020/04/zfb.jpg"));
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        Image img = icon.getImage();
        img = img.getScaledInstance(width, height, Image.SCALE_DEFAULT);
        icon.setImage(img);
        jlb.setIcon(icon);
        this.add(jlb);
        jlb.setSize(width, height);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    public static void qrCode(String s) {
        if (s.equals("1")) {
            new ImageSetTest();
        } else {
            new ImageSetTest("1");
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        if (in.next().equals("1")) {
            new ImageSetTest();
        } else {
            new ImageSetTest("1");
        }
    }
}
