package com.cjd.localtest;



import java.sql.*;

public class JdbcTest {
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost:3306/spring";
    static final String USER = "root";
    static final String PASSWORD = "123456";

    public static void main(String[] args) {
        Connection conn = null;
        Statement stmt = null;
        try {
            Class.forName(JDBC_DRIVER);
            System.out.println("连接数据库...");
            conn = DriverManager.getConnection(DB_URL,USER,PASSWORD);
            System.out.println("实例化Statement对象...");
            stmt = conn.createStatement();
            String sql;
            sql = "SELECT * FROM user ";
            ResultSet rs = stmt.executeQuery(sql);
//            ResultSet rs = stmt.executeQuery(new testInterface(){
//                @Override
//                public String createSql(){
//                    retr "SELECT * FROM user ";
//                }
//            })
            while (rs.next()){
                int id = rs.getInt("id");
                String name = rs.getString("name");
                int age = rs.getInt("age");
                String address = rs.getString("address");
                System.out.println("id" + id + ";name" + name + ",age" + age + ",address" + address);
            }
        }catch (ClassNotFoundException e){
            e.printStackTrace();
        }catch (SQLException e){
            e.printStackTrace();
        }
        try{
            if(conn!=null){
                conn.close();
            }
            }catch(SQLException se){
            se.printStackTrace();
        }
    }
}
