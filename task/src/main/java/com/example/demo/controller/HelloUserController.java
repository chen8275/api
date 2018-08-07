 /*
  * Copyright 2018 tuhu.cn All right reserved. This software is the
  * confidential and proprietary information of tuhu.cn ("Confidential
  * Information"). You shall not disclose such Confidential Information and shall
  * use it only in accordance with the terms of the license agreement you entered
  * into with Tuhu.cn
  */
 package com.example.demo.controller;

 import com.example.demo.entity.User;
 import org.springframework.web.bind.annotation.*;

 import java.util.*;

 /**
  * @auther chendesheng
  * @date 2018/8/7
  */
 @RestController
 @RequestMapping("/HelloUser")
 public class HelloUserController {
     static Map<Integer,User> users = Collections.synchronizedMap(new HashMap<Integer, User>());
     @RequestMapping(value="/", method=RequestMethod.GET)
     public List<User> getUserList() {
         // 处理"/users/"的GET请求，用来获取用户列表 
         // 还可以通过@RequestParam从页面中传递参数来进行查询条件或者翻页信息的传递 
         List<User> r = new ArrayList<User>(users.values());
         return r;
     }
    
     @RequestMapping(value="/", method=RequestMethod.POST)
     public String postUser(@ModelAttribute User user) {
         // 处理"/users/"的POST请求，用来创建User 
         // 除了@ModelAttribute绑定参数之外，还可以通过@RequestParam从页面中传递参数 
         users.put(user.getId(), user);
         return "success";
     }
    
     @RequestMapping(value="/{id}", method=RequestMethod.GET)
     public User getUser(@PathVariable Long id) {
         // 处理"/users/{id}"的GET请求，用来获取url中id值的User信息 
         // url中的id可通过@PathVariable绑定到函数的参数中 
         return users.get(id);
     }
    
     @RequestMapping(value="/{id}", method=RequestMethod.PUT)
     public String putUser(@PathVariable Integer id, @ModelAttribute User user) {
         // 处理"/users/{id}"的PUT请求，用来更新User信息 
         User u = users.get(id);
         u.setName(user.getName());
         u.setAge(user.getAge());
         users.put(id, u);
         return "success";
     }
    
     @RequestMapping(value="/{id}", method=RequestMethod.DELETE)
     public String deleteUser(@PathVariable Integer id) {
         // 处理"/users/{id}"的DELETE请求，用来删除User 
         users.remove(id);
         return "success";
     }
 }
