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
  * @date 2018/8/7
  */
 public class HelloUser {
     private Long id;
     private String name;
     private Integer age;
    
     public Long getId() {
         return id;
     }
    
     public void setId(Long id) {
         this.id = id;
     }
    
     public String getName() {
         return name;
     }
    
     public void setName(String name) {
         this.name = name;
     }
    
     public Integer getAge() {
         return age;
     }
    
     public void setAge(Integer age) {
         this.age = age;
     }
 }
