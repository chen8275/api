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
  * @date 2018/8/2
  */
 public class User {
     private int id;
     private String userId;
     private String result;
     private String u_last_name;
     private String u_Pref5;
    
     
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
    
     public String getResult() {
         return result;
     }
    
     public void setResult(String result) {
         this.result = result;
     }
    
     public String getU_last_name() {
         return u_last_name;
     }
    
     public void setU_last_name(String u_last_name) {
         this.u_last_name = u_last_name;
     }
    
     public String getU_Pref5() {
         return u_Pref5;
     }
    
     public void setU_Pref5(String u_Pref5) {
         this.u_Pref5 = u_Pref5;
     }
    
     @Override
     public String toString() {
         return this.getU_last_name() +""+this.getU_Pref5();
     }
 }
