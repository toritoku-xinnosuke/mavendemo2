package com.cjd.asyntaskschedulerdemo;

import java.sql.*;

public class SelectTask extends Task{
    @Override
    public boolean select() {
        Connection conn = null;
        Statement stmt = null;
        try {
            Class.forName(JDBC_DRIVER);
            System.out.println("连接数据库...");
            conn = DriverManager.getConnection(DB_URL,USER,PASSWORD);
            System.out.println("实例化Statement对象...");
            stmt = conn.createStatement();
            String sql;
            sql = "SELECT * FROM timertask t ORDER BY t.userid DESC limit 1";
            ResultSet rs = stmt.executeQuery(sql);
//            ResultSet rs = stmt.executeQuery(new testInterface(){
//                @Override
//                public String createSql(){
//                    retr "SELECT * FROM user ";
//                }
//            })
            while (rs.next()){
                int userid = rs.getInt("userid");
                String username = rs.getString("username");
                String password = rs.getString("password");
                System.out.println("id" + userid + ";name" + username + ";password" + password);
            }
        }catch (ClassNotFoundException e){
            e.printStackTrace();
            return false;
        }catch (SQLException e){
            e.printStackTrace();
            return false;
        }
        try{
            if(conn!=null){
                conn.close();
                return true;
            }
        }catch(SQLException se){
            se.printStackTrace();
            return false;
        }
        return true;
    }



}
