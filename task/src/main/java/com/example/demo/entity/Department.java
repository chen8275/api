package com.example.demo.entity;

public class Department {
    private Integer id;

    private String userid;

    private String name;

    private String password;

    public Department(Integer id, String userid, String name, String password) {
        this.id = id;
        this.userid = userid;
        this.name = name;
        this.password = password;
    }

    public Department() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid == null ? null : userid.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }
}