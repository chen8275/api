 /*
  * Copyright 2018 tuhu.cn All right reserved. This software is the
  * confidential and proprietary information of tuhu.cn ("Confidential
  * Information"). You shall not disclose such Confidential Information and shall
  * use it only in accordance with the terms of the license agreement you entered
  * into with Tuhu.cn
  */
 package com.example.demo.controller;

 import com.example.demo.entity.Person;
 import com.example.demo.service.PersonService;

 import org.springframework.beans.factory.annotation.Autowired;
 import org.springframework.stereotype.Controller;
 import org.springframework.ui.Model;
 import org.springframework.web.bind.annotation.RequestMapping;

 import java.util.List;

 /**
  * @auther chendesheng
  * @date 2018/8/8
  */
 @Controller
 public class PersonController {
     @Autowired
     PersonService personService;
     
     @RequestMapping("/")
     public String index() {
         return "redirect:/list";
     }
     
     @RequestMapping("/list")
     public String listPerson(Model model){
         List<Person> persons = personService.getPersonList();
         model.addAttribute("persons",persons);
         return "user/list";
     }
     
     @RequestMapping("/toEdit")
     public String editPerson(Model model,Long id){
         Person person = personService.findPersonById(id);
         model.addAttribute("person",person);
         return "user/personEdit";
     }
     @RequestMapping("/edit")
     public String edit(Person person){
         personService.update(person);
         return "redirect:/list";
     }
     
     @RequestMapping("/delete")
     public String deletePerson(long id){
         personService.delete(id);
         return "redirect:/list";
     }
     @RequestMapping("/toAdd")
     public String toAdd(){
         return "user/personAdd";
     }
     @RequestMapping("/add")
     public String personAdd(Person person){
         personService.save(person);
         return "redirect:/list";
     }
     
     
 }
