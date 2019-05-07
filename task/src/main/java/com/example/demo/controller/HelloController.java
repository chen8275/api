 /*
  * Copyright 2018 tuhu.cn All right reserved. This software is the
  * confidential and proprietary information of tuhu.cn ("Confidential
  * Information"). You shall not disclose such Confidential Information and shall
  * use it only in accordance with the terms of the license agreement you entered
  * into with Tuhu.cn
  */
 package com.example.demo.controller;

 import com.example.demo.entity.Fish;
import com.example.demo.service.FishService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
 import org.springframework.web.bind.annotation.ResponseBody;

 import java.util.List;

 /**
  * @auther chendesheng
  * @date 2018/8/7
  */
 @Controller
 public class HelloController {
     @Autowired
     FishService fishService;
     
    @RequestMapping("/what")
     public String what(){
         return "Hello world !";
     }
      /*
     @RequestMapping("/")
     public String index(ModelMap map){
         map.addAttribute("host","http://blog.didispace.com");
         return "index";
     }*/

   
     @RequestMapping("/index")
     public String index(Model model){
       model.addAttribute("name","老王");
       model.addAttribute("data","<span style='color:red'>老王是吃货</span>");
       model.addAttribute("age","18");
       return "/fish/index";
   }
     @RequestMapping("/fishList")
     public String fishList(Model model){
       List<Fish> list = fishService.listAllFish(2,2);
       model.addAttribute("fishs",list);
       return "/fish/list";
   }
   
   
   @RequestMapping("/isAcceptOrder")
   @ResponseBody
    public boolean isAcceptOrder(){
         return true;
   }  
   
   
 }
