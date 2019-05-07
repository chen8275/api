 /*
  * Copyright 2018 tuhu.cn All right reserved. This software is the
  * confidential and proprietary information of tuhu.cn ("Confidential
  * Information"). You shall not disclose such Confidential Information and shall
  * use it only in accordance with the terms of the license agreement you entered
  * into with Tuhu.cn
  */
 package com.example.demo.service;

 import com.example.demo.entity.EarlyUser;
 import com.example.demo.entity.User;

 import java.util.List;

 /**
  * @auther chendesheng
  * @date 2018/8/2
  */
 public interface UserService {
     
     List<User> selectAll(int pageindex, int pagesize);
     
     User getUserById(int id);
     
     void changeById(String lastName,int id);
     
     int insertUser(User user);
     
     void deleteById(Integer id);
    
     List<EarlyUser> selectEarlyUser();
     
     List<User> likeUserId(String userId);
 }
