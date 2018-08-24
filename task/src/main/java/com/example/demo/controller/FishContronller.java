 /*
  * Copyright 2018 tuhu.cn All right reserved. This software is the
  * confidential and proprietary information of tuhu.cn ("Confidential
  * Information"). You shall not disclose such Confidential Information and shall
  * use it only in accordance with the terms of the license agreement you entered
  * into with Tuhu.cn
  */
 package com.example.demo.controller;

 import com.alibaba.fastjson.JSONArray;
 import com.alibaba.fastjson.JSONObject;
 import com.example.demo.entity.Fish;
 import com.example.demo.service.FishService;
 import org.springframework.beans.factory.annotation.Autowired;
 import org.springframework.web.bind.annotation.RequestMapping;
 import org.springframework.web.bind.annotation.RestController;

 import javax.servlet.http.HttpServletRequest;
 import javax.servlet.http.HttpServletResponse;
 import java.util.List;

 /**
  * @auther chendesheng
  * @date 2018/8/24
  */
 @RestController
 @RequestMapping("/fish")
 public class FishContronller {
     
     @Autowired
     FishService fishService;
     
     @RequestMapping(value = "/fishs")
     public JSONObject getFishs(HttpServletRequest request, HttpServletResponse response){
         
         int pageNum = Integer.valueOf(request.getParameter("pageNum"));
         int pageSize = Integer.valueOf(request.getParameter("pageSize"));
         JSONObject jsonObject = new JSONObject();
         JSONArray jsonArray = null;
         
         try {
             List<Fish> list = fishService.listAllFish( pageNum*(pageSize - 1),pageSize);
             jsonArray = (JSONArray) JSONArray .toJSON(list);
             jsonObject.put("msgcode:",200);
             jsonObject.put("rows:",jsonArray);
             
         }catch (Exception e){
             e.printStackTrace();
             jsonObject.put("msgcode:",500);
         }
         return jsonObject;
     }
 }
