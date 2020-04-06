package work.experiment2;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import java.util.Properties;

public class SendFileEmail
{
    public static void main(String[] args) {
        send("1984737645@qq.com");
    }
    public static void send(String to) {
        // 收件人电子邮箱
//        String to = "1984737645@qq.com";
        // 发件人电子邮箱
        String from = "1617025845@qq.com";
        // 指定发送邮件的主机为 smtp.qq.com
        String host = "smtp.qq.com";  //QQ 邮件服务器
        // 获取系统属性
        Properties properties = System.getProperties();
        // 设置邮件服务器
        properties.setProperty("mail.smtp.host", host);
        properties.put("mail.smtp.auth", "true");
        // 获取默认session对象
        Session session = Session.getDefaultInstance(properties,new Authenticator(){
            public PasswordAuthentication getPasswordAuthentication()
            {
                return new PasswordAuthentication("1617025845@qq.com", "gfvmlbfyulkjfafa");
            }
        });

        try{
            // 创建默认的 MimeMessage 对象。
            MimeMessage message = new MimeMessage(session);
            // Set From: 头部头字段
            message.setFrom(new InternetAddress(from));
            // Set To: 头部头字段
            message.addRecipient(Message.RecipientType.TO,
                    new InternetAddress(to));
            // Set Subject: 头字段
            message.setSubject("KFC一周可视化报告");
            // 创建消息部分
            BodyPart messageBodyPart = new MimeBodyPart();
            // 消息
            messageBodyPart.setText("尊敬的用户，请查收一周单品销售次数可视化报告");
            // 创建多重消息
            Multipart multipart = new MimeMultipart();
            // 设置文本消息部分
            multipart.addBodyPart(messageBodyPart);
            // 附件部分
            messageBodyPart = new MimeBodyPart();
            String filename = "F:\\work\\idea\\java1\\src\\work\\experiment2\\可视化图.png";

            DataSource source = new FileDataSource(filename);
            messageBodyPart.setDataHandler(new DataHandler(source));
            messageBodyPart.setFileName(filename);
            multipart.addBodyPart(messageBodyPart);
            // 发送完整消息
            message.setContent(multipart );
            // 发送消息
            Transport.send(message);
            System.out.println("电子邮件发送成功....");
        }catch (MessagingException mex) {
            mex.printStackTrace();
        }
    }

    public static void send(String to, String number) {
        // 收件人电子邮箱
//        String to = "1984737645@qq.com";
        // 发件人电子邮箱
        String from = "1617025845@qq.com";
        // 指定发送邮件的主机为 smtp.qq.com
        String host = "smtp.qq.com";  //QQ 邮件服务器
        // 获取系统属性
        Properties properties = System.getProperties();
        // 设置邮件服务器
        properties.setProperty("mail.smtp.host", host);
        properties.put("mail.smtp.auth", "true");
        // 获取默认session对象
        Session session = Session.getDefaultInstance(properties,new Authenticator(){
            public PasswordAuthentication getPasswordAuthentication()
            {
                return new PasswordAuthentication("1617025845@qq.com", "gfvmlbfyulkjfafa");
            }
        });

        try{
            // 创建默认的 MimeMessage 对象。
            MimeMessage message = new MimeMessage(session);
            // Set From: 头部头字段
            message.setFrom(new InternetAddress(from));
            // Set To: 头部头字段
            message.addRecipient(Message.RecipientType.TO,
                    new InternetAddress(to));
            // Set Subject: 头字段
            message.setSubject("KFC自助软件:会员办理提示");
            // 创建消息部分
            BodyPart messageBodyPart = new MimeBodyPart();
            // 消息
            messageBodyPart.setText("尊敬的用户, 您的会员办理成功, 会员号是:" + number);
            // 创建多重消息
            Multipart multipart = new MimeMultipart();
            // 设置文本消息部分
            multipart.addBodyPart(messageBodyPart);
            // 发送完整消息
            message.setContent(multipart );
            // 发送消息
            Transport.send(message);
            System.out.println("电子邮件发送成功....");
        }catch (MessagingException mex) {
            mex.printStackTrace();
        }
    }
}