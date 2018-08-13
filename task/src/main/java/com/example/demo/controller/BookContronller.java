 /*
  * Copyright 2018 tuhu.cn All right reserved. This software is the
  * confidential and proprietary information of tuhu.cn ("Confidential
  * Information"). You shall not disclose such Confidential Information and shall
  * use it only in accordance with the terms of the license agreement you entered
  * into with Tuhu.cn
  */
 package com.example.demo.controller;

 import com.example.demo.dao.BookDao;
 import com.example.demo.entity.Book;
 import com.github.pagehelper.PageHelper;
 import com.github.pagehelper.PageInfo;
 import org.springframework.beans.factory.annotation.Autowired;
 import org.springframework.web.bind.annotation.RequestMapping;
 import org.springframework.web.bind.annotation.RestController;

 import java.util.List;

 /**
  * @auther chendesheng
  * @date 2018/8/9
  */
 @RestController
 public class BookContronller {
     
     @Autowired
     BookDao bookDao;
     
     @RequestMapping("/getBookList")
     public PageInfo listBookByPage(Integer pageNum,Integer pageSize){
         PageHelper.startPage(pageNum,pageSize);
         List<Book> list = bookDao.getBookList();
         PageInfo pageInfo = new PageInfo(list);
         return pageInfo;
     }
 }
