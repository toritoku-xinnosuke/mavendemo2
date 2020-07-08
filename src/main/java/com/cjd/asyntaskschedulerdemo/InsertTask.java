package com.cjd.asyntaskschedulerdemo;

import java.sql.*;

public class InsertTask extends Task {
    @Override
    public boolean insert() {
        Connection conn = null;
        Statement stmt = null;
        try {
            Class.forName(JDBC_DRIVER);
            System.out.println("连接数据库...");
            conn = DriverManager.getConnection(DB_URL,USER,PASSWORD);
            System.out.println("实例化Statement对象...");
            //stmt = conn.createStatement();
            String sql;
            sql = "INSERT INTO TimerTask (username,password)VALUES(?,?)";
            //ResultSet rs =
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setString(1,"username");
            preparedStatement.setString(2,"password");
            //stmt.executeQuery(sql);
            int row = preparedStatement.executeUpdate();
            if(row > 0){
                System.out.println("success!");
            }


        }catch (ClassNotFoundException e){
            e.printStackTrace();
        }catch (SQLException e){
            e.printStackTrace();
            return false;
        }
        try{
            if(conn!=null){
                conn.close();
            }
        }catch(SQLException se){
            se.printStackTrace();
            return false;
        }
        return true;
    }
}
