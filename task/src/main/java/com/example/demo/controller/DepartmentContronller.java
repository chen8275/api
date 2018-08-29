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
 import com.example.demo.entity.Department;
 import com.example.demo.service.DepartmentService;
 import org.springframework.beans.factory.annotation.Autowired;
 import org.springframework.web.bind.annotation.RequestMapping;
 import org.springframework.web.bind.annotation.RestController;
 import org.w3c.dom.ls.LSException;

 import javax.servlet.http.HttpServletRequest;
 import javax.servlet.http.HttpServletResponse;
 import java.util.ArrayList;
 import java.util.List;

 /**
  * @auther chendesheng
  * @date 2018/8/29
  */
 @RestController
 @RequestMapping("/department")
 public class DepartmentContronller {
     @Autowired
     DepartmentService departmentService;
     
     @RequestMapping("/listDepartment")
     public JSONObject list(HttpServletRequest request, HttpServletResponse response){
         String name = request.getParameter("name");
         String password = request.getParameter("password");
         JSONObject jsonObject = new JSONObject();
         try {
             List<Department> list = departmentService.listAllDepartmentByNameOrPassword(name,password);
             JSONArray jsonArray = (JSONArray) JSONArray.toJSON(list);
             jsonObject.put("msgcode:",200);
             jsonObject.put("rows:",jsonArray);
             
         }catch (Exception e){
             jsonObject.put("msgcode:",500);
             e.printStackTrace();
         }
         return jsonObject;
     }
     
     @RequestMapping("/foreach")
     public JSONObject foreachItem(HttpServletRequest request, HttpServletResponse response){
         JSONObject jsonObject = new JSONObject();
         List<Integer> list = new ArrayList<>();
         list.add(1);
         list.add(2);
         list.add(3);
         try {
          List<Department> departmentList = departmentService.dynamicForeach(list);
          JSONArray jsonArray = (JSONArray) JSONArray.toJSON(departmentList);
          jsonObject.put("msgcode:",200);
          jsonObject.put("rows:",jsonArray);
          
         }catch (Exception e){
             jsonObject.put("msgcode:",500);
             e.printStackTrace();
         }
         return jsonObject;
     }
 }
