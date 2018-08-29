 /*
  * Copyright 2018 tuhu.cn All right reserved. This software is the
  * confidential and proprietary information of tuhu.cn ("Confidential
  * Information"). You shall not disclose such Confidential Information and shall
  * use it only in accordance with the terms of the license agreement you entered
  * into with Tuhu.cn
  */
 package com.example.demo.dao;

 import com.example.demo.entity.EarlyUser;
 import com.example.demo.entity.User;
 import org.apache.ibatis.annotations.Mapper;
 import org.apache.ibatis.annotations.Param;
 import org.springframework.stereotype.Repository;

 import java.util.List;

 /**
  * @auther chendesheng
  * @date 2018/8/2
  */
 @Mapper
 @Repository
 public interface UserDao {
     List<User> selectAll(@Param("pageindex") int pageindex, @Param("pagesize") int pagesize);
     
     User selectById(@Param("id") int id);
     
     void updateById(@Param("lastName") String lastName,@Param("id") int id);
     
     int insert(User user);
     
     void deleteById(Integer id);
     
     List<EarlyUser> selectEarlyUser();
     
     List<User> selectUserLikeUserId(String userId);
 }
