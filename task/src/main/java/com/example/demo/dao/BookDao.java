 /*
  * Copyright 2018 tuhu.cn All right reserved. This software is the
  * confidential and proprietary information of tuhu.cn ("Confidential
  * Information"). You shall not disclose such Confidential Information and shall
  * use it only in accordance with the terms of the license agreement you entered
  * into with Tuhu.cn
  */
 package com.example.demo.dao;

 import com.example.demo.entity.Book;
 import com.github.pagehelper.Page;
 import org.apache.ibatis.annotations.Mapper;
 import org.apache.ibatis.annotations.Select;

 import java.util.List;

 /**
  * @auther chendesheng
  * @date 2018/8/9
  */
 @Mapper
 public interface BookDao {
     @Select("SELECT * FROM BOOK")
     List<Book> getBookList();
 }
