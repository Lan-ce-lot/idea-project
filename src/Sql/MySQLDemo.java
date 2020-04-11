package Sql;

import java.sql.*;

public class MySQLDemo {
    // MySQL 8.0 以上版本 - JDBC 驱动名及数据库 URL
    static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost:3306/会员?useSSL=false&serverTimezone=UTC";
    static Connection conn = null;
    static Statement stmt = null;
    static String sql;
    // 数据库的用户名与密码，需要根据自己的设置
    static final String USER = "root";
    static final String PASS = "161702";

    public static void inster(String inid, String inname, String innamem, String innum, String inem) {
        try{
            // 注册 JDBC 驱动
            Class.forName(JDBC_DRIVER);
            // 打开链接
            System.out.println("连接数据库...");
            conn = DriverManager.getConnection(DB_URL,USER,PASS);

            // 执行查询
            System.out.println("实例化Statement对象...");
            stmt = conn.createStatement();

            sql = "INSERT INTO `会员表` \n" +
                    "VALUES ('" + inid + "','" + inname + "','" + innamem + "','" + innum + "','" + inem + "');";
            int i = stmt.executeUpdate(sql);
            sql = "SELECT * FROM 会员表";
            ResultSet rs = stmt.executeQuery(sql);
            // 完成后关闭
            rs.close();
            stmt.close();
            conn.close();
        }catch(SQLException se){
            // 处理 JDBC 错误
            se.printStackTrace();
        }catch(Exception e){
            // 处理 Class.forName 错误
            e.printStackTrace();
        }finally{
            // 关闭资源
            try{
                if(stmt!=null) stmt.close();
            }catch(SQLException se2){
            }// 什么都不做
            try{
                if(conn!=null) conn.close();
            }catch(SQLException se){
                se.printStackTrace();
            }
        }
        System.out.println("数据库关闭");
    }
    public static boolean query(String inid) {
        boolean flag = false;
        try{
            // 注册 JDBC 驱动
            Class.forName(JDBC_DRIVER);
            // 打开链接
            System.out.println("连接数据库...");
            conn = DriverManager.getConnection(DB_URL,USER,PASS);
            // 执行查询
            System.out.println("实例化Statement对象...");
            stmt = conn.createStatement();
            sql = "SELECT 会员号 FROM 会员表;";
            ResultSet rs = stmt.executeQuery(sql);
            // 展开结果集数据库
            while(rs.next()){
                // 通过字段检索
                String id  = rs.getString("会员号");
                if (id.equals(inid)) {
                    flag = true;
                }
                // 输出数据
                System.out.print("会员号: " + id);
                System.out.print("\n");
            }
            // 完成后关闭
            rs.close();
            stmt.close();
            conn.close();
        }catch(SQLException se){
            se.printStackTrace();
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            try{
                if(stmt!=null) stmt.close();
            }catch(SQLException se2){
            }// 什么都不做
            try{
                if(conn!=null) conn.close();
            }catch(SQLException se){
                se.printStackTrace();
            }
        }
        System.out.println("数据库关闭");
        return flag;
    }
    public static void main(String[] args) {
        inster("12345679", "黄", "昌盛", "19914665732", "1617025845@qq.com");
        System.out.println(query("1234567"));
    }
}