package opp;

/**
 * A program for viewing images.
 *
 * @author Lance
 * @version 1.00 2020-03-08
 */

import com.sun.mail.util.MailSSLSocketFactory;

import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import java.security.GeneralSecurityException;
import java.util.Properties;
import java.util.Scanner;
public class ly{
public static void main(String [] args) throws GeneralSecurityException {

// 收件人电子邮箱
        String to = "1617025845@qq.com";

                // 发件人电子邮箱
                String from = "1771071860@qq.com";

                // 指定发送邮件的主机为 smtp.qq.com
                String host = "smtp.qq.com";  //QQ 邮件服务器

                // 获取系统属性
                Properties properties = System.getProperties();

                // 设置邮件服务器
                properties.setProperty("mail.smtp.host", host);

                properties.put("mail.smtp.auth", "true");
                MailSSLSocketFactory sf = new MailSSLSocketFactory();
                sf.setTrustAllHosts(true);
                properties.put("mail.smtp.ssl.enable", "true");
                properties.put("mail.smtp.ssl.socketFactory", sf);
                // 获取默认session对象
                Session session = Session.getDefaultInstance(properties,new Authenticator(){
public PasswordAuthentication getPasswordAuthentication()
        {
        return new PasswordAuthentication("1771071860@qq.com", "zlitczrqwfexdfbb"); //发件人邮件用户名、密码
        }
        });

        try{
        // 创建默认的 MimeMessage 对象
        MimeMessage message = new MimeMessage(session);

        // Set From: 头部头字段
            try {
                message.setFrom(new InternetAddress(from));
            } catch (MessagingException e) {
                e.printStackTrace();
            }

            // Set To: 头部头字段
        message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));

        // Set Subject: 头部头字段
        message.setSubject("This is the Subject Line!");

        // 创建消息部分
        BodyPart messageBodyPart = new MimeBodyPart();

        // 消息
        messageBodyPart.setText("This is message body");

        // 创建多重消息
        Multipart multipart = new MimeMultipart();

        // 设置文本消息部分
        multipart.addBodyPart(messageBodyPart);

        // 附件部分
        messageBodyPart = new MimeBodyPart();
        String filename = "mysql命令.txt";
        FileDataSource source = new FileDataSource(filename);
        messageBodyPart.setDataHandler(new DataHandler(source));
        messageBodyPart.setFileName(filename);
        multipart.addBodyPart(messageBodyPart);

        // 发送完整消息
        message.setContent(multipart );

        //发送消息
        Transport.send(message);
        System.out.println("Sent message successfully....from laiyan");
        }catch (MessagingException mex) {
        mex.printStackTrace();
        }
        }}