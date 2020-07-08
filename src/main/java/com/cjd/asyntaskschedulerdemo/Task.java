package com.cjd.asyntaskschedulerdemo;

public abstract class Task {
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost:3306/spring";
    static final String USER = "root";
    static final String PASSWORD = "123456";
    public boolean insert(){
        return true;
    }
    public boolean select(){
        return true;
    }
}
