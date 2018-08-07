 /*
  * Copyright 2018 tuhu.cn All right reserved. This software is the
  * confidential and proprietary information of tuhu.cn ("Confidential
  * Information"). You shall not disclose such Confidential Information and shall
  * use it only in accordance with the terms of the license agreement you entered
  * into with Tuhu.cn
  */
 package com.example.demo.service.impl;

 import com.example.demo.dao.UserDao;
 import com.example.demo.entity.User;
 import com.example.demo.service.UserService;
 import org.springframework.beans.factory.annotation.Autowired;
 import org.springframework.stereotype.Service;

 import java.util.List;

 /**
  * @auther chendesheng
  * @date 2018/8/2
  */
 @Service
 public class UserServiceImpl implements UserService {
     @Autowired
    private UserDao userDao;
    
     @Override
     public List<User> selectAll(int pageindex, int pagesize) {
         return userDao.selectAll(pageindex,pagesize);
     }
    
     @Override
     public User getUserById(int id) {
         return userDao.selectById(id);
        
     }
    
     @Override
     public void changeById(String lastName, int id) { 
         userDao.updateById(lastName,id); 
         
     }
    
     @Override
     public int insertUser(User user) {
         return userDao.insert(user);
         
     }
    
 }
