 /*
  * Copyright 2019 tuhu.cn All right reserved. This software is the
  * confidential and proprietary information of tuhu.cn ("Confidential
  * Information"). You shall not disclose such Confidential Information and shall
  * use it only in accordance with the terms of the license agreement you entered
  * into with Tuhu.cn
  */
 package com.example.demo.entity;

 import lombok.AllArgsConstructor;
 import lombok.Data;
 import lombok.NoArgsConstructor;

 /**
  * @auther chendesheng
  * @date 2019/1/28
  */
 @Data
 @AllArgsConstructor
 @NoArgsConstructor
 public class EmployeeVo{
     
     private String name;
     private String age;
     private String phone;
     
 }
