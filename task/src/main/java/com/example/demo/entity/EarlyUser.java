 /*
  * Copyright 2018 tuhu.cn All right reserved. This software is the
  * confidential and proprietary information of tuhu.cn ("Confidential
  * Information"). You shall not disclose such Confidential Information and shall
  * use it only in accordance with the terms of the license agreement you entered
  * into with Tuhu.cn
  */
 package com.example.demo.entity;

 /**
  * @auther chendesheng
  * @date 2018/8/23
  */
 public class EarlyUser {
     
     private int id;
     private String userId;
     private String name;
     private String password;
    
     public int getId() {
         return id;
     }
    
     public void setId(int id) {
         this.id = id;
     }
    
     public String getUserId() {
         return userId;
     }
    
     public void setUserId(String userId) {
         this.userId = userId;
     }
    
     public String getName() {
         return name;
     }
    
     public void setName(String name) {
         this.name = name;
     }
    
     public String getPassword() {
         return password;
     }
    
     public void setPassword(String password) {
         this.password = password;
     }
 }
