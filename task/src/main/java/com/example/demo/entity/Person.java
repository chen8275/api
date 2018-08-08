 /*
  * Copyright 2018 tuhu.cn All right reserved. This software is the
  * confidential and proprietary information of tuhu.cn ("Confidential
  * Information"). You shall not disclose such Confidential Information and shall
  * use it only in accordance with the terms of the license agreement you entered
  * into with Tuhu.cn
  */
 package com.example.demo.entity;

 import javax.persistence.Column;
 import javax.persistence.Entity;
 import javax.persistence.GeneratedValue;
 import javax.persistence.Id;

 /**
  * @auther chendesheng
  * @date 2018/8/7
  */
 @Entity
 public class Person {
     @Id
     @GeneratedValue
     private long id;
     @Column(nullable = false, unique = true)
     private String userName;
     @Column(nullable = false)
     private String password;
     @Column(nullable = false)
     private int age;
    
     public long getId() {
         return id;
     }
    
     public Person setId(long id) {
         this.id = id;
         return this;
     }
    
     public String getUserName() {
         return userName;
     }
    
     public Person setUserName(String userName) {
         this.userName = userName;
         return this;
     }
    
     public String getPassword() {
         return password;
     }
    
     public Person setPassword(String password) {
         this.password = password;
         return this;
     }
    
     public int getAge() {
         return age;
     }
    
     public Person setAge(int age) {
         this.age = age;
         return this;
     }
 }
