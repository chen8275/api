 /*
  * Copyright 2018 tuhu.cn All right reserved. This software is the
  * confidential and proprietary information of tuhu.cn ("Confidential
  * Information"). You shall not disclose such Confidential Information and shall
  * use it only in accordance with the terms of the license agreement you entered
  * into with Tuhu.cn
  */
 package com.example.demo.service.impl;

 import com.example.demo.dao.DepartmentMapper;
 import com.example.demo.entity.Department;
 import com.example.demo.service.DepartmentService;
 import org.springframework.beans.factory.annotation.Autowired;
 import org.springframework.stereotype.Service;

 import java.util.List;
 import java.util.Map;

 /**
  * @auther chendesheng
  * @date 2018/8/29
  */
 @Service
 public class DepartmentServiceImpl implements DepartmentService {
     @Autowired
     DepartmentMapper departmentMapper;
     @Override
     public List<Department> listAllDepartmentByNameOrPassword(String name, String password) {
         return departmentMapper.listDepartment(name,password);
     }
    
     @Override
     public List<Department> dynamicForeach(List<Integer> ids) {
         return departmentMapper.dynamicForeachTest(ids);
     }
    
     
 }
