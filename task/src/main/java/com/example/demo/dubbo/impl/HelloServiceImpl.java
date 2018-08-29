 /*
  * Copyright 2018 tuhu.cn All right reserved. This software is the
  * confidential and proprietary information of tuhu.cn ("Confidential
  * Information"). You shall not disclose such Confidential Information and shall
  * use it only in accordance with the terms of the license agreement you entered
  * into with Tuhu.cn
  */
 package com.example.demo.dubbo.impl;

 import com.alibaba.dubbo.config.annotation.Service;
 import com.example.demo.dubbo.HelloService;

 /**
  * @auther chendesheng
  * @date 2018/8/23
  */
 //因每次启动都要打开zookeeeper server，所以关闭dubbo服务。
     
 /*@Service(version = "1.0.0")
 public class HelloServiceImpl implements HelloService {
    
     @Override
     public String helloService(String name) {
         return "hello:"+name;
     }
 }
*/