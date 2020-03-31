package work.experiment2;

import org.apache.commons.httpclient.Header;

import org.apache.commons.httpclient.HttpClient;

import org.apache.commons.httpclient.NameValuePair;

import org.apache.commons.httpclient.methods.PostMethod;

/**
 * A program for viewing images.
 *
 * @author Lance
 * @version 1.00 2020-03-08
 */



public class Sms {

    public static void main(String[] args) throws Exception {

        HttpClient client = new HttpClient();

        PostMethod post = new PostMethod("http://sms.webchinese.cn/web_api/");

        post.addRequestHeader("Content-Type","application/x-www-form-urlencoded;charset=gbk");// 在头文件中设置转码

        NameValuePair[] data = {

                new NameValuePair("Uid", "lancelot1"), // 注册的用户名

                new NameValuePair("Key", "d41d8cd98f00b204e980"), // 注册成功后,登录网站使用的密钥

                new NameValuePair("smsMob", "19914665732"), // 手机号码

                new NameValuePair("smsText", "尊敬的用户" + "您的会员办理成功, 会员号是:") };//设置短信内容

        post.setRequestBody(data);

        client.executeMethod(post);

        Header[] headers = post.getResponseHeaders();

        int statusCode = post.getStatusCode();

        System.out.println("statusCode:" + statusCode); //statusCode=200表示请示成功！

        for (Header h : headers) {

            System.out.println(h.toString());

        }

        String result = new String(post.getResponseBodyAsString().getBytes("gbk")); //设置编码格式

        System.out.println(result);

        post.releaseConnection();

    }

}
