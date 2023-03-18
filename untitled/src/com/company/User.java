package com.company;

import java.util.Date;

public class User {
    private String phone;
    private String name;
    private String surname;
    private String password;
    private Date create;

    User(String phone, String name, String password){
        this.phone = phone;
        this.name = name;
        this.password = password;
        this.create = new Date();
    }

    public Date getCreate(){
        return create;
    }
}