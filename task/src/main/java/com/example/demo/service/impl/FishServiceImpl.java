 /*
  * Copyright 2018 tuhu.cn All right reserved. This software is the
  * confidential and proprietary information of tuhu.cn ("Confidential
  * Information"). You shall not disclose such Confidential Information and shall
  * use it only in accordance with the terms of the license agreement you entered
  * into with Tuhu.cn
  */
 package com.example.demo.service.impl;

 import com.example.demo.dao.FishMapper;
 import com.example.demo.entity.Fish;
 import com.example.demo.service.FishService;
 import org.springframework.beans.factory.annotation.Autowired;
 import org.springframework.stereotype.Service;

 import java.util.List;

 /**
  * @auther chendesheng
  * @date 2018/8/24
  */
 @Service
 public class FishServiceImpl implements FishService {
     
     @Autowired
     FishMapper fishMapper;
     
     @Override
     public List<Fish> listAllFish(int pageNum, int pageSize) {
         return fishMapper.listFish(pageNum,pageSize);
     }
 }
