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
 import com.github.pagehelper.PageHelper;
 import com.github.pagehelper.PageInfo;
 import lombok.extern.slf4j.Slf4j;
 import org.springframework.beans.factory.annotation.Autowired;
 import org.springframework.cache.annotation.Cacheable;
 import org.springframework.web.bind.annotation.*;

 import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

 /**
  * @auther chendesheng
  * @date 2018/8/24
  */
 @RestController
 @RequestMapping("/fish")
 @Slf4j
 public class FishContronller {
     
     @Autowired
     FishService fishService;
    
     @GetMapping("/allFish")
     public List<Fish> allFish(@RequestParam(defaultValue = "1") int pageNo, @RequestParam(defaultValue = "10") int pageSize){
         PageHelper.startPage(pageNo,pageSize);
         return fishService.list();
     }
     
     @GetMapping("/allFishs")
     public PageInfo<Fish> getAllFishs(@RequestParam(defaultValue = "1") int pageNo, @RequestParam(defaultValue = "10") int pageSize){
         PageHelper.startPage(pageNo,pageSize);
         PageInfo<Fish> pageInfo = new PageInfo<>(fishService.list());
         return pageInfo;
     }
     
     
     
     @RequestMapping(value = "/fishs")
     @Cacheable(cacheNames = "fish",key = "123")
     public JSONObject getFishs(HttpServletRequest request, HttpServletResponse response){
         response.addHeader("Access-Control-Allow-Origin","*");
         int pageNum = Integer.valueOf(request.getParameter("pageNum"));
         int pageSize = Integer.valueOf(request.getParameter("pageSize"));
         JSONObject jsonObject = new JSONObject();
         JSONArray jsonArray = null;
         
         try {
             List<Fish> list = fishService.listAllFish( pageNum*(pageSize - 1),pageSize);
             log.info("fish大小：[{}]",list.size());
             jsonArray = (JSONArray) JSONArray .toJSON(list);
             jsonObject.put("msgcode:",200);
             jsonObject.put("rows:",jsonArray);
             
         }catch (Exception e){
             e.printStackTrace();
             jsonObject.put("msgcode:",500);
         }
         return jsonObject;
     }
     
     @RequestMapping("/insert")
     public JSONObject insertFish(HttpServletRequest request,HttpServletResponse response){
         int id = Integer.valueOf(request.getParameter("id"));
         String name = request.getParameter("name");
         String publishName = request.getParameter("publishName");
         float price = Float.valueOf(request.getParameter("price"));
         JSONObject jsonObject = new JSONObject();
         
         Fish fish = new Fish();
         fish.setId(id);
         fish.setName(name);
         fish.setPublishname(publishName);
         fish.setPrice(price);
         int fishNumber = 0;
         try {
             fishNumber = fishService.insertFish(fish);
         }catch (Exception e) {
             e.printStackTrace();
         }
         if(fishNumber == -1){
             jsonObject.put("msgcode:","插入失败");
             jsonObject.put("fishNumber:",fishNumber+"");
         }else{
             jsonObject.put("msgcode:","插入成功");
             jsonObject.put("fishNumber:",fishNumber+"");
         }
         return jsonObject;
     }
     
     
     
     @RequestMapping("/insertFish")
     public JSONObject insertFish(@RequestBody  Fish fish){
         JSONObject jsonObject = new JSONObject();
         int fishNumber = 0;
         try {
             
             fishNumber = fishService.insertFish(fish);
             
         }catch (Exception e){
             e.printStackTrace();
         }
         if(fishNumber == -1){
             jsonObject.put("msgcode:","插入失败");
             jsonObject.put("fishNumber:",fishNumber+"");
         }else{
             jsonObject.put("msgcode:","插入成功");
             jsonObject.put("fishNumber:",fishNumber+"");
         }
         return jsonObject;
     }
     
     @RequestMapping("/count")
     @Cacheable(cacheNames = "fish",key = "345")
     public JSONObject countFish(){
         JSONObject jsonObject = new JSONObject();
         try {
             int count = fishService.count();
             jsonObject.put("count:",count);
             jsonObject.put("msgcode:",200);
         }catch (Exception e){
             e.printStackTrace();
             jsonObject.put("msgcode:",500);
         }
         return jsonObject;
     }
     
     @RequestMapping("/update")
     public JSONObject update(HttpServletRequest request,HttpServletResponse response){
         JSONObject jsonObject = new JSONObject();
         String name = request.getParameter("name");
         int id = Integer.parseInt(request.getParameter("id"));
         try {
             int num = fishService.updateFishById(name,id);
             jsonObject.put("num:",num);
             jsonObject.put("msg:","更新成功！");
         }catch (Exception e){
             e.printStackTrace();
             jsonObject.put("msgcode:",500);
         }
         return jsonObject;
     }
     
     @RequestMapping("/select")
     public JSONObject select(HttpServletRequest request,HttpServletResponse response){
         JSONObject jsonObject = new JSONObject();
         String name = request.getParameter("name");
         String publishName =  request.getParameter("publishName");
         int pageIndex = Integer.parseInt(request.getParameter("pageIndex"));
         int pageSize = Integer.parseInt(request.getParameter("pageSize"));
         
          try {
              
              List<Fish> list = fishService.select(name,publishName,pageSize*(pageIndex-1),pageSize);
              JSONArray jsonArray = (JSONArray) JSONArray.toJSON(list);
              jsonObject.put("msgcode:",200);
              jsonObject.put("rows:",jsonArray);
              
          }catch (Exception e){
              jsonObject.put("msgcode:",500);
              e.printStackTrace();
          }
         return jsonObject;
     }
 }
