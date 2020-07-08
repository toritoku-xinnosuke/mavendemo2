package com.cjd.mysqldemo;

import java.sql.*;
import java.util.Scanner;

public class InsertDemo {
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://215.9.50.194:3306/cpsp_1?useUnicode=true&amp;characterEncoding=UTF-8&amp;rewriteBatchedStatements=true";
    //static final String DB_URL = "jdbc:mysql://localhost:3306/spring?useUnicode=true&amp;characterEncoding=UTF-8&amp;rewriteBatchedStatements=true";
    static final String USER = "root";
    static final String PASSWORD = "root";
    public static void insert(String id,String msg_name){
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try{
            Class.forName(JDBC_DRIVER);
            System.out.println("连接数据库...");
            conn = DriverManager.getConnection(DB_URL,USER,PASSWORD);
            String sql;
            sql = "insert into cpsp_msg(id,msg_name) values(?,?)";
            System.out.println("实例化Statement对象...");
            stmt = conn.prepareStatement(sql);
            stmt.setString(1,id);
            stmt.setString(2,msg_name);
            int result = stmt.executeUpdate();
            System.out.println("插入成功");

        }catch (Exception e){
            e.printStackTrace();
        }finally {
            try{
                if(conn!=null){
                    conn.close();
                }
            }catch(SQLException se){
                se.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String param = sc.nextLine();
        System.out.println(param);
        insert(param.split(" ")[0],param.split(" ")[1]);
    }
}
