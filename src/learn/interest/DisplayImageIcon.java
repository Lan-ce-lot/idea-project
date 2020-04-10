package learn.interest;

/**
 * A program for viewing images.
 *
 * @author Lance
 * @version 1.00 2020-03-08
 */
import java.net.MalformedURLException;
import java.net.URL;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class DisplayImageIcon extends JFrame {

    private JLabel lblImg;
    private Icon icon;

    public DisplayImageIcon() {

        setTitle("swing显示图片");
        setSize(330, 300);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        lblImg = new JLabel();
        add(lblImg);
        setVisible(true);

        try {
            icon = new ImageIcon(new URL("http://39.107.228.31/wp-content/uploads/2020/04/wx-746x1024.png"));
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        lblImg.setIcon(icon);

    }

    public static void main(String[] args) {
        new DisplayImageIcon();
    }
}