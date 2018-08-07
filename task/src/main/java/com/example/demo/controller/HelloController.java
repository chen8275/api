 /*
  * Copyright 2018 tuhu.cn All right reserved. This software is the
  * confidential and proprietary information of tuhu.cn ("Confidential
  * Information"). You shall not disclose such Confidential Information and shall
  * use it only in accordance with the terms of the license agreement you entered
  * into with Tuhu.cn
  */
 package com.example.demo.controller;

 import org.springframework.stereotype.Controller;
 import org.springframework.ui.ModelMap;
 import org.springframework.web.bind.annotation.RequestMapping;
 import org.springframework.web.bind.annotation.RestController;

 /**
  * @auther chendesheng
  * @date 2018/8/7
  */
 @Controller
 public class HelloController {
     
     @RequestMapping("/hello")
     public String index(){
         return "Hello world !";
     }
     
     @RequestMapping("/")
     public String index(ModelMap map){
         map.addAttribute("host","http://blog.didispace.com");
         return "index";
     }
 }
