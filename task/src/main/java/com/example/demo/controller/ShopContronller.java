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
 import com.example.demo.entity.Shop;
 import com.example.demo.service.ShopService;
 import org.springframework.beans.factory.annotation.Autowired;
 import org.springframework.web.bind.annotation.RequestMapping;
 import org.springframework.web.bind.annotation.RestController;

 import javax.servlet.http.HttpServletRequest;
 import javax.servlet.http.HttpServletResponse;
 import java.util.List;

 /**
  * @auther chendesheng
  * @date 2018/10/31
  */
 @RestController
 @RequestMapping("/shop")
 public class ShopContronller {
     @Autowired
     ShopService shopService;
     
     @RequestMapping("/insert")
     public JSONObject insertShop(HttpServletRequest request, HttpServletResponse response){
         int id = Integer.valueOf(request.getParameter("id"));
         String name = request.getParameter("name");
         String location = request.getParameter("location");
         
         JSONObject jsonObject = new JSONObject();
         Shop shop = new Shop();
         shop.setId(id);
         shop.setName(name);
         shop.setLocation(location);
         int shopNumber = 0;
         try {
             shopNumber = shopService.insertShop(shop);
         }catch (Exception e){
             e.printStackTrace();
         }
         if(shopNumber == -1){
             
             jsonObject.put("msgcode:","插入失败");
             jsonObject.put("fishNumber:",shopNumber+"");
         }else{
             jsonObject.put("msgcode:","插入成功");
             jsonObject.put("fishNumber:",shopNumber+"");
         }
         return jsonObject;
     }
     
     @RequestMapping("/list")
     public JSONObject listShops(int pageNum,int pageSize){
         
         JSONObject jsonObject = new JSONObject();
         JSONArray jsonArray = null;
         try{
             List<Shop> list = shopService.listAllShop(pageNum*(pageSize-1),pageSize);
             jsonArray = (JSONArray) JSONArray .toJSON(list);
             jsonObject.put("msg",200);
             jsonObject.put("rows",jsonArray);
         }catch (Exception e){
             e.printStackTrace();
             jsonObject.put("magcode",500);
         }
         return jsonObject;
     }
     @RequestMapping("/update")
     public JSONObject updateShop(String name,int id){
         JSONObject jsonObject = new JSONObject();
         
         try {
             int updateNum = shopService.updateShopById(name,id);
             jsonObject.put("num:",updateNum);
             jsonObject.put("msg:","更新成功！");
         }catch (Exception e){
             e.printStackTrace();
             jsonObject.put("msgcode:",500);
         }
         return jsonObject;
     }
     @RequestMapping("/delete")
     public JSONObject deleteShop(int id){
         JSONObject jsonObject = new JSONObject();
         try {
             int num = shopService.deleteShopById(id);
             jsonObject.put("msgcode",200);
             jsonObject.put("msg","删除成功");
         }catch (Exception e){
             e.printStackTrace();
             jsonObject.put("msgcode","删除失败");
         }
         return jsonObject;
     }
     
 }
