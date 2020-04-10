package learn.interest;

//package example;

import java.awt.BorderLayout;
import java.awt.Container;
import java.io.File;
import javax.imageio.ImageIO;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.JApplet;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import java.awt.Image;
import java.applet.Applet;
import java.awt.Graphics;

import java.awt.Toolkit;
import javax.swing.JList;
import javax.swing.JLabel;

public class picture extends JFrame {
    ImageIcon icon = new ImageIcon();
    Image image = Toolkit.getDefaultToolkit().getImage("F:\\work\\idea\\java1\\src\\learn\\可视化报告.png");
//    Image image = Toolkit.getDefaultToolkit().getImage("http://39.107.228.31/wp-content/uploads/2020/04/mm_facetoface_collect_qrcode_1564192640897.png");
    picture() {//constructor
        this.setSize(400, 400);
        icon.setImage(image);
        JButton button = new JButton();
        button.setIcon(icon);

        this.getContentPane().add(button);
        this.setVisible(true);

    }

    //---------------------------------------------------
    public static void main(String[] args) {
        new picture();
    }
}