package com.cjd.localtest;

public class testInterfaceImpl implements testInterface{
    @Override
    public String createSql() {
        return "impl";
    }
}
