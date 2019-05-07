 /*
  * Copyright 2018 tuhu.cn All right reserved. This software is the
  * confidential and proprietary information of tuhu.cn ("Confidential
  * Information"). You shall not disclose such Confidential Information and shall
  * use it only in accordance with the terms of the license agreement you entered
  * into with Tuhu.cn
  */
 package com.example.demo.dao;

 import com.example.demo.entity.Person;
 import org.springframework.data.jpa.repository.JpaRepository;

 /**
  * @auther chendesheng
  * @date 2018/8/8
  */
 
 public interface PersonRepository extends JpaRepository<Person,Long> {
     Person findById(long id);
    
     void deleteById(Long id);
     
 }
