 /*
  * Copyright 2018 tuhu.cn All right reserved. This software is the
  * confidential and proprietary information of tuhu.cn ("Confidential
  * Information"). You shall not disclose such Confidential Information and shall
  * use it only in accordance with the terms of the license agreement you entered
  * into with Tuhu.cn
  */
 package com.example.demo.service.impl;

 import com.example.demo.dao.PersonRepository;
 import com.example.demo.entity.Person;
 import com.example.demo.service.PersonService;
 import org.springframework.beans.factory.annotation.Autowired;
 import org.springframework.stereotype.Service;

 import java.util.List;

 /**
  * @auther chendesheng
  * @date 2018/8/8
  */
 @Service
 public class PersonServiceImpl implements PersonService {
     @Autowired
     PersonRepository personRepository;
     
     @Override
     public List<Person> getPersonList() {
         return personRepository.findAll();
     }
    
     @Override
     public Person findPersonById(long id) {
         return personRepository.findById(id);
     }
    
     @Override
     public void save(Person perosn) { 
         personRepository.save(perosn);
     }
    
     @Override
     public void update(Person perosn) {
         personRepository.save(perosn);
     }
    
     @Override
     public void delete(long id) {
         personRepository.deleteById(id);
     }
 }
