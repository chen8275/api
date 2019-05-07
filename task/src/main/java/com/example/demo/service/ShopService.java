 /*
  * Copyright 2018 tuhu.cn All right reserved. This software is the
  * confidential and proprietary information of tuhu.cn ("Confidential
  * Information"). You shall not disclose such Confidential Information and shall
  * use it only in accordance with the terms of the license agreement you entered
  * into with Tuhu.cn
  */
 package com.example.demo.service;

 import com.example.demo.entity.Shop;

 import java.util.List;

 /**
  * @auther chendesheng
  * @date 2018/10/31
  */
 public interface ShopService {
     
     int insertShop(Shop shop);
     List<Shop> listAllShop(int pageNum,int pageSize);
     int updateShopById(String name,int id);
     int deleteShopById(int id);
 }
