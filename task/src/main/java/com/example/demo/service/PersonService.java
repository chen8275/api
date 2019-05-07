 /*
  * Copyright 2018 tuhu.cn All right reserved. This software is the
  * confidential and proprietary information of tuhu.cn ("Confidential
  * Information"). You shall not disclose such Confidential Information and shall
  * use it only in accordance with the terms of the license agreement you entered
  * into with Tuhu.cn
  */
 package com.example.demo.service;

 import com.example.demo.entity.Person;

 import java.util.List;

 /**
  * @auther chendesheng
  * @date 2018/8/8
  */
 public interface PersonService {
     
     public List<Person> getPersonList();
     
     public Person findPersonById(long id);
     
     public void save(Person perosn);
     
     public void update(Person perosn);
     
     public void delete(long id);
 }
