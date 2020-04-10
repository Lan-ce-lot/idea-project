package learn.interest;

/**
 * A program for viewing images.
 *
 * @author Lance
 * @version 1.00 2020-03-08
 */

//package test;

import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 * 使用JLabel支持html显示图片
 * @author wasw100
 */
public class DisplayImageHtml extends JFrame {

    private JLabel lblImg;

    public DisplayImageHtml() {

        setTitle("swing显示图片");
        setSize(1000, 600);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        lblImg = new JLabel();
        add(lblImg);
        setVisible(true);

        lblImg.setText("<html><center><img src='http://39.107.228.31/wp-content/uploads/2020/04/mm_facetoface_collect_qrcode_1564192640897.png' /></center><html>");
    }

    public static void main(String[] args) {
        new DisplayImageHtml();
    }
}