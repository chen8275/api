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
 import com.example.demo.entity.EarlyUser;
 import com.example.demo.entity.EmployeeVo;
 import com.example.demo.entity.User;
 import com.example.demo.service.UserService;
 import org.slf4j.Logger;
 import org.slf4j.LoggerFactory;
 import org.springframework.beans.factory.annotation.Autowired;
 import org.springframework.web.bind.annotation.*;

 import javax.servlet.http.HttpServletRequest;
 import javax.servlet.http.HttpServletResponse;
 import java.util.ArrayList;
 import java.util.List;

 /**
  * @auther chendesheng
  * @date 2018/8/2
  */
 @RestController
 @RequestMapping(value = "/user")
 public class UserController {
     private Logger logger = LoggerFactory.getLogger(UserController.class);
     @Autowired
     UserService userService;
     
     @RequestMapping(value="/select",produces="application/json;charset=UTF-8")
     public JSONObject selectAll(HttpServletRequest request, HttpServletResponse response) {
        
         String pageSize=request.getParameter("pageSize");
         String pageNumber=request.getParameter("pageNumber");
         JSONObject jsonObject=new JSONObject();
         int pageNumber1 =Integer.valueOf(pageNumber);
         int pageSize1 =Integer.valueOf(pageSize);
         //StringBuffer stringBuffer = null;
         try{
            
             List<User> list= userService.selectAll((pageNumber1-1)*pageSize1,pageSize1);
             JSONArray jsonarray=(JSONArray) JSONArray.toJSON(list);
             jsonObject.put("rows",jsonarray);
             
         }catch (Exception e) {
             jsonObject.put("msgcode",500);
             e.printStackTrace();
         }
         return jsonObject;
     }
    
    @PostMapping("/getUserById")
     public JSONObject getUserById(HttpServletRequest request,HttpServletResponse response){
         String id = request.getParameter("id");
         JSONObject jsonObject = new JSONObject();
         int id1 = Integer.valueOf(id);
         try {
             List<User> list = new ArrayList<>();
             User user = userService.getUserById(id1);
             list.add(user);
             JSONArray jsonArray = (JSONArray) JSONArray.toJSON(list);
             jsonObject.put("rows",jsonArray);
         }catch (Exception e){
             jsonObject.put("msgcode",500);
             e.printStackTrace();
         }
         return jsonObject;
    }
    @PostMapping("/changeById")
     public JSONObject changeById(HttpServletRequest request,HttpServletResponse response){
         String lastName = request.getParameter("lastName");
         String id = request.getParameter("id");
         
         int id1 = Integer.valueOf(id);
         JSONObject jsonObject = new JSONObject();
         try {
             userService.changeById(lastName,id1);
             jsonObject.put("msg","修改成功");
             
         }catch (Exception e){
             jsonObject.put("msgcode","500");
             e.printStackTrace();
         }
         return jsonObject;
    }
    @PostMapping("/insertIntoTable")
     public JSONObject insertIntoTable(HttpServletRequest request,HttpServletResponse response){
         
         String userId = request.getParameter("userId");
         String lastName = request.getParameter("lastName");
         String honeyName = request.getParameter("honeyName");
         String result = request.getParameter("result");
         
         JSONObject jsonObject = new JSONObject();
         User user = new User();
        
         user.setU_last_name(lastName);
         user.setU_Pref5(honeyName);
         user.setUserId(userId);
         user.setResult(result);
         try {
             userService.insertUser(user);
             jsonObject.put("msg","插入成功");
         }catch (Exception e){
             jsonObject.put("msgcode","500");
             e.printStackTrace();
         }
         return jsonObject;
    }
    
    @RequestMapping(value = "/deleteById")
     public JSONObject delete(HttpServletRequest request,HttpServletResponse response){
         String id = request.getParameter("id");
         JSONObject jsonObject = new JSONObject();
         try {
             int id1 = Integer.valueOf(id);
             userService.deleteById(id1);
             jsonObject.put("msgcode",200);
             jsonObject.put("msg","删除成功");
             
         }catch (Exception e){
             jsonObject.put("msg","删除失败");
             e.printStackTrace();
         }
         return jsonObject; 
    }
    
    @RequestMapping("/earlyUser")
    public JSONObject selectEarlyUser(HttpServletResponse response){
         JSONObject jsonObject = new JSONObject();
         response.addHeader("Access-Control-Allow-Origin","*");
         try {
             List<EarlyUser> list = userService.selectEarlyUser();
             JSONArray jsonArray = (JSONArray)JSONArray.toJSON(list);
             jsonObject.put("msgcode:",200);
             jsonObject.put("rows:",jsonArray);
             
         }catch (Exception e){
             jsonObject.put("msgcode:","500");
             e.printStackTrace();
         }
         return jsonObject;
    }
    
    @RequestMapping("/likeUserId")
     public JSONObject like(HttpServletRequest request,HttpServletResponse response){
         
         String userId = request.getParameter("userId");
        JSONObject jsonObject = new JSONObject();
        
         try {
             List<User> list = userService.likeUserId(userId);
             JSONArray jsonArray = (JSONArray) JSONArray.toJSON(list);
             jsonObject.put("msgcode:",200);
             jsonObject.put("rows:",jsonArray);
             
         }catch (Exception e){
             jsonObject.put("msgcode:",500);
             e.printStackTrace();
         }
         return jsonObject;
    }
    
    
     @PostMapping("/save")
     public String saveEmployee(@RequestBody EmployeeVo employee){
         logger.info("获取参数信息【{},{},{}】",employee.getName(),employee.getAge(),employee.getPhone());
         return "hello";
     }
     
     
 }
