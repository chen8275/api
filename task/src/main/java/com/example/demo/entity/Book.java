 /*
  * Copyright 2018 tuhu.cn All right reserved. This software is the
  * confidential and proprietary information of tuhu.cn ("Confidential
  * Information"). You shall not disclose such Confidential Information and shall
  * use it only in accordance with the terms of the license agreement you entered
  * into with Tuhu.cn
  */
 package com.example.demo.entity;

 import lombok.Data;

 /**
  * @auther chendesheng
  * @date 2018/8/9
  */
 @Data
 public class Book {
     
     private int id;
     private String name;
     private boolean bookSale;
    
     public int getId() {
         return id;
     }
    
     public void setId(int id) {
         this.id = id;
     }
    
     public String getName() {
         return name;
     }
    
     public void setName(String name) {
         this.name = name;
     }
    
     public boolean isBookSale() {
         return bookSale;
     }
    
     public void setBookSale(boolean bookSale) {
         this.bookSale = bookSale;
     }
 }
