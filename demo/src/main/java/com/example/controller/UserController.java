package com.example.controller;

import com.example.model.User;
import com.example.demo.service.UserService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    UserService userService;

    @RequestMapping("/addUser")
    public int addUser(String id, String name, String sex, int age, String mobile) {
        return userService.insert(id, name, sex, age, mobile);
    }

    @RequestMapping("/findUser")
    public User findUser(String name) {
        User user = userService.findByName(name);
        return user;
    }


    @RequestMapping("/userlist")
    public Object userList(int page,int pageSize){
        return userService.getUserList(page,pageSize);
    }

}
