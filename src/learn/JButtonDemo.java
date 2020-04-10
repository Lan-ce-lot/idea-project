package learn;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;
import javax.swing.*;



public class JButtonDemo extends JFrame
{
    private static int width = 400, height = 400;
    public static void wx () {
        JFrame frame=new JFrame("Java按钮组件示例");    //创建Frame窗口
        frame.setSize(400, 200);

        JLabel lblImg = new JLabel();
        lblImg.setSize(300, 100);
        frame.add(lblImg);
        Icon icon = null;
        try {
            icon = new ImageIcon(new URL("http://39.107.228.31/wp-content/uploads/2020/04/wx-746x1024.png"));
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }


        lblImg.setIcon(icon);
        frame.setLocation(300, 200);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    public static void zfb () {
        JFrame frame=new JFrame("Java按钮组件示例");    //创建Frame窗口
        frame.setSize(400, 200);

        JLabel lblImg = new JLabel();
        lblImg.setSize(300, 100);
        frame.add(lblImg);
        ImageIcon icon = null;
        try {
            icon = new ImageIcon(new URL("http://39.107.228.31/wp-content/uploads/2020/04/zfb-768x1195.jpg"));
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
//        icon.setImage(icon.getImage().getScaledInstance(width, height, icon.SCALE_DEFAULT));//可以用下面三句代码来代替
        lblImg.setIcon(icon);
        frame.setLocation(300, 200);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);

        if (in.next().equals("1")) {
            wx();
        } else {
            zfb();
        }

    }

}